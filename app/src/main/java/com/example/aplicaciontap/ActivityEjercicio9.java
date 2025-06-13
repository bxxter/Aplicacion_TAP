package com.example.aplicaciontap;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityEjercicio9 extends AppCompatActivity {

    int coches = 0;
    TextView lblCoches;
    Button btnEntro, btnSalio, btnReiniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio9);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });


        lblCoches = findViewById(R.id.lblCoches);
        btnEntro = findViewById(R.id.btnEntro);
        btnSalio = findViewById(R.id.btnSalio);
        btnReiniciar = findViewById(R.id.btnReiniciar);

        // Entró un coche
        btnEntro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coches++;
                lblCoches.setText(String.valueOf(coches));
            }
        });

        // Salió un coche
        btnSalio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (coches > 0) {
                    coches--;
                    lblCoches.setText(String.valueOf(coches));
                }
            }
        });

        // Reiniciar
        btnReiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                coches = 0;
                lblCoches.setText("0");
            }
        });
    }
}
