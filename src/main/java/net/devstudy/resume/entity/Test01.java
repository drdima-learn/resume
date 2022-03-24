package net.devstudy.resume.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test01")
public class Test01 {

    @Id
    private int id;

    private int name;

    private int car;
}
