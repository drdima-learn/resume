package net.devstudy.resume.controller;

import net.devstudy.resume.Constants;
import net.devstudy.resume.entity.jpa.Profile;
import net.devstudy.resume.model.CurrentProfile;
import net.devstudy.resume.service.FindProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class PublicDataController extends AbstractController {

    @Autowired
    private FindProfileService findProfileService;

    @GetMapping(value = "/")
    public String getIndex(){
        return redirect("/welcome");
    }

    @GetMapping(value = "/{uid}")
    public String getProfile(@PathVariable String uid, Model model) {
        Profile profile = findProfileService.findByUid(uid);
        model.addAttribute("profile", profile);
        return "profile";
    }

    @GetMapping("favicon.ico")
    @ResponseBody
    public void disableFavicon() {
        //Method is void to avoid browser 404 issue by returning nothing in the response.
    }

    @GetMapping(value = {"/welcome", "/fragment/more"})
    public String listAll(Model model,
                          @PageableDefault(size = Constants.UI.MAX_PROFILE_PER_PAGE)
                          @SortDefault(sort = "id")
                                  Pageable pageable,
                          HttpServletRequest request
    ){
        if (isWelcome(request)){
            pageable = PageRequest.of(0, Constants.UI.MAX_PROFILE_PER_PAGE, Sort.by("id"));
        }
        Page<Profile> profiles = findProfileService.findAll(pageable);
        model.addAttribute("profiles",profiles.getContent());
        model.addAttribute("page",profiles);
        return listAllPage(request);
    }

    private boolean isWelcome(HttpServletRequest request){
        String uri = request.getRequestURI();
        if (uri.equals("/welcome")){
            return true;
        }
        return false;
    }

    private String listAllPage(HttpServletRequest request){
        if (isWelcome(request)){
            return "profiles";
        } else {
            return "fragment/profile-items";
        }
    }

    @GetMapping(value = "/sign-in")
    public String signIn(@AuthenticationPrincipal CurrentProfile currentProfile){
        if (currentProfile!=null){
            return redirect(URL.MY_PROFILE);
        }
        return "sign-in";
    }

    @GetMapping(value = "/sign-in-failed")
    public String signInFailed(HttpSession session){
        if (session.getAttribute("SPRING_SECURITY_LAST_EXCEPTION")==null){
            return redirect("/sign-in");
        }
        return "sign-in";
    }


}
