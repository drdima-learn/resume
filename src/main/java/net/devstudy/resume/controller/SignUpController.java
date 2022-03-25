package net.devstudy.resume.controller;

import net.devstudy.resume.entity.Profile;
import net.devstudy.resume.form.SignUpForm;
import net.devstudy.resume.service.EditProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignUpController extends AbstractController {


    @Autowired
    EditProfileService editProfileService;

    @GetMapping
    public String getSignUp(Model model) {
        model.addAttribute("signUpForm", new SignUpForm());
        return "signup";
    }

    @PostMapping
    public String postSignUp(@Valid @ModelAttribute SignUpForm signUpForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            LOGGER.debug("form has an error");
            return "signup";

            /*
            Object[] arguments = new Object[1];
            arguments[0] = new Object();
            String[] codes = new String[1];
            codes[0] = "signUpForm.password";


            bindingResult.addError(
                    new FieldError(
                            "signUpForm",
                            "password",
                            "3",
                            false,
                            codes,
                            arguments,
                            "fieldError.getDefaultMessage()"));


            //model.addAttribute("password.error", bindingResult.getFieldValue("password"));

             */
        }
        Profile profile = editProfileService.createNewProfile(signUpForm);

        return redirect("/" + profile.getUid());
    }


}
