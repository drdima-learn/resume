package net.devstudy.resume.entity.jpa;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.devstudy.resume.entity.AbstractEntity;
import net.devstudy.resume.entity.elastic.ProfileElastic;

import org.springframework.data.elasticsearch.annotations.Document;



import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
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
    private LocalDate birthDay;

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
        if (birthDay == null) return 0;
        LocalDate birthDate = birthDay;
        LocalDate now = LocalDate.now();
        int age = Period.between(birthDate, now).getYears();
        return age;
    }

    @Transient
    public String getBirthDateFormatted() {
        //Feb 26, 1989
        if (birthDay == null) return "";
        LocalDate date = birthDay;
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

    @Transient
    public ProfileElastic getProfileElastic() {
        ProfileElastic profileElastic = new ProfileElastic();
        profileElastic.setId(getId());
        profileElastic.setBirthDay(getBirthDay());
        profileElastic.setCity(getCity());
        profileElastic.setCountry(getCountry());
        profileElastic.setFirstName(getFirstName());
        profileElastic.setLastName(getLastName());
        profileElastic.setObjective(getObjective());
        profileElastic.setSmallPhoto(getSmallPhoto());
        profileElastic.setInfo(getInfo());
        profileElastic.setSummary(getSummary());
        profileElastic.setUid(getUid());
        profileElastic.setContacts(getContacts());

        profileElastic.setCertificates(getCertificatesWoProfile());
        profileElastic.setLanguages(getLanguagesWoProfile());
        profileElastic.setPractics(getPracticsWoProfile());
        profileElastic.setSkills(getSkillsWoProfile());


        return profileElastic;
    }



    @Transient
    private List<Certificate> getCertificatesWoProfile(){
        List<Certificate> certificatesElastic = new ArrayList<>();
        for (Certificate c : getCertificates()) {
            certificatesElastic.add(c.getCertificateWoProfile());
        }
        return certificatesElastic;
    }

    @Transient
    private List<Language> getLanguagesWoProfile(){
        List<Language> languagesElastic = new ArrayList<>();
        for (Language l : getLanguages()) {
            languagesElastic.add(l.getLanguageWoProfile());
        }
        return languagesElastic;
    }

    @Transient
    private List<Practic> getPracticsWoProfile(){
        List<Practic> practicsElastic = new ArrayList<>();
        for (Practic p : getPractics()) {
            practicsElastic.add(p.getPracticWoProfile());
        }
        return practicsElastic;
    }

    @Transient
    private List<Skill> getSkillsWoProfile(){
        List<Skill> skillsElastic = new ArrayList<>();
        for (Skill s : getSkills()) {
            skillsElastic.add(s.getSkillWoProfile());
        }
        return skillsElastic;
    }

    public List<Certificate> getCertificates() {
        return certificates==null ? Collections.EMPTY_LIST : certificates;
    }

    public List<Language> getLanguages() {
        return languages==null ? Collections.EMPTY_LIST : languages;
    }

    public List<Practic> getPractics() {
        return practics==null ? Collections.EMPTY_LIST : practics;
    }

    public List<Skill> getSkills() {
        return skills==null ? Collections.EMPTY_LIST : skills;
    }
}
