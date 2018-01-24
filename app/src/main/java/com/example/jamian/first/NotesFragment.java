package com.example.jamian.first;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.util.Log;

import java.util.List;
import java.util.StringTokenizer;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class NotesFragment extends Fragment {

    private OnListFragmentInteractionListener mListener;
    private ListeNotes mNotes;
    private MyNoteRecyclerViewAdapter mAdapter;
    private Note note=null;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public NotesFragment() {
    }

    public void setNote(Note note){

        Log.d("titre",note.getTitre());
        this.note=note;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_note_list, container, false);

        // Set the adapter
        View rView = view.findViewById(R.id.list);
        if (rView instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) rView;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            if (mNotes == null) mNotes = new ListeNotes();
            if (mAdapter == null) mAdapter = new MyNoteRecyclerViewAdapter(mNotes,mListener);
            recyclerView.setAdapter(mAdapter);
        }

        // EXO 3 - MODIFICATION - Questions 3 et 4
        // Impossible de passer par android:onClick dans le XML (il faudrait que ce soit dans l'activité, mais elle n'a pas encore accès au fragment à ce stade de la feuille.
        // On définit donc les OnClickListener
        Button creer = (Button)view.findViewById(R.id.boutonCreer);
        Button suppr = (Button)view.findViewById(R.id.boutonsuppr);
        creer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // FINITIONS question 2
                Intent editIntent = new Intent(NotesFragment.this.getActivity(),NewNoteActivity.class);
                startActivityForResult(editIntent,42);
                /////////

                //addNote("Nouvelle note","Ci est la nouvelle note fraîchement créée par l'appui sur le bouton de test. ");
            }
        });
        suppr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (note!=null) {
                    deleteNote(note.getTitre());
                ((MainActivity) getActivity()).supDetails();
                }
                else
                deleteNote(mNotes.get(0).getTitre());
            }
        });


        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // FINITIONS question 2
        if (requestCode == 42)
            if (resultCode == Activity.RESULT_OK)
                addNote(data.getStringExtra("titre"),data.getStringExtra("contenu"));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Note item);
    }


    // EXO 3 - MODIFICATION - Question 1
    public void addNote(String titre,String contenu)
    {
        mNotes.ajouteNote(titre,contenu);
        // une méthode bourrine serait d'appeler notifyDatasetChanged(), mais cela entraînerait le rafraichissement de tous les éléments de la liste
        mAdapter.notifyItemInserted(mNotes.size()-1);

    }
    // EXO 3 - MODIFICATION - Question 2
    public void deleteNote(String titre)
    {
        int position = mNotes.deleteNote(titre);
        // Idem concernant NotifyDatasetChanged
        if (position >= 0 )
        {
            mAdapter.notifyItemRemoved(position);
        }
    }

}
