package com.ftn.sbnz.model.models;

import javax.persistence.*;

@Entity
@Table
public class Mechanic {

    private String username;
    private String password;
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Role role;

    public Mechanic(String username, String password, Integer id, Role role) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Mechanic(String username, String password, Integer id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Mechanic() {}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Mechanic(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
