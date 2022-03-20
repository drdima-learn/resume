package net.devstudy.resume.controller;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.repository.storage.ProfileRepository;
import net.devstudy.resume.service.NameService;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;

@Controller
public class PublicDataController {

    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping(value = "/{uid}")
    public String getProfile(@PathVariable String uid, Model model)  {


        Profile profile = profileRepository.findByUid(uid);
        model.addAttribute("profile", profile);
        return "profile";
    }

//    @GetMapping("/error")
//    public String getError(){
//        return "error";
//    }

//    @GetMapping(value = "/favicon.ico")
//    public byte[] getFavicon() throws IOException {
//        InputStream in = getClass()
//                .getResourceAsStream("/net/devstudy/resume/favicon.ico");
//        return IOUtils.toByteArray(in);
//    }

//    @GetMapping("favicon.ico")
//    public String favicon() {
//        return "forward:/favicon.ico";
//    }

    @GetMapping("favicon.ico")
    @ResponseBody
    public void disableFavicon() {
        //Method is void to avoid browser 404 issue by returning nothing in the response.
    }
}
