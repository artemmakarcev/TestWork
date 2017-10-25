package com.example.makarcev_av.testwork.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Awesome Pojo Generator
 */
public class Employees {
    @SerializedName("Email")
    @Expose
    private String Email;
    @SerializedName("Phone")
    @Expose
    private Long Phone;
    @SerializedName("Title")
    @Expose
    private String Title;
    @SerializedName("ID")
    @Expose
    private Integer ID;
    @SerializedName("Name")
    @Expose
    private String Name;

    public Employees() {
    }

    public Employees(String Email, Long Phone, String Title, Integer ID, String Name) {
        this.Email = Email;
        this.Phone = Phone;
        this.Title = Title;
        this.ID = ID;
        this.Name = Name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Long getPhone() {
        return Phone;
    }

    public void setPhone(Long Phone) {
        this.Phone = Phone;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }
}