package com.example.jamian.first;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteDetailFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteDetailFragment extends Fragment {

    TextView mTitleText;
    TextView mContentText;

    public NoteDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     * @return A new instance of fragment NoteDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NoteDetailFragment newInstance() {
        NoteDetailFragment fragment = new NoteDetailFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View ret =  inflater.inflate(R.layout.fragment_note_detail, container, false);
        mTitleText = (TextView) ret.findViewById(R.id.nodeDetailTitletext);
        mContentText = (TextView) ret.findViewById(R.id.noteDetailContentText);

        return ret;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void update(Note note)
    {
        Log.d("NDFrag","Update called");
        if (note == null)
        {
            mTitleText.setText("");
            mContentText.setText("");
            //return;
        }
        else {

            mTitleText.setText(note.getTitre());
            mContentText.setText(note.getContenu());
        }
    }



}
