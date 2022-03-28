package com.example.newproject.models;

public class Movie {
    private Integer id;
    private String name;
    private String description;
    private String img;

    public Movie(Integer id, String name, String description, String img){
        this.id = id;
        this.name = name;
        this.description = description;
        this.img = img;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }
}