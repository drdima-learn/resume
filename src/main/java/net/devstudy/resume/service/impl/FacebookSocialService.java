package net.devstudy.resume.service.impl;

import com.restfb.types.User;
import net.devstudy.resume.entity.jpa.Profile;
import net.devstudy.resume.repository.storage.ProfileRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class FacebookSocialService implements SocialService<User> {

    @Autowired
    private ProfileRepository profileRepository;

    @Override
    public Profile loginViaSocialNetwork(User model) {
        if (StringUtils.isNotBlank(model.getEmail())){
            Profile p = profileRepository.findByEmail(model.getEmail());
            if (p !=null){
                return p;
            }
        }

        //TODO signup here
        return null;
    }

    @Override
    public String getSocialIdentifier(OAuth2AuthenticationToken authentication) {
        return null;
    }
}
