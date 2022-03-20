package net.devstudy.resume.controller;

import net.devstudy.resume.entity.SkillCategory;
import net.devstudy.resume.repository.storage.SkillCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/edit")
public class EditProfileController extends AbstractController{


    @Autowired
    private SkillCategoryRepository skillCategoryRepository;

    @GetMapping
    public String getEdit() {
        return "edit";
    }

    @GetMapping("/skills")
    public String getEditSkills(Model model) {
        List<SkillCategory> skillCategoryList = skillCategoryRepository.findAll(Sort.by("id"));
        LOGGER.debug("SkillCategories: {}",skillCategoryList);
        model.addAttribute("skillCategoryList", skillCategoryList);
        return "edit-skills";
    }
}
