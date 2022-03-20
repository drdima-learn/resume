package net.devstudy.resume.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hobby")
public class Hobby extends AbstractEntity{

    @Column(name = "name", length = 30)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profile", nullable = false)
    private Profile profile;
}
