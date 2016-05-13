package com.childr.childr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    Toast toast;
    String toastMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toast = Toast.makeText(getApplicationContext(), toastMsg, Toast.LENGTH_SHORT);

        Button btnStart = (Button) findViewById(R.id.btn_start);
        Button btnSetting = (Button) findViewById(R.id.btn_settings);
        ImageButton btnInfo = (ImageButton) findViewById(R.id.btn_info);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(getApplicationContext(), GenderChoice.class);
                startActivity(intent);
            }
        });

        btnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.setText("Not implemented");

                toast.show();
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.setText("We are awesome");

                toast.show();
            }
        });
    }
}