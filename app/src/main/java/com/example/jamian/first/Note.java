package com.example.jamian.first;

/**
 *  Simple Note with title and Content
 */
public class Note {


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
