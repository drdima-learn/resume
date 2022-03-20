package net.devstudy.resume.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "practic")
public class Practic extends AbstractEntity{

    @Column(name = "position", length = 100)
    private String position;

    @Column(name = "company", length = 100)
    private String company;

    @Column(name = "begin_date")
    private Date beginDate;

    @Column(name = "finish_date")
    private Date finishDate;

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
    private String getDatePretty(Date date){
        //Mar 2016
        LocalDate localDate = date.toLocalDate();
        String formattedDate = localDate.format(DateTimeFormatter.ofPattern("MMM yyyy"));
        return formattedDate;
    }
}
