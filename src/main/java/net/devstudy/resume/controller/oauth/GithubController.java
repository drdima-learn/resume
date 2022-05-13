package net.devstudy.resume.controller.oauth;

import com.restfb.types.User;
import net.devstudy.resume.controller.AbstractController;
import net.devstudy.resume.controller.URL;
import net.devstudy.resume.entity.jpa.Profile;
import net.devstudy.resume.model.oauth.GithubEmail;
import net.devstudy.resume.service.impl.SocialService;
import net.devstudy.resume.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class GithubController extends AbstractController {
    @Autowired
    private SocialService<String> githubSocialService;

    @GetMapping(value = {"/fromGithub"})
    public String fromGithub(OAuth2AuthenticationToken authentication) {

        String email = githubSocialService.getSocialIdentifier(authentication);
        Profile p = githubSocialService.loginViaSocialNetwork(email);
        if (p != null) {
            SecurityUtil.authentificate(p);
            return redirect(URL.MY_PROFILE);
        } else {
            return redirect(URL.SIGN_IN);
        }
    }

}
