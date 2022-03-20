package net.devstudy.resume.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "skill")
public class Skill extends AbstractEntity{

    @Column(name = "category", length = 255)
    private String category;

    @Column(name = "value")
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profile", nullable = false)
    private Profile profile;
}
