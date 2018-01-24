package com.example.jamian.first;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

// EXERCICE 3 - FINITIONS - question 1
public class NewNoteActivity extends AppCompatActivity {

    EditText mTitreText;
    EditText mContenuText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

        mTitreText = (EditText)findViewById(R.id.editTitre);
        mContenuText = (EditText)findViewById(R.id.editContenu);
    }

    public void valider(View view) {
        Intent result = new Intent();
        result.putExtra("titre",mTitreText.getText().toString());
        result.putExtra("contenu",mContenuText.getText().toString());

        setResult(Activity.RESULT_OK,result);
        finish();
    }
}
