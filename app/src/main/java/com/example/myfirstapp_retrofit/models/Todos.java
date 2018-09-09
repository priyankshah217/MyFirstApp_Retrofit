package com.example.myfirstapp_retrofit.models;

import com.google.gson.annotations.SerializedName;

import lombok.Data;

@Data
public class Todos {
    @SerializedName("title")
    public String title;
}
