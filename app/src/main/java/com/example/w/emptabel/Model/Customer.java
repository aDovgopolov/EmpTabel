package com.example.w.emptabel.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.Required;

public class Customer extends RealmObject {

    @Required
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("sername")
    @Expose
    private String sername;
    @SerializedName("lasname")
    @Expose
    private String lasname;
    @SerializedName("tabelId")
    @Expose
    private String tabelId;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("positName")
    @Expose
    private String positName;
    @SerializedName("avatar")
    @Expose
    private String avatar;

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

    public String getSername() {
        return sername;
    }

    public void setSername(String sername) {
        this.sername = sername;
    }

    public String getLasname() {
        return lasname;
    }

    public void setLasname(String lasname) {
        this.lasname = lasname;
    }

    public String getTabelId() {
        return tabelId;
    }

    public void setTabelId(String tabelId) {
        this.tabelId = tabelId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPositName() {
        return positName;
    }

    public void setPositName(String positName) {
        this.positName = positName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
