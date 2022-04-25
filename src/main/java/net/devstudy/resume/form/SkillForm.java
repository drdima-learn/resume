package net.devstudy.resume.form;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.devstudy.resume.entity.jpa.Skill;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
public class SkillForm {
    @Valid
    private List<Skill> items = new ArrayList<>();

    public SkillForm(List<Skill> items) {
        this.items = items;
    }
}
