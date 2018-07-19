package com.example.uiapplication;

/**
 * Created by 一钢 on 2018/7/17.
 */

public class Week {
    private String name;
    private int imageId;

    public Week(String name,int imageId){
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
