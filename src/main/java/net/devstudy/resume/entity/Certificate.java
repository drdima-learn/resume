package net.devstudy.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "certificate")
public class Certificate extends AbstractEntity{



    @Column(name = "large_url", nullable = false, length = 255)
    private String largeUrl;

    @Column(name = "small_url", nullable = false, length = 255)
    private String smallUrl;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    //bi-directional many-to-one association to Profile
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profile", nullable = false)
    @JsonIgnore
    private Profile profile;

    public Certificate() {
    }
}
