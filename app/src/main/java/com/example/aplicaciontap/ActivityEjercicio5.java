package com.example.aplicaciontap;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityEjercicio5 extends AppCompatActivity {

    Spinner cboNumeros;
    Button btnPares, btnImpares, btnVaciar;
    TextView lblResultado;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio5);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cboNumeros = findViewById(R.id.cboNumeros);
        btnPares = findViewById(R.id.btnPares);
        btnImpares = findViewById(R.id.btnImpares);
        btnVaciar = findViewById(R.id.btnVaciar);
        lblResultado = findViewById(R.id.lblResultado);

        ArrayAdapter<String> emptyAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
        emptyAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        cboNumeros.setAdapter(emptyAdapter);

        btnPares.setOnClickListener(v -> {
            ArrayAdapter<String> adapterPares = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
            adapterPares.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            for (int i = 0; i < 10; i += 2) {
                adapterPares.add("No " + i);
            }
            cboNumeros.setAdapter(adapterPares);
            lblResultado.setText("");
        });

        btnImpares.setOnClickListener(v -> {
            ArrayAdapter<String> adapterImpares = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
            adapterImpares.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            for (int i = 1; i < 10; i += 2) {
                adapterImpares.add("No " + i);
            }
            cboNumeros.setAdapter(adapterImpares);
            lblResultado.setText("");
        });

        btnVaciar.setOnClickListener(v -> {
            ArrayAdapter<String> adapterVacio = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item);
            adapterVacio.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            cboNumeros.setAdapter(adapterVacio);
            lblResultado.setText("");
        });

        cboNumeros.setOnItemSelectedListener(new android.widget.AdapterView.OnItemSelectedListener() {
            @Override public void onItemSelected(android.widget.AdapterView<?> parent, View view, int position, long id) {
                Object item = cboNumeros.getSelectedItem();
                if (item != null) {
                    lblResultado.setText(item.toString());
                }
            }
            @Override public void onNothingSelected(android.widget.AdapterView<?> parent) {
                lblResultado.setText("");
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
