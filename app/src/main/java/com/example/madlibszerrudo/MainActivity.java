package com.example.madlibszerrudo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void sendInfo(View v) {
        // getting a reference to my edit text fields
        EditText noun = (EditText) findViewById(R.id.editNoun);
        EditText adjective = (EditText) findViewById(R.id.editAdjective);
        EditText verb = (EditText) findViewById(R.id.editVerb);
        EditText animal = (EditText) findViewById(R.id.editAnimal);
        try {

            // extracting the text from those edit text fields
            String nounStr = noun.getText().toString();
            String adjectiveStr = adjective.getText().toString();
            String verbStr = verb.getText().toString();
            String animalStr = animal.getText().toString();

            // replaces objects with default filler if user does not enter
            if(nounStr.length() == 0){
                nounStr = "stick";
            }
            if(adjectiveStr.length() == 0){
                adjectiveStr = "big";
            }
            if(verbStr.length() == 0){
                verbStr = "play";
            }
            if(animalStr.length() == 0){
                animalStr = "dog";
            }

                // Creating the intent object so I can send data
                Intent intent = new Intent(this, SecondMadLib.class);

                // putting data from edit text fields into intent to send to other activity
                intent.putExtra(SecondMadLib.NOUN, nounStr);
                intent.putExtra(SecondMadLib.ADJECTIVE, adjectiveStr);
                intent.putExtra(SecondMadLib.VERB, verbStr);
                intent.putExtra(SecondMadLib.ANIMAL, animalStr);

                 // loads the next activity
                 startActivity(intent);

        }
        catch (Exception e){

        }
    }



}
