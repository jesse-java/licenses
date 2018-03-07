package com.naldojesse.license.models;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Person implements java.io.Serializable {
    @Id
    @GeneratedValue
    private Long id;
    private String first_name;
    private String last_name;
    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    //this field will own the relationship with the model license
    //referential integrity will be preserved in ALL actions.
    //association will be lazily loaded
    @OneToOne(mappedBy="person", cascade=CascadeType.ALL, fetch= FetchType.LAZY)
    private License license;

    public Person() {

    }

    public Person(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
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

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
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
