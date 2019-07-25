package com.oocl.packagebooking.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Booking {
    @Id
    @NotNull
    private String id;

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    private String state;

    @NotNull
    private String time;

    public Booking() {
    }

    public Booking(@NotNull String id, @NotNull String name, @NotNull String phone, @NotNull String state, @NotNull String time) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.state = state;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
