package com.example.jamian.first;

/**
 * Created by jamian on 21/11/16.
 */
public class Note {

    //EXO 3 Question 2
    private String mTitre;
    private String mContenu;

    public Note(String titre,String contenu)
    {
        mTitre = titre;
        mContenu = contenu;
    }

    public String getTitre() {
        return mTitre;
    }
    public String getContenu() {
        return mContenu;
    }


}
