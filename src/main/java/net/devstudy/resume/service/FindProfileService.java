package net.devstudy.resume.service;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.repository.storage.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FindProfileService extends AbstractService{

    @Autowired
    ProfileRepository profileRepository;

    public Profile findByUid(String uid){
        Profile profile = profileRepository.findByUid(uid);
        return profile;
    }

    public Page<Profile> findAll(Pageable pageable) {
        Page<Profile> profiles = profileRepository.findAll(pageable);
        return profiles;
    }
}
