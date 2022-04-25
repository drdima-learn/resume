package net.devstudy.resume.service;

import net.devstudy.resume.entity.jpa.Profile;

import net.devstudy.resume.entity.elastic.ProfileElastic;
import net.devstudy.resume.repository.search.ProfileSearchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.IndexOperations;
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


            for(Profile p : findProfileService.findAllForIndexing()){
                profileSearchRepository.save(p.getProfileElastic());

                LOGGER.info("Successful indexing of profile" + p.getUid());
            }
            LOGGER.info("Finish index of profiles");
        }
        else {
            LOGGER.info("indexingAllDuringStartup is disabled");
        }
    }

}
