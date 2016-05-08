package com.childr.childr;

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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // card like effect
        SwipeFlingAdapterView flingContainer = (SwipeFlingAdapterView) findViewById(R.id.fling_adapter);

        final ArrayList<String> a = new ArrayList<>();
        a.add("Frederic");
        a.add("Didier");
        a.add("Camille");
        a.add("David");
        a.add("Fungle");
        a.add("Ellie");
        a.add("Vincent");

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item, R.id.helloText, a);

        flingContainer.setAdapter(adapter);
        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                a.remove(0);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {
                Toast.makeText(MainActivity.this, "Disliked", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onRightCardExit(Object o) {
                Toast.makeText(MainActivity.this, "Liked", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {

            }

            @Override
            public void onScroll(float v) { }
        });
    }
}
