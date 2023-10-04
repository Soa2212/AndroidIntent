package com.example.appsintents;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TableroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablero);
        Bundle bundle = getIntent().getExtras();
        int Owin = bundle.getInt("Owin");
        int Xwin = bundle.getInt("Xwin");
        TextView WinsX = findViewById(R.id.WinsX);
        TextView WinsO = findViewById(R.id.WinsO);
        WinsX.setText(String.valueOf(Xwin));
        WinsO.setText(String.valueOf(Owin));

    }
}