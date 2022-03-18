package net.devstudy.resume.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "skill_category")
public class SkillCategory extends AbstractEntity{
    @Column(nullable = false, length = 50)
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
