package com.example.hrms_msil;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "profile_table")
public class Profile {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;
    private int age;
    private String qualification;
    private String workExperience;
    private String softSkills;

    public Profile(String name, int age, String qualification, String workExperience, String softSkills) {
        this.name = name;
        this.age = age;
        this.qualification = qualification;
        this.workExperience = workExperience;
        this.softSkills = softSkills;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getSoftSkills() {
        return softSkills;
    }

    public void setSoftSkills(String softSkills) {
        this.softSkills = softSkills;
    }
}