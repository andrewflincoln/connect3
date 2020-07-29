package com.andrewflincoln.connectthree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer = 0;
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = { {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6} };

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

        for (int[] position : winningPositions) {
            if (gameState[position[0]] != 2 && gameState[position[0]] == gameState[position[1]] && gameState[position[1]] == gameState[position[2]]) {

                if (activePlayer == 0) {
                    Toast.makeText(this, "Red wins!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Yellow wins!", Toast.LENGTH_SHORT).show();

                }




            }
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}