package com.ftn.sbnz.model.models;

public class Mechanic {

    private String username;
    private String password;
    private Integer id;

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
