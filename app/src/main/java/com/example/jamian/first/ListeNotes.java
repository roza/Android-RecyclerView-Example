package com.example.jamian.first;

import java.util.ArrayList;

/**
 * Created by jamian on 21/11/16.
 */
public class ListeNotes {

    //EXO 3 question 3
    // Un arrayList fera l'affaire (on redirige simplement les méthodes qui nous concernent)
    // On utilise une classe maison pour montrer que l'adapteur peut être utilisé avec n'importe quoi
    ArrayList<Note> mListe = new ArrayList<>();

    public ListeNotes()
    {
        ajouteNote("Note 1","Contenu de la note 1");
        ajouteNote("Autre note","Et un autre contenu");
        ajouteNote("Petite troisième","On va faire un contenu un peu plus long, pour voir comment ça passe sur tous les affichages. Hopla ! Et même encore un peu plus long histoire de dire. Après tout, normalement on a tout un écran pour l'afficher, donc on est bien large...");

    }

    public void ajouteNote(String titre,String contenu)
    {
        // Version simple. On peut également faire ici des tests de nullité des paramètres,
        mListe.add(new Note(titre,contenu));
    }

    public Note get(int i) {
        if (i > mListe.size()) return null;
        if (i<0) return null;
        return mListe.get(i);
    }

    public boolean deleteNote(int i) {
        if (i > mListe.size()) return false;
        if (i<0) return false;
        mListe.remove(i);
        return true;
    }

    public int deleteNote(String titre) {
        for (int i=0;i<mListe.size();++i)
            if (mListe.get(i).getTitre().equals(titre))
            {
                mListe.remove(i);
                return i;
            }
        return -1;
    }

    public int size() {
        return mListe.size();
    }
}
