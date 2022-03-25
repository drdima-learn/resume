package net.devstudy.resume.controller;

import net.devstudy.resume.entity.Skill;
import net.devstudy.resume.entity.SkillCategory;
import net.devstudy.resume.form.SkillForm;
import net.devstudy.resume.repository.storage.ProfileRepository;
import net.devstudy.resume.repository.storage.SkillCategoryRepository;
import net.devstudy.resume.service.EditProfileService;
import net.devstudy.resume.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/edit")
public class EditProfileController extends AbstractController{

    @Autowired
    private EditProfileService editProfileService;


    @GetMapping
    public String getEdit() {
        return "edit";
    }

    @GetMapping("/skills")
    public String getEditSkills(Model model) {
        List<Skill> skillList = editProfileService.getSkills(SecurityUtil.getCurrentIdProfile());
        SkillForm skillForm = new SkillForm(skillList);
        model.addAttribute("skillForm", skillForm);
        return gotoSkillsJSP(model);
    }

    @PostMapping("/skills")
    public String saveEditSkills(@Valid @ModelAttribute("skillForm") SkillForm form, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            return gotoSkillsJSP(model);
        }
        // TODO update skills
        editProfileService.updateSkills(SecurityUtil.getCurrentIdProfile(), form.getItems());
        return redirect("/aly-dutta");
    }

    private String gotoSkillsJSP(Model model) {
        List<SkillCategory> skillCategoryList = editProfileService.getSkillCategoryList();
        LOGGER.debug("SkillCategories: {}",skillCategoryList);
        model.addAttribute("skillCategoryList", skillCategoryList);
        return "edit/skills";
    }
}
