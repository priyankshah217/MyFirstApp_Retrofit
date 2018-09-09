package com.example.myfirstapp_retrofit.models;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Posts {

    @SerializedName("id")
    public int iD;

    @SerializedName("title")
    public String title;

    @SerializedName("body")
    public String body;
}
