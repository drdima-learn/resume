package net.devstudy.resume.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

@ToString(callSuper = true)
@Getter
@Setter
@Entity
@Table(name = "profile")
public class Profile extends AbstractEntity {


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
    private String largePhoto;

    @Column(name = "small_photo", length = 255)
    private String smallPhoto;

    @Column(name = "phone", length = 20)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "info")
    private String info;

    @Column(name = "summary", length = 2147483647)
    private String summary;

    @Column(name = "uid", nullable = false, length = 100)
    private String uid;

    @Column(name = "password", nullable = false, length = 50)
    private String password;

    @Column(name = "completed", nullable = false)
    private Boolean completed;

    @Column(name = "created", insertable = false)
    private Timestamp created;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Certificate> certificates;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("finishYear DESC, beginYear DESC , id DESC")
    private List<Education> educations;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("name DESC")
    private List<Hobby> hobbies;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Language> languages;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("finishDate DESC")
    private List<Practic> practics;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("id ASC")
    private List<Skill> skills;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("finishDate DESC")
    private List<Course> courses;

    //@ToString.Exclude
    @Embedded
    private Contacts contacts;


    @Transient
    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Transient
    public int getAge() {
        LocalDate birthDate = birthDay.toLocalDate();
        LocalDate now = LocalDate.now();
        int age = Period.between(birthDate, now).getYears();
        return age;
    }

    @Transient
    public String getBirthDateFormatted() {
        //Feb 26, 1989
        LocalDate date = birthDay.toLocalDate();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        return formattedDate;
    }




}
