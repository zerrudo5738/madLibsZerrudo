package com.example.madlibszerrudo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class SecondMadLib extends AppCompatActivity {

    public static final String NOUN = "noun";
    public static final String ADJECTIVE = "adjective";
    public static final String VERB = "verb";
    public static final String ANIMAL = "animal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_mad_lib);

        Intent intent = getIntent();
        String noun = intent.getStringExtra((NOUN));
        String adjective = intent.getStringExtra((ADJECTIVE));
        String verb = intent.getStringExtra((VERB));
        String animal = intent.getStringExtra((ANIMAL));

        String myStory = "There once was a boy with a " + noun + ". This boy's "
                + noun + " was very " + adjective + ". It was so " + adjective +
                " that he decided to use it to play with his pet " + animal +
                ". Together, the boy and his pet " + verb;

        TextView str = (TextView) findViewById(R.id.story);
        str.setText((myStory));

    }

    public void shareInfo(View v) {
        // getting a reference to my edit text fields
        EditText noun = (EditText) findViewById(R.id.editNoun);
        EditText adjective = (EditText) findViewById(R.id.editAdjective);
        EditText verb = (EditText) findViewById(R.id.editVerb);
        EditText animal = (EditText) findViewById(R.id.editAnimal);

        // extracting the text from those edit text fields
        String nounStr = noun.getText().toString();
        String adjectiveStr = adjective.getText().toString();
        String verbStr = verb.getText().toString();
        String animalStr = animal.getText().toString();

        String myStory = "There once was a boy with a " + nounStr + ". This boy's "
                + nounStr + " was very " + adjectiveStr + ". It was so " + adjectiveStr +
                " that he decided to use it to play with his pet " + animalStr +
                ". Together, the boy and his pet " + verbStr;

        // These three lines can send the image to any app through any app that sends messages
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, myStory);

        // declare the title for when pulling up all the apps
        String chooserTitle = getString(R.string.chooser);

        // the createChooser method will select all the apps that are able to send messages
        // and will list them along with the title specified above. Whichever one you select
        // is returned, and then that activity is launched with the info passed.
        Intent chosenIntent = Intent.createChooser(intent, chooserTitle);
        startActivity(chosenIntent);
    }


}
