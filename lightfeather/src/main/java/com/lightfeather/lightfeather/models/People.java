package com.lightfeather.lightfeather.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="people")
public class People {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=3, message="Please add first name")
    private String firstName;
    
    @NotNull
    @Size(min=3, message="Please add last name")
    private String lastName;

    @NotNull(message="Supervisor cannot be empty")
    private String supervisor;

    private String email;

    @Size(min=10)
    private Long phone;

    private String emailOnly;
    private String phoneOnly;
    

    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;

    // CONSTRUCTORS

    public People() {
    }

    public People(Long id, String firstName, String lastName, String supervisor) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.supervisor = supervisor;
    }

    public People(Long id, String firstName, String lastName, String supervisor, String email, Long phone, String emailOnly, String phoneOnly) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.supervisor = supervisor;
        this.email = email;
        this.phone = phone;
        this.emailOnly = emailOnly;
        this.phoneOnly = phoneOnly;
    }

    public People(Long id, String firstName, String lastName, String supervisor, String email, Long phone, String emailOnly, String phoneOnly, Date createdAt, Date updatedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.supervisor = supervisor;
        this.email = email;
        this.phone = phone;
        this.emailOnly = emailOnly;
        this.phoneOnly = phoneOnly;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // GETTERS / SETTERS

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSupervisor() {
        return this.supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getPhone() {
        return this.phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmailOnly() {
        return this.emailOnly;
    }

    public void setEmailOnly(String emailOnly) {
        this.emailOnly = emailOnly;
    }

    public String getPhoneOnly() {
        return this.phoneOnly;
    }

    public void setPhoneOnly(String phoneOnly) {
        this.phoneOnly = phoneOnly;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}
