package net.devstudy.resume.controller;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.repository.storage.ProfileRepository;
import net.devstudy.resume.service.FindProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PublicDataController extends AbstractController{

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
}
