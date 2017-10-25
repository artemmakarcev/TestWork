package com.example.makarcev_av.testwork.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Awesome Pojo Generator
 */
public class Departments {
    @SerializedName("Departments")
    @Expose
    private List<Departments> Departments;
    @SerializedName("Employees")
    @Expose
    private List<Employees> Employees;
    @SerializedName("ID")
    @Expose
    private Integer ID;
    @SerializedName("Name")
    @Expose
    private String Name;

    public Departments() {
    }

    public Departments(List<Departments> Departments, List<Employees> Employees, Integer ID, String Name) {
        this.Departments = Departments;
        this.Employees = Employees;
        this.ID = ID;
        this.Name = Name;
    }

    public List<Departments> getDepartments() {
        return Departments;
    }

    public void setDepartments(List<Departments> Departments) {
        this.Departments = Departments;
    }

    public List<Employees> getEmployees() {
        return Employees;
    }

    public void setEmployees(List<Employees> Employees) {
        this.Employees = Employees;
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