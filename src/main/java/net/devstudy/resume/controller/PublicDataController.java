package net.devstudy.resume.controller;

import net.devstudy.resume.Constants;
import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.service.FindProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

@Controller
public class PublicDataController extends AbstractController {

    @Autowired
    private FindProfileService findProfileService;

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
                          @PageableDefault(size = Constants.MAX_PROFILE_PER_PAGE)
                          @SortDefault(sort = "id")
                                  Pageable pageable,
                          HttpServletRequest request
    ){
        if (isWelcome(request)){
            pageable = PageRequest.of(0, Constants.MAX_PROFILE_PER_PAGE, Sort.by("id"));
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

//    @GetMapping("/fragment/more")
//    public String moreProfiles(Model model,
//                          @PageableDefault(size = Constants.MAX_PROFILE_PER_PAGE)
//                          @SortDefault(sort = "id")
//                                  Pageable pageable
//    ) throws UnsupportedEncodingException {
//        Page<Profile> profiles = findProfileService.findAll(pageable);
//        model.addAttribute("profiles",profiles.getContent());
//        return "fragment/profile-items";
//
//
//    }
}
