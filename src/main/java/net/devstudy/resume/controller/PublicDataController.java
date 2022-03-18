package net.devstudy.resume.controller;

import net.devstudy.resume.service.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PublicDataController {

    @Autowired
    private NameService nameService;

    @GetMapping(value = "/{uid}")
    public String getProfile(@PathVariable String uid, Model model) throws Exception {
        //throw new Exception();
        String fullName = nameService.convertName(uid);
        model.addAttribute("fullName", fullName);
        return "profile";
    }

//    @GetMapping("/error")
//    public String getError(){
//        return "error";
//    }
}
