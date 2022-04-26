package net.devstudy.resume.service;

import net.devstudy.resume.entity.elastic.ProfileElastic;
import net.devstudy.resume.entity.jpa.Profile;
import net.devstudy.resume.repository.search.ProfileSearchRepository;
import net.devstudy.resume.repository.storage.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FindProfileService extends AbstractService{

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    ProfileSearchRepository profileSearchRepository;

    public Profile findByUid(String uid){
        Profile profile = profileRepository.findByUid(uid);
        return profile;
    }

    public Page<Profile> findAll(Pageable pageable) {
        Page<Profile> profiles = profileRepository.findAll(pageable);
        return profiles;
    }

    @Transactional
    public Iterable<Profile> findAllForIndexing(){
        Iterable<Profile> all = profileRepository.findAll();
        for(Profile p : all){
            p.getSkills().size();
            p.getCertificates().size();
            p.getLanguages().size();
            p.getPractics().size();
            p.getCourses().size();
        }
        return all;
    }

    public Page<ProfileElastic> findbySearchQuery(String query, Pageable pageable){
        return profileSearchRepository.findByObjectiveLikeOrSummaryLikeOrPracticsCompanyLikeOrPracticsPositionLike(
                query,query,query,query,pageable
        );
    }
}
