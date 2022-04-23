package net.devstudy.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "education")
public class Education extends AbstractEntity {

    @Column(name = "summary", length = 100)
    private String summary;

    @Column(name = "begin_year", nullable = false)
    private Integer beginYear;

    @Column(name = "finish_year", nullable = false)
    private Integer finishYear;

    @Column(name = "university", length = 2147483647)
    private String university;

    @Column(name = "faculty", length = 255)
    private String faculty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profile", nullable = false)
    @JsonIgnore
    private Profile profile;

    public Education() {
    }
}
