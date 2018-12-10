package com.example.ankit.assignment;

import android.graphics.Bitmap;

import com.google.gson.annotations.SerializedName;

public class Feeds {

    @SerializedName("name")
    private String name;

    @SerializedName("post_date")
    private String time;

    @SerializedName("body")
    private String text;


    private int nlikes;

    @SerializedName("total_comments")
    private int ncomments;

    @SerializedName("profile_pic")
    private int imageicon;
    private Bitmap imag;

    public Feeds(String n, String t, String txt, int nl, int nc, int img, Bitmap imge) {
        System.out.println("asdf12345678");
        this.name = n;
        this.time = t;
        this.text = txt;
        this.nlikes = nl;
        this.ncomments = nc;
        this.imageicon = img;
        this.imag = imge;
    }

    public String getName(){
        return name;
    }

    public String getTime(){
        return time;
    }

    public  String getText(){
        return text;
    }

    public int getImageicon() {
        return imageicon;
    }

    public int getNlikes(){
        return nlikes;
    }

    public int getNcomments() {
        return ncomments;
    }

    public Bitmap getImag() {
        return imag;
    }
}
