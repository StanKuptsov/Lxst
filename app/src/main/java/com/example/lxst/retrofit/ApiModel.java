package com.example.lxst.retrofit;

public class ApiModel {

    public int userId;
    public int id;
    public String title;
    public String body;

    public ApiModel() {
    }

    public ApiModel(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
    }
}
