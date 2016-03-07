package com.ex.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by zurekm on 07/03/2016.
 */
@Table
public class PersonEntity implements Serializable {

    private long id;
    private String name;

    public PersonEntity() {
    }

    public PersonEntity(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
