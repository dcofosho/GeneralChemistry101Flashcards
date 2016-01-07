package com.example.daniel.generalchemistry101flashcards_2;

import java.util.ArrayList;

/**
 * Created by Daniel on 1/4/2016.
 */
public class UsedId {
    private int usedId;

    public UsedId(){}

    public UsedId(int usedId){
        this.usedId=usedId;
    }

    public int getUsedId() { return usedId;}
    public void setUsedId(int usedId) { this.usedId=usedId; }



    @Override
    public String toString() {
        return "" + usedId;
    }
}
