package com.childr.childr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    @Override
    @SuppressWarnings("ConstantConditions") // removes the stupid warnings about the NPEs
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
                    Intent intent = new Intent(getApplicationContext(), SwipeScreenActivity.class);
                    intent.putExtra("gender", gender);

                    startActivity(intent);
                }
            }
        });
    }
}