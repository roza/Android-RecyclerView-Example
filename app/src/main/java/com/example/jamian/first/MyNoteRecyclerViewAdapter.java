package com.example.jamian.first;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;

import com.example.jamian.first.NotesFragment.OnListFragmentInteractionListener;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Note} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class MyNoteRecyclerViewAdapter extends RecyclerView.Adapter<MyNoteRecyclerViewAdapter.ViewHolder> {

    private final ListeNotes mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyNoteRecyclerViewAdapter(ListeNotes items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_note, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Log.d("onBind","---------------"+position);
        holder.mItem =mValues.get(position);
        holder.mIdView.setText(mValues.get(position).getTitre());
        String textContent = mValues.get(position).getContenu();
        if (textContent.length() > 50) textContent = textContent.substring(0,47)+"...";
        holder.mContentView.setText(textContent);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {

                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public void ajouteNote(String titre,String contenu)
    {
        mValues.ajouteNote(titre,contenu);
        this.notifyItemInserted(mValues.size()-1);
    }
    public void supprimeNote(String titre)
    {
        int notePos = mValues.deleteNote(titre);
        if (notePos >=0)
        {
            this.notifyItemRemoved(notePos);
            this.notifyItemRangeChanged(notePos,mValues.size());
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Note mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
