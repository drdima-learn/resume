package net.devstudy.resume.controller.oauth;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.scope.ExtendedPermissions;
import com.restfb.scope.ScopeBuilder;
import com.restfb.types.User;
import net.devstudy.resume.controller.AbstractController;
import net.devstudy.resume.controller.URL;
import net.devstudy.resume.entity.jpa.Profile;
import net.devstudy.resume.service.impl.SocialService;
import net.devstudy.resume.util.SecurityUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class FacebookController extends AbstractController {

    @Value("${social.facebook.idClient}")
    private String idClient;

    @Value("${social.facebook.secret}")
    private String secret;

    private String redirectUrl;

    @Value("${app.host}")
    public void setRedirectUrl(String appHost) {
        this.redirectUrl = appHost + "/fromFb";
    }

    @Autowired
    private SocialService<User> facebookSocialService;


    private String getAuthorizedUrl() {
        ScopeBuilder scopeBuilder = new ScopeBuilder();
        scopeBuilder.addPermission(ExtendedPermissions.EMAIL);
        FacebookClient client = new DefaultFacebookClient(Version.VERSION_2_6);
        return client.getLoginDialogUrl(idClient, redirectUrl, scopeBuilder);
    }

    @GetMapping("/fbLogin")
    public String gotoFacebook() {
        return redirect(getAuthorizedUrl());
    }

    @GetMapping(value = {"/fromFb"})
    public String fromFb(@RequestParam(value = "code", required = false) String code) {
        if (StringUtils.isBlank(code)) {
            return redirect(URL.SIGN_IN);
        }
        FacebookClient client = new DefaultFacebookClient(Version.VERSION_2_6);
        FacebookClient.AccessToken accessToken = client.obtainUserAccessToken(
                idClient, secret, redirectUrl, code);
        client = new DefaultFacebookClient(accessToken.getAccessToken(), Version.VERSION_2_6);
        User user = client.fetchObject("me", User.class, Parameter.with("fields", "name,email,first_name,last_name"));
        Profile p = facebookSocialService.loginViaSocialNetwork(user);
        if (p != null) {
            SecurityUtil.authentificate(p);
            return redirect(URL.MY_PROFILE);
        } else {
            return redirect(URL.SIGN_IN);
        }


    }

}
