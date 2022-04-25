package net.devstudy.resume.entity.jpa;

import lombok.Getter;
import lombok.ToString;
import net.devstudy.resume.entity.AbstractEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "skill_category")
@Getter
@ToString(callSuper=true, includeFieldNames=true)
public class SkillCategory extends AbstractEntity {
    @Column(nullable = false, length = 50)
    private String category;

//    @Override
//    public String toString() {
//        return String.format("%s[id=%s, category=%s]",getClass().getSimpleName() , getId(),getCategory());
//    }
}
