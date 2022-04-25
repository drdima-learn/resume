package net.devstudy.resume.entity.jpa;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import net.devstudy.resume.entity.AbstractEntity;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "practic")
public class Practic extends AbstractEntity {

    @Column(name = "position", length = 100)
    private String position;

    @Column(name = "company", length = 100)
    private String company;

    @Column(name = "begin_date")
    @Field(type = FieldType.Date, format = DateFormat.date)
    private LocalDate beginDate;

    @Column(name = "finish_date")
    @Field(type = FieldType.Date, format = DateFormat.date)
    private LocalDate finishDate;

    @Column(name = "responsibilities", length = 2147483647)
    private String responsibilities;

    @Column(name = "demo", length = 255)
    private String demo;

    @Column(name = "src", length = 255)
    private String src;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_profile", nullable = false)
    private Profile profile;

    @Transient
    public String getBeginDatePretty() {
        return getDatePretty(beginDate);
    }

    @Transient
    public String getFinishDatePretty() {
        return getDatePretty(finishDate);
    }

    @Transient
    private String getDatePretty(LocalDate date){
        //Mar 2016
        LocalDate localDate = date;
        String formattedDate = localDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));
        return formattedDate;
    }

    @Transient
    public Practic getPracticWoProfile() {
        Practic practic = new Practic();
        practic.setId(getId());
        practic.setCompany(getCompany());
        practic.setBeginDate(getBeginDate());
        practic.setFinishDate(getFinishDate());
        practic.setResponsibilities(getResponsibilities());
        practic.setDemo(getDemo());
        practic.setSrc(getSrc());
        practic.setProfile(null);
        return practic;
    }
}
