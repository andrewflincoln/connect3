package com.andrewflincoln.connectthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;
        int currentTag = Integer.parseInt(counter.getTag().toString());
        gameState[currentTag] = activePlayer;

        if (activePlayer == 0) {
            counter.setImageResource(R.drawable.yellow);
            activePlayer = 1;


        } else {
            counter.setImageResource(R.drawable.red);
            activePlayer = 0;

        }
        counter.setTranslationY(-1500);
        counter.animate().translationYBy(1500).rotation(3600).setDuration(300);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}