package com.example.makarcev_av.testwork.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Awesome Pojo Generator
 */
public class GetAll {
    @SerializedName("Departments")
    @Expose
    private List<Departments> Departments;
    @SerializedName("ID")
    @Expose
    private Integer ID;
    @SerializedName("Name")
    @Expose
    private String Name;

    public GetAll() {
    }

    public GetAll( Integer ID, String Name) {
//    public GetAll(List<Departments> Departments, Integer ID, String Name) {
        this.Departments = Departments;
        this.ID = ID;
        this.Name = Name;
    }

    public List<Departments> getDepartments() {
        return Departments;
    }

    public void setDepartments(List<Departments> Departments) {
        this.Departments = Departments;
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