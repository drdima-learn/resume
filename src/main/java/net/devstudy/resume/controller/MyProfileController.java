package net.devstudy.resume.controller;

import net.devstudy.resume.model.CurrentProfile;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyProfileController extends AbstractController {
    @GetMapping(value = "/my-profile")
    public String getMyProfile(@AuthenticationPrincipal CurrentProfile currentProfile) {
        return redirect("/" + currentProfile.getUsername());
    }


}
