package com.example.madlibszerrudo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.graphics.Typeface.BOLD;

public class SecondMadLib extends AppCompatActivity {

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

    public static final String NOUN = "noun";
    public static final String ADJECTIVE = "adjective";
    public static final String VERB = "verb";
    public static final String ANIMAL = "animal";
}
