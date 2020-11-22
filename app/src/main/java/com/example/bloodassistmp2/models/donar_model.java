package com.example.bloodassistmp2.models;

public class donar_model {
    String fullName;
    String bloodGroup;

    public donar_model(String fullName, String bloodGroup) {
        this.fullName = fullName;
        this.bloodGroup = bloodGroup;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
}
