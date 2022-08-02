package com.cookandroid.and0802_06_cuslist;

import android.graphics.drawable.Drawable;

public class Movie {
    private Drawable image;
    private String title;
    private String genre;

    public Movie(Drawable image, String title, String genre) {
        this.image = image;
        this.title = title;
        this.genre = genre;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
