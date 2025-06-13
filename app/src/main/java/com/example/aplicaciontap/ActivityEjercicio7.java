package com.example.aplicaciontap;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityEjercicio7 extends AppCompatActivity {

    SeekBar slDeslizador;
    TextView lblValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio7);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> finish());

        slDeslizador = findViewById(R.id.slDeslizador);
        lblValor = findViewById(R.id.lblValor);

        slDeslizador.setMax(400);
        slDeslizador.setProgress(250); // Valor inicial

        lblValor.setText("El valor es: " + (slDeslizador.getProgress() + 100)); // Ajuste a rango desde 100

        slDeslizador.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int valor = progress + 100;
                lblValor.setText("El valor es: " + valor);
            }

            @Override public void onStartTrackingTouch(SeekBar seekBar) { }

            @Override public void onStopTrackingTouch(SeekBar seekBar) { }
        });
    }
}
