package net.devstudy.resume.service;

import net.devstudy.resume.entity.Profile;

import net.devstudy.resume.entity.ProfileElastic;
import net.devstudy.resume.entity.Test01;
import net.devstudy.resume.repository.search.ProfileSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class ElasticSearchIndexingService extends AbstractService {

    @Value("${index.all.during.startup}")
    private boolean indexAllDuringStartup;

    @Autowired
    private ProfileSearchRepository profileSearchRepository;

    @Autowired
    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    private FindProfileService findProfileService;

    @PostConstruct
    private void postConstruct() {
        if (indexAllDuringStartup) {
            LOGGER.info("Detected index all command");
            LOGGER.info("Clear old index");
            elasticsearchOperations.deleteIndex(ProfileElastic.class);
            LOGGER.info("Start index of profiles");

            //Test01 test01 = new Test01("1",2,3);
            //profileSearchRepository.save(test01);

            for(Profile p : findProfileService.findAllForIndexing()){

                ProfileElastic profileElastic = new ProfileElastic();
                profileElastic.setId(123);
                profileElastic.setFirstName("Vasya");

                profileSearchRepository.save(profileElastic);

                LOGGER.info("Successful indexing of profile" + p.getUid());
                break;
            }
            LOGGER.info("Finish index of profiles");
        }
        else {
            LOGGER.info("indexingAllDuringStartup is disabled");
        }
    }

}
