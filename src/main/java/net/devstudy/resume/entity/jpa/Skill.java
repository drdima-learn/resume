package net.devstudy.resume.entity.jpa;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.devstudy.resume.annotation.constraints.EnglishLanguage;
import net.devstudy.resume.entity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(name = "skill")
public class Skill extends AbstractEntity {

    @Column(name = "category", length = 255)
    @EnglishLanguage
    @Size(min = 1)
    private String category;

    @Column(name = "value", length = 2147483647)
    @EnglishLanguage
    @Size(min = 1)
    private String value;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile", nullable = false)
    private Profile profile;

    @Transient
    public Skill getSkillWoProfile() {
        Skill skill = new Skill();
        skill.setId(getId());
        skill.setCategory(getCategory());
        skill.setValue(getValue());
        skill.setProfile(null);
        return skill;
    }

    @Transient
    public static List<Skill> getSkillsWoProfile(List<Skill> skills) {
        List<Skill> skillsWoProfile = new ArrayList<>();
        for(Skill s : skills){
            skillsWoProfile.add(s.getSkillWoProfile());
        }
        return skillsWoProfile;
    }


}
