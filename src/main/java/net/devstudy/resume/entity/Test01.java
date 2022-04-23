package net.devstudy.resume.entity;

import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "test01")
@Document(indexName = "test01")
public class Test01 implements Serializable {

    public Test01() {
    }

    public Test01(String id, int name, int car) {
        this.id = id;
        this.name = name;
        this.car = car;
    }

    @Id
    private String id;

    private int name;

    private int car;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(int name) {
        this.name = name;
    }

    public void setCar(int car) {
        this.car = car;
    }



    public int getName() {
        return name;
    }

    public int getCar() {
        return car;
    }
}
