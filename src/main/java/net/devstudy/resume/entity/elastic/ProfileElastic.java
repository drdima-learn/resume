package net.devstudy.resume.entity.elastic;

import lombok.*;
import net.devstudy.resume.entity.AbstractEntity;
import net.devstudy.resume.entity.jpa.*;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Embedded;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Document(indexName = "profile")
public class ProfileElastic extends AbstractEntity {

    @Field(type = FieldType.Date, format = DateFormat.date)
    private LocalDate birthDay;

    private String city;
    private String country;
    private String firstName;
    private String lastName;
    private String objective;
    private String smallPhoto;
    private String info;
    private String summary;
    private String uid;

    private List<Certificate> certificates;
    private List<Language> languages;
    private List<Practic> practics;
    private List<Skill> skills;
    private List<Course> courses;

    @Embedded
    private Contacts contacts;

}
