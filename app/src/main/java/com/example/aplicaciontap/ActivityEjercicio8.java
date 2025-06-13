package com.example.aplicaciontap;

import android.content.Intent;
import android.os.Bundle;
import android.widget.NumberPicker;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityEjercicio8 extends AppCompatActivity {

    NumberPicker spiValor;
    TextView lblValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio8);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        });

        spiValor = findViewById(R.id.spiValor);
        lblValor = findViewById(R.id.lblValor);

        String[] valores = {"0", "2", "4", "6", "8", "10"};

        spiValor.setMinValue(0);
        spiValor.setMaxValue(valores.length - 1);
        spiValor.setDisplayedValues(valores);
        spiValor.setWrapSelectorWheel(false);

        // Valor inicial
        lblValor.setText("El valor es: " + valores[spiValor.getValue()]);

        spiValor.setOnValueChangedListener((picker, oldVal, newVal) -> {
            lblValor.setText("El valor es: " + valores[newVal]);
        });
    }
}
