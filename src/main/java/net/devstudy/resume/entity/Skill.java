package net.devstudy.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import net.devstudy.resume.annotation.constraints.EnglishLanguage;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Getter @Setter @EqualsAndHashCode(callSuper = true) @ToString(callSuper = true)
@Entity
@Table(name = "skill")
public class Skill extends AbstractEntity{

    @Column(name = "category", length = 255)
    @EnglishLanguage
    @Size(min = 1)
    private String category;

    @Column(name = "value", length = 2147483647)
    @EnglishLanguage
    @Size(min = 1)
    private String value;

    @ToString.Exclude @EqualsAndHashCode.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profile", nullable = false)
    @JsonIgnore
    private Profile profile;
}
