package com.example.kockadobas;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView elsoKocka;
    private ImageView masodikKocka;
    private Button btnEgyKocka;
    private Button btnKetKocka;
    private Button btnDobas;
    private Button btnReset;
    private TextView eredmenyek;
    private Random rnd = new Random();
    private int[] kepek;
    private boolean kettoKocka;
    private AlertDialog.Builder resetGombos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnEgyKocka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                masodikKocka.setVisibility(View.GONE);
                kettoKocka = false;
            }
        });
        btnKetKocka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                masodikKocka.setVisibility(View.VISIBLE);
                kettoKocka = true;
            }
        });
        btnDobas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int elsorandom = rnd.nextInt(6);
                int masodikrandom = rnd.nextInt(6);
                if (kettoKocka) {
                    elsoKocka.setImageResource(kepek[elsorandom]);
                    masodikKocka.setImageResource(kepek[masodikrandom]);
                    eredmenyek.append((elsorandom + 1) + (masodikrandom + 1) + " (" + (elsorandom + 1) + "+" + (masodikrandom + 1) + ")\n");
                } else {
                    elsoKocka.setImageResource(kepek[elsorandom]);
                    eredmenyek.append((elsorandom+1)+"\n");
                }
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGombos = new AlertDialog.Builder(MainActivity.this);
                resetGombos.setTitle("Reset");
                resetGombos.setMessage("Biztos, hogy törölni szeretné az eddigi dobásokat?");
                resetGombos.setNegativeButton("Nem", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Semmi
                    }
                });
                resetGombos.setPositiveButton("Igen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        eredmenyek.setText("");
                    }
                });
                resetGombos.create().show();
            }
        });
    }

    private void init() {
        elsoKocka = findViewById(R.id.elsoKocka);
        masodikKocka = findViewById(R.id.masodikKocka);
        btnEgyKocka = findViewById(R.id.btnEgyKocka);
        btnKetKocka = findViewById(R.id.btnKetKocka);
        btnDobas = findViewById(R.id.btnDobas);
        btnReset = findViewById(R.id.btnReset);
        eredmenyek = findViewById(R.id.eredmenyek);
        kepek = new int[]{R.drawable.kocka1, R.drawable.kocka2, R.drawable.kocka3, R.drawable.kocka4, R.drawable.kocka5, R.drawable.kocka6};
    }
}