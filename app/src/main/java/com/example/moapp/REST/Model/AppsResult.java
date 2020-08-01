package com.example.moapp.REST.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AppsResult {

    @SerializedName("data")
    @Expose
    private List<Apps> data = null;

    public List<Apps> getData() {
        return data;
    }

    public void setData(List<Apps> data) {
        this.data = data;
    }

}