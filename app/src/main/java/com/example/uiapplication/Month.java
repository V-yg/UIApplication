package com.example.uiapplication;

/**
 * Created by 一钢 on 2018/7/16.
 */

public class Month {

    private String name;
    private int imageId;

    public Month(String name,int imageId){
        this.imageId = imageId;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
