package com.cookandroid.and0803_01_customelistcar;

import android.graphics.drawable.Drawable;

public class Jeju {
    private Drawable image;
    private String sites;

    public Jeju(Drawable image, String sites) {
        this.image = image;
        this.sites = sites;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public String getSites() {
        return sites;
    }

    public void setSites(String sites) {
        this.sites = sites;
    }

}
