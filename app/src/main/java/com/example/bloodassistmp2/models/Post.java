package com.example.bloodassistmp2.models;

import com.google.gson.annotations.SerializedName;

public class Post {


    @SerializedName("fullname")
    private String fullname;

    @SerializedName("dateofbirth")
    private String dateofbirth;

    @SerializedName("bloodgroup")
    private String bloodgroup;

    @SerializedName("phonenumber")
    private String phonenumber;


    @SerializedName("email")
    private String email;

    @SerializedName("address")
    private String address;

    public Post(String fullname, String dateofbirth, String bloodgroup, String phonenumber, String email, String address) {
        this.fullname = fullname;
        this.dateofbirth = dateofbirth;
        this.bloodgroup = bloodgroup;
        this.phonenumber = phonenumber;
        this.email = email;
        this.address = address;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String getBloodgroup() {
        return bloodgroup;
    }

    public void setBloodgroup(String bloodgroup) {
        this.bloodgroup = bloodgroup;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}



