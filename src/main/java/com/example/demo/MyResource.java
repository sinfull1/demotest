package com.example.demo;


import javax.persistence.*;

@Entity
@Table(name = "resource")
public class MyResource {
    public MyResource() {

    }

    public Integer getId() {
        return id;
    }

    public MyResource(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
}
