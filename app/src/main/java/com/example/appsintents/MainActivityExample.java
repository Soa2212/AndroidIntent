package com.example.appsintents;

import static android.content.Intent.*;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.os.CountDownTimer;
import android.widget.TextView;
import android.widget.Toast;
import android.provider.MediaStore;
import android.net.Uri;
import android.widget.Button;

import java.text.BreakIterator;

public class MainActivityExample extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_example);

        Intent intent = new Intent(this, MainActivityLog.class);
        Bundle bundle = new Bundle();
        bundle.putString("nombre","Ale");
        bundle.putInt("edad", 18);
        intent.putExtras(bundle);
        startActivity(intent);


        Button buttonActivity = findViewById(R.id.btnStartActivity2);
        Button btnOpenIntentAPP = findViewById(R.id.btnOpenYouTube);
        Button btnOpenIntentAPPG = findViewById(R.id.btnOpenGoogle);
        Button btnOpenIntentInsta = findViewById(R.id.btnOpenInstagram);
        Button btnOpenIntentCamera = findViewById(R.id.btnOpenCamera);
        Button btnOpenIntentPhone = findViewById(R.id.btnOpenContact);
        Button btnOpenIntentMaps = findViewById(R.id.btnOpenGoogleMaps);
        Button btnOpenIntentShare = findViewById(R.id.Share);
        TextView mTextField = findViewById(R.id.mTextField);
        Button ViewActivity = findViewById(R.id.ViewActivity);
        Button btnCountdown = findViewById(R.id.Countdown);

        btnOpenIntentShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Apoco si.");
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);

            }
        });

        btnOpenIntentMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("google.streetview:cbll=46.414382,10.013988");

                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");

                startActivity(mapIntent);
            }
        });
        btnCountdown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CountDownTimer contador= new CountDownTimer(110000000, 1000) {
                    public void onTick(long millisUntilFinished) {
                        mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
                    }

                    public void onFinish() {
                        mTextField.setText("Done!");
                        Intent intent = new Intent(MainActivityExample.this, MainActivityLog.class);
                        startActivity(intent);
                    }
                }.start();
            }
        });




        btnOpenIntentPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+" 8715229878"));
                startActivity(intent);
            }
        });

        btnOpenIntentCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivity(intent);
            }
        });

        btnOpenIntentInsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.instagram.com");
                Intent intent = new Intent(ACTION_VIEW, uri);//Metodo sobrecargado - Por que se tiene muchos constructores
                try {
                    startActivity(intent);
                } catch (Exception e){
                    Toast.makeText(MainActivityExample.this, "No se puede abrir la App" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        ViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityExample.this, MainActivityLog.class);
                startActivity(intent);
            }
        });

        buttonActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityExample.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnOpenIntentAPPG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.google.com");
                Intent intent = new Intent(ACTION_VIEW, uri);
                try {
                    startActivity(intent);
                } catch (Exception e){
                    Toast.makeText(MainActivityExample.this, "No se puede abrir la App" , Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnOpenIntentAPP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://www.youtube.com");
                Intent intent = new Intent(ACTION_VIEW, uri);

                try {
                    startActivity(intent);
                } catch (Exception e){
                    Toast.makeText(MainActivityExample.this, "No se puede abrir la App" , Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}