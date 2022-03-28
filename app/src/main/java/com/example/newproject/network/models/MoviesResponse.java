package com.example.newproject.network.models;

import com.google.gson.annotations.SerializedName;

public class MoviesResponse {
    @SerializedName("movieId")
    private Integer movieId;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("age")
    private Integer age;
    @SerializedName("images")
    private String[] images;
    @SerializedName("poster")
    private String poster;
}
