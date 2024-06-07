package com.ftn.sbnz.model.models;

import javax.persistence.*;

import ftn.sbnz.model.models.Role;

@Entity
@Table
public class Client {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Client(Integer id, String name, String lastName, String phone) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;
    private String lastName;
    private String phone;

    private Role role;

    public Client() {}

    public Client(String name, String lastName, String phone) {
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }

    public Client(Integer id, String name, String lastName, String phone, Role role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
