package net.devstudy.resume.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Embeddable
@Access(AccessType.FIELD)
public class Contacts {


    @Column(name = "skype", length = 80)
    private String skype;

    @Column(name = "vkontakte", length = 255)
    private String vkontakte;

    @Column(name = "facebook", length = 255)
    private String facebook;

    @Column(name = "linkedin", length = 255)
    private String linkedin;

    @Column(name = "github", length = 255)
    private String github;

    @Column(name = "stackoverflow", length = 255)
    private String stackoverflow;

    public Contacts() {
    }
}
