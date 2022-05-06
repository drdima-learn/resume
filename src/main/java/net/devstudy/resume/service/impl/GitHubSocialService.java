package net.devstudy.resume.service.impl;

import net.devstudy.resume.entity.jpa.Profile;
import net.devstudy.resume.model.oauth.GithubEmail;
import net.devstudy.resume.repository.storage.ProfileRepository;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GitHubSocialService implements SocialService<String> {

    @Autowired
    private ProfileRepository profileRepository;

    @Autowired
    private OAuth2AuthorizedClientService authorizedClientService;




    @Override
    public Profile loginViaSocialNetwork(String email) {
        if (StringUtils.isNotBlank(email)) {
            Profile p = profileRepository.findByEmail(email);
            if (p != null) {
                return p;
            }
        }

        //TODO signup here
        return null;
    }

    @Override
    public String getSocialIdentifier(OAuth2AuthenticationToken authentication) {
        OAuth2AuthorizedClient client = authorizedClientService.loadAuthorizedClient(
                authentication.getAuthorizedClientRegistrationId(),
                authentication.getPrincipal().getName());

        String getEmailUrl = "https://api.github.com/user/emails";

        // send HTTP request to get user emails
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + client.getAccessToken().getTokenValue());
        HttpEntity entity = new HttpEntity("", headers);

        //ResponseEntity<String> response = restTemplate.exchange(getEmailUrl, HttpMethod.GET, entity, String.class);
        //Object aa = response.getBody();
        ResponseEntity<GithubEmail[]> githubEmails = restTemplate.exchange(getEmailUrl, HttpMethod.GET, entity, GithubEmail[].class);
        String email = githubEmails.getBody()[0].getEmail();
        // https://www.jsonschema2pojo.org/

        return email;


    }
}
