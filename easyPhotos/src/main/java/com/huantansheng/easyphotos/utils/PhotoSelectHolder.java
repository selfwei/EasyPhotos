package com.huantansheng.easyphotos.utils;
import java.util.ArrayList;
import com.huantansheng.easyphotos.models.album.entity.Photo;
public class PhotoSelectHolder {
    private ArrayList<Photo> photoList;

    public ArrayList<Photo> getData() {return photoList;}
    public void setData(ArrayList<Photo> data) {this.photoList = data;}

    private static final PhotoSelectHolder holder = new PhotoSelectHolder();
    public static PhotoSelectHolder getInstance() {return holder;}
}