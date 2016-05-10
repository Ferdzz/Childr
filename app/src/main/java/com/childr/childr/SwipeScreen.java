package com.childr.childr;

import android.content.Intent;
import android.graphics.Point;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.Random;

public class SwipeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_screen);

        Intent intent = getIntent();

        // card like effect
        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.fling_adapter);

        final ArrayList<String> boyNames = new ArrayList<>();
        boyNames.add("Arnold");
        boyNames.add("Didier");
        boyNames.add("David");
        boyNames.add("Fungle");
        boyNames.add("Vincent");

        final ArrayList<String> girlNames = new ArrayList<>();
        girlNames.add("Camille");
        girlNames.add("Henriette");
        girlNames.add("Georgina");
        girlNames.add("TaMere");
        girlNames.add("Rita");

        final ArrayList<String> bothNames = new ArrayList<>();
        bothNames.add("Ellie");
        bothNames.add("Pascal(e)");
        bothNames.add("Frederic(que)");
        bothNames.add("Some Other");

        final ArrayList<String> chosenOne;
        String chosenSex = intent.getStringExtra("gender");

        if (chosenSex.equals("girl")) {
            chosenOne = girlNames;
        } else if (chosenSex.equals("boy")) {
            chosenOne = boyNames;
        } else {
            chosenOne = bothNames;
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.helloText, chosenOne);

        flingContainer.setAdapter(adapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                chosenOne.remove(0);
                adapter.notifyDataSetChanged();

                if (chosenOne.size() == 0) {
                    finish();
                }
            }

            @Override
            public void onLeftCardExit(Object o) {
                Toast.makeText(SwipeScreen.this, "Disliked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRightCardExit(Object o) {
                Toast.makeText(SwipeScreen.this, "Liked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {

            }

            @Override
            public void onScroll(float v) { }
        });
    }
}

