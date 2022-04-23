package net.devstudy.resume.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;

@Data
@Entity
@Table(name = "course")
public class Course extends AbstractEntity{

    @Column(name = "name", length = 60)
    private String name;

    @Column(name = "school", length = 60)
    private String school;

    @Column(name = "finish_date")
    private Date finishDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profile", nullable = false)
    @JsonIgnore
    private Profile profile;

    @Transient
    public String getFinishDatePretty() {
        return getDatePretty(finishDate);
    }

    @Transient
    private String getDatePretty(Date date){
        //Mar 2016
        LocalDate localDate = date.toLocalDate();
        String formattedDate = localDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));
        return formattedDate;
    }
}
