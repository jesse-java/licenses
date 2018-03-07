package com.naldojesse.license.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class License implements java.io.Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String number;
    //make this pattern equal to what jsp returns in POST to avoid headache!!!!
    @DateTimeFormat (pattern="yyyy-MM-dd")
    private Date expiration_date;
    private String state;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    private static int genLicenseNumCount = 0;

    @OneToOne(fetch= FetchType.LAZY)
    //indicates that the corresponding table to this entity has a foreign_key to the referenced table
    @JoinColumn(name="person_id")
    private Person person;

    public License() {
        System.out.println("running this method");
        genLicenseNumCount++;
        String formatted;
        formatted = String.format("%06d", genLicenseNumCount);
        this.number = formatted;
    }

    public License(String state, Date expiration_date) {
        this.expiration_date = expiration_date;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = Integer.toString(genLicenseNumCount++);
    }


    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}
