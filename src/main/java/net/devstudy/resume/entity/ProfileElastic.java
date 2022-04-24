package net.devstudy.resume.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Document(indexName = "profile")
public class ProfileElastic extends AbstractEntity {


    @Column(name = "birth_day")
    private Date birthDay;

    @Column(name = "city")
    private String city;

    @Column(name = "country", length = 60)
    private String country;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;


    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "objective", length = 2147483647)
    private String objective;

    @Column(name = "large_photo", length = 255)
    @Transient
    private String largePhoto;

    @Column(name = "small_photo", length = 255)
    private String smallPhoto;

    @Column(name = "phone", length = 20)
    @Transient
    private String phone;

    @Column(name = "email", length = 100)
    @Transient
    private String email;

    @Column(name = "info")
    private String info;

    @Column(name = "summary", length = 2147483647)
    private String summary;

    @Column(name = "uid", nullable = false, length = 100)
    private String uid;

    @Column(name = "password", nullable = false, length = 50)
    @Transient
    private String password;

    @Column(name = "completed", nullable = false)
    @Transient
    private Boolean completed;

    @Column(name = "created", insertable = false)
    @Transient
    private Timestamp created;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @Transient
    private List<Certificate> certificates;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("finishYear DESC, beginYear DESC , id DESC")
    @Transient
    private List<Education> educations;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("name DESC")
    @Transient
    private List<Hobby> hobbies;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @Transient
    private List<Language> languages;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("finishDate DESC")
    @Transient
    private List<Practic> practics;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("id ASC")
    @Transient
    private List<Skill> skills;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("finishDate DESC")
    @Transient
    private List<Course> courses;

    //@ToString.Exclude
    @Embedded
    private Contacts contacts;



}
