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

public class SwipeScreenActivity extends AppCompatActivity {

    @Override
    @SuppressWarnings("ConstantConditions") // removes the stupid warnings about the NPEs
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

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.item_text, chosenOne);

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
                // disliked
            }

            @Override
            public void onRightCardExit(Object o) {
                // liked
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {
                // this is where we should load the next few names in the list
            }

            @Override
            public void onScroll(float v) { }
        });

        findViewById(R.id.btn_more_info).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NameInformationActivity.class);
                intent.putExtra("name", chosenOne.get(0));
                startActivity(intent);
            }
        });
    }
}

