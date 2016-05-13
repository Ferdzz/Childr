package com.childr.childr;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;

public class GenderChoice extends AppCompatActivity {

    @Override
    @SuppressWarnings("ConstantConditions") // removes the stupid warnings about the NPEs
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender_choice);

        final ImageButton btnGirl = (ImageButton) findViewById(R.id.female_button);
        final ImageButton btnBoy = (ImageButton) findViewById(R.id.male_button);
        final ImageButton btnIntersex = (ImageButton) findViewById(R.id.intersex_button);

        assert btnGirl != null;
        assert btnBoy != null;
        assert btnIntersex != null;
        btnGirl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent("girl");
            }
        });
        btnBoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent("boy");
            }
        });
        btnIntersex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent("both");
            }
        });
    }

    public void sendIntent(String pExtra) {
        Intent intent = new Intent(getApplicationContext(), SwipeScreenActivity.class);
        intent.putExtra("gender", pExtra);

        startActivity(intent);
    }
}
