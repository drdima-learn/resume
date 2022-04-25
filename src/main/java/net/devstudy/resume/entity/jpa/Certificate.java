package net.devstudy.resume.entity.jpa;

import lombok.Data;
import net.devstudy.resume.entity.AbstractEntity;

import javax.persistence.*;

@Data
@Entity
@Table(name = "certificate")
public class Certificate extends AbstractEntity {


    @Column(name = "large_url", nullable = false, length = 255)
    private String largeUrl;

    @Column(name = "small_url", nullable = false, length = 255)
    private String smallUrl;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    //bi-directional many-to-one association to Profile
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_profile", nullable = false)
    private Profile profile;

    public Certificate() {
    }

    @Transient
    public Certificate getCertificateWoProfile() {
        Certificate certificate = new Certificate();
        certificate.setId(getId());
        certificate.setLargeUrl(getLargeUrl());
        certificate.setSmallUrl(getSmallUrl());
        certificate.setName(getName());
        certificate.setProfile(null);
        return certificate;
    }
}
