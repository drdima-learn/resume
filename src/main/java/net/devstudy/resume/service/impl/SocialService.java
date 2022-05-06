package net.devstudy.resume.service.impl;

import net.devstudy.resume.entity.jpa.Profile;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;

public interface SocialService<T> {

    Profile loginViaSocialNetwork(T model);
    String getSocialIdentifier(OAuth2AuthenticationToken authentication);
}
