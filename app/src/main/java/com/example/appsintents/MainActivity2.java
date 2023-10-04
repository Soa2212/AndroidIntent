package com.example.appsintents;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity {
    char Turno = 'X';
    char[] Spots = new char[9];
    int Xwin = 0;
    int Owin = 0;
    private TextView mensajeGanador;
    private TextView btnWinner;
    private TextView button1;
    private TextView button2;
    private TextView button3;
    private TextView button4;
    private TextView button5;
    private TextView button6;
    private TextView button7;
    private TextView button8;
    private TextView button9;
    private TextView TableroBTN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


         button1 = findViewById(R.id.btn1);
         button2 = findViewById(R.id.btn2);
         button3 = findViewById(R.id.btn3);
         button4 = findViewById(R.id.btn4);
         button5 = findViewById(R.id.btn5);
         button6 = findViewById(R.id.btn6);
         button7 = findViewById(R.id.btn7);
         button8 = findViewById(R.id.btn8);
         button9 = findViewById(R.id.btn9);
         mensajeGanador = findViewById(R.id.mensajeGanador);
         btnWinner = findViewById(R.id.btnwin);
         TableroBTN = findViewById(R.id.TableroBTN);

        TableroBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, TableroActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Owin",Owin);
                bundle.putInt("Xwin", Xwin);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnWinner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Reset();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActualizarButton(button1,0);
                button1.setBackgroundResource(R.drawable.grey1);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActualizarButton(button2,1);
                button2.setBackgroundResource(R.drawable.grey2);

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActualizarButton(button3,2);
                button3.setBackgroundResource(R.drawable.grey3);

            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActualizarButton(button4,3);
                button4.setBackgroundResource(R.drawable.grey4);

            }
        });
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActualizarButton(button5,4);
                button5.setBackgroundResource(R.drawable.grey);

            }
        });
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActualizarButton(button6,5);
                button6.setBackgroundResource(R.drawable.grey6);

            }
        });
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActualizarButton(button7,6);
                button7.setBackgroundResource(R.drawable.grey7);

            }
        });
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActualizarButton(button8,7);
                button8.setBackgroundResource(R.drawable.grey8);

            }
        });
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActualizarButton(button9,8);
                button9.setBackgroundResource(R.drawable.grey9);

            }
        });



        Button ViewActivity = findViewById(R.id.ViewActivity);
        ViewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivityExample.class);
                startActivity(intent);
            }
        });
    }
    private void ActualizarButton(TextView id,int Spot) {
        id.setText(String.valueOf(Turno));
        Spots[Spot]=Turno;

        if (Turno == 'X') {
            Turno = 'O';
        } else {
            Turno = 'X';
        }
        id.setClickable(false);

        if (Spots[0] != '\u0000' && Spots[0] == Spots[1] && Spots[1] == Spots[2]) {
            Winner();
        }
        if (Spots[3] != '\u0000' && Spots[3] == Spots[4] && Spots[4] == Spots[5]) {
            Winner();
        }
        if (Spots[6] != '\u0000' && Spots[6] == Spots[7] && Spots[7] == Spots[8]) {
            Winner();
        }
        if (Spots[0] != '\u0000' && Spots[0] == Spots[3] && Spots[3] == Spots[6]) {
            Winner();
        }
        if (Spots[1] != '\u0000' && Spots[1] == Spots[4] && Spots[4] == Spots[7]) {
            Winner();
        }
        if (Spots[2] != '\u0000' && Spots[2] == Spots[5] && Spots[5] == Spots[8]) {
            Winner();
        }
        if (Spots[0] != '\u0000' && Spots[0] == Spots[4] && Spots[4] == Spots[8]) {
            Winner();
        }
        if (Spots[2] != '\u0000' && Spots[2] == Spots[4] && Spots[4] == Spots[6]) {
            Winner();
        }
    }
    private void Winner(){
        if (Turno == 'X'){mensajeGanador.setText("Ganador O");
            Owin=Owin+1;}
        else if (Turno == 'O') {mensajeGanador.setText("Ganador X");
            Xwin=Xwin+1;}
        mensajeGanador.setVisibility(View.VISIBLE);
        btnWinner.setVisibility(View.VISIBLE);
        button1.setClickable(false);
        button2.setClickable(false);
        button3.setClickable(false);
        button4.setClickable(false);
        button5.setClickable(false);
        button6.setClickable(false);
        button7.setClickable(false);
        button8.setClickable(false);
        button9.setClickable(false);
    }
    private void Reset(){
        Turno = 'X';
        Arrays.fill(Spots, '\u0000');
        mensajeGanador.setText("");
        mensajeGanador.setVisibility(View.GONE);
        btnWinner.setVisibility(View.GONE);
        button1.setClickable(true);
        button2.setClickable(true);
        button3.setClickable(true);
        button4.setClickable(true);
        button5.setClickable(true);
        button6.setClickable(true);
        button7.setClickable(true);
        button8.setClickable(true);
        button9.setClickable(true);
        button1.setText(String.valueOf(""));
        button2.setText(String.valueOf(""));
        button3.setText(String.valueOf(""));
        button4.setText(String.valueOf(""));
        button5.setText(String.valueOf(""));
        button6.setText(String.valueOf(""));
        button7.setText(String.valueOf(""));
        button8.setText(String.valueOf(""));
        button9.setText(String.valueOf(""));
        button1.setBackgroundResource(R.drawable.borders1);
        button2.setBackgroundResource(R.drawable.borders2);
        button3.setBackgroundResource(R.drawable.borders3);
        button4.setBackgroundResource(R.drawable.borders4);
        button5.setBackgroundResource(R.drawable.borders);
        button6.setBackgroundResource(R.drawable.borders6);
        button7.setBackgroundResource(R.drawable.borders7);
        button8.setBackgroundResource(R.drawable.borders8);
        button9.setBackgroundResource(R.drawable.borders9);



    }
}