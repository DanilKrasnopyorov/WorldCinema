package com.example.newproject.network.models;

import com.google.gson.annotations.SerializedName;

public class MoviesBody {
    @SerializedName("filter")
    private String filter;

    public MoviesBody(String filter){
        this.filter = filter;
    }

    public void setFilter(String filter) {
        this.filter = filter;
    }

    public String getFilter() {
        return filter;
    }
}
