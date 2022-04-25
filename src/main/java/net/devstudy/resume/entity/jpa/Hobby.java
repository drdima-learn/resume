package net.devstudy.resume.entity.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import net.devstudy.resume.entity.AbstractEntity;

import javax.persistence.*;

@Data
@Entity
@Table(name = "hobby")
public class Hobby extends AbstractEntity {

    @Column(name = "name", length = 30)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profile", nullable = false)
    @JsonIgnore
    private Profile profile;
}
