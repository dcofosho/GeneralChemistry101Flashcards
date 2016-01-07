package com.example.daniel.generalchemistry101flashcards_2;

import android.graphics.drawable.Drawable;

/**
 * Created by Daniel on 12/27/2015.
 */
public class Subject {
    private String name;
    private Drawable pic;

    public Subject(String name, Drawable pic) {
        this.name = name;
        this.pic = pic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getPic() {
        return pic;
    }

    public void setPic(Drawable pic) {
        this.pic = pic;
    }
}
