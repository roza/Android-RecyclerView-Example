package com.example.jamian.first;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements NotesFragment.OnListFragmentInteractionListener {

    NoteDetailFragment noteDetailFragment;
    NotesFragment notesFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // FragmentManager to retrieve a specific Fragment
        FragmentManager frm = getSupportFragmentManager();
        noteDetailFragment = (NoteDetailFragment) frm.findFragmentById(R.id.mainNoteDetailFrag);
        notesFragment=(NotesFragment)frm.findFragmentById(R.id.mainNoteFrag);

    }

    public void supDetails(){
        noteDetailFragment.update(null);
    }

    @Override
    public void onListFragmentInteraction(Note item) {
        // onListFragmentInteraction calls fragment update
        Log.d("NoteCallback",item.getTitre()+" - "+item.getContenu());
        notesFragment.setNote(item);

        noteDetailFragment.update(item);

    }
}
