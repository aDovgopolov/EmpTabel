package com.example.w.emptabel.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Customers {

    @SerializedName("results")
    @Expose
    private List<Result> customers;

    public List<Result> getResults() {
        return customers;
    }

    public void setResults(List<Result> results) {
        this.customers = results;
    }
}