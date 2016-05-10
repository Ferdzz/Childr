package com.childr.childr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RadioButton rdGirlNames = (RadioButton) findViewById(R.id.girl_names);
        final RadioButton rdBoyNames = (RadioButton) findViewById(R.id.boy_names);
        final RadioButton rdBothNames = (RadioButton) findViewById(R.id.both_names);

        Button btnConfirm = (Button) findViewById(R.id.btnConfirm);

        assert btnConfirm != null;
        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String gender = null;

                if (rdGirlNames.isChecked()) {
                    gender = "girl";
                } else if (rdBoyNames.isChecked()) {
                    gender = "boy";
                } else if (rdBothNames.isChecked()) {
                    gender = "both";
                }

                if (gender != null) {
                    Intent intent = new Intent(getApplicationContext(), SwipeScreen.class);
                    intent.putExtra("gender", gender);

                    startActivity(intent);
                }
            }
        });
    }
}