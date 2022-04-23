package net.devstudy.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Entity
@Table(name = "profile")
@Document(indexName = "profile")
public class Profile extends AbstractEntity {


    @Column(name = "birth_day")
    private Date birthDay;

    @Column(name = "city")
    @JsonIgnore
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
    @JsonIgnore
    private String largePhoto;

    @Column(name = "small_photo", length = 255)
    private String smallPhoto;

    @Column(name = "phone", length = 20)
    @JsonIgnore
    private String phone;

    @Column(name = "email", length = 100)
    @JsonIgnore
    private String email;

    @Column(name = "info")
    private String info;

    @Column(name = "summary", length = 2147483647)
    private String summary;

    @Column(name = "uid", nullable = false, length = 100)
    private String uid;

    @Column(name = "password", nullable = false, length = 50)
    @JsonIgnore
    private String password;

    @Column(name = "completed", nullable = false)
    @JsonIgnore
    private Boolean completed;

    @Column(name = "created", insertable = false)
    @JsonIgnore
    private Timestamp created;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnore
    private List<Certificate> certificates;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("finishYear DESC, beginYear DESC , id DESC")
    @JsonIgnore
    private List<Education> educations;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("name DESC")
    @JsonIgnore
    private List<Hobby> hobbies;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonIgnore
    private List<Language> languages;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("finishDate DESC")
    @JsonIgnore
    private List<Practic> practics;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("id ASC")
    @JsonIgnore
    private List<Skill> skills;

    @ToString.Exclude
    @OneToMany(mappedBy = "profile", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OrderBy("finishDate DESC")
    @JsonIgnore
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
        if (birthDay == null) return 0;
        LocalDate birthDate = birthDay.toLocalDate();
        LocalDate now = LocalDate.now();
        int age = Period.between(birthDate, now).getYears();
        return age;
    }

    @Transient
    public String getBirthDateFormatted() {
        //Feb 26, 1989
        if (birthDay == null) return "";
        LocalDate date = birthDay.toLocalDate();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        return formattedDate;
    }

    @Transient
    public String getLargePhoto() {
        if (largePhoto != null) {
            return largePhoto;
        } else {
            return "/static/img/profile-placeholder.png";
        }
    }


    public void setSkills(List<Skill> skills) {
        updateListSetProfile(skills);
        this.skills = skills;

    }

    private void updateListSetProfile(List<Skill> skills) {
        if (skills == null) return;
        for (Skill skill : skills) {
            skill.setProfile(this);
        }
    }
}
