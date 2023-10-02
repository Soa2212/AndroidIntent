package com.example.appsintents;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivityLog extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_log);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString("nombre");
        int edad = bundle.getInt("edad");

        TextView nText = findViewById(R.id.Nombre);
        TextView eText = findViewById(R.id.Edad);
        Button Ret = findViewById(R.id.Ret);

        nText.setText("Nombre: " + nombre);
        eText.setText("Edad: " + String.valueOf(edad));

        Ret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityLog.this, MainActivityExample.class);
                startActivity(intent);
            }
        });


    }
}