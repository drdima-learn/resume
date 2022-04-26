package net.devstudy.resume.repository.search;

import net.devstudy.resume.entity.elastic.ProfileElastic;
import net.devstudy.resume.entity.jpa.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface ProfileSearchRepository extends ElasticsearchRepository<ProfileElastic, Integer> {

    Page<ProfileElastic> findByObjectiveLikeOrSummaryLikeOrPracticsCompanyLikeOrPracticsPositionLike(
            String objective,
            String summary,
            String practicCompany,
            String practicPosition,
            Pageable pageable
    );


}
