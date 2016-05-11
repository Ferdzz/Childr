package com.childr.childr;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;

public class NameInformationActivity extends AppCompatActivity {

    @Override
    @SuppressWarnings("ConstantConditions") // removes the stupid warnings about the NPEs
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_information);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");

        ((TextView)findViewById(R.id.name_information_name)).setText(name);
    }
}

