package net.devstudy.resume.repository.search;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.entity.Test01;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


public interface ProfileSearchRepository extends ElasticsearchRepository<Test01, Integer> {
//    Page<Profile> findByObjectiveLikeOrSummaryLikeOrPracticsCompanyLikeOrPracticsPositionLike(
//            String objective,
//            String summary,
//            String practicCompany,
//            String practicPosition,
//            Pageable pageable
//    );


}
