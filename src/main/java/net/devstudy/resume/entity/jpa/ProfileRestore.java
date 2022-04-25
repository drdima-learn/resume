package net.devstudy.resume.entity.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import net.devstudy.resume.entity.AbstractEntity;

import javax.persistence.*;

@Data
@Entity
@Table(name = "profile_restore")
public class ProfileRestore extends AbstractEntity {

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="id", nullable = false)
    @JsonIgnore
    private Profile profile;

    @Column(name = "token", nullable = false)
    private String token;

    public ProfileRestore() {
    }
}
