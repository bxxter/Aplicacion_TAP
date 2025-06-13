package com.example.aplicaciontap;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.text.NumberFormat;
import java.util.Locale;

public class ActivityEjercicio6 extends AppCompatActivity {

    ToggleButton tbtnInstalacion, tbtnFormacion, tbtnAlimentacionBD;
    Button btnCalcular;
    TextView txtPrecioBase, lblPrecioInstalacion, lblPrecioFormacion, lblPrecioAlimentacionBD, lblTotal;

    int colorActivo = Color.parseColor("#6200EE"); // púrpura
    int colorInactivo = Color.LTGRAY;
    int textoActivo = Color.WHITE;
    int textoInactivo = Color.BLACK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio6);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tbtnInstalacion = findViewById(R.id.tbtnInstalacion);
        tbtnFormacion = findViewById(R.id.tbtnFormacion);
        tbtnAlimentacionBD = findViewById(R.id.tbtnAlimentacionBD);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtPrecioBase = findViewById(R.id.txtPrecioBase);
        lblPrecioInstalacion = findViewById(R.id.lblPrecioInstalacion);
        lblPrecioFormacion = findViewById(R.id.lblPrecioFormacion);
        lblPrecioAlimentacionBD = findViewById(R.id.lblPrecioAlimentacionBD);
        lblTotal = findViewById(R.id.lblTotal);

        tbtnInstalacion.setChecked(true);

        actualizarToggleButtonStyle(tbtnInstalacion);
        actualizarToggleButtonStyle(tbtnFormacion);
        actualizarToggleButtonStyle(tbtnAlimentacionBD);

        tbtnInstalacion.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarToggleButtonStyle(tbtnInstalacion));
        tbtnFormacion.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarToggleButtonStyle(tbtnFormacion));
        tbtnAlimentacionBD.setOnCheckedChangeListener((buttonView, isChecked) -> actualizarToggleButtonStyle(tbtnAlimentacionBD));

        // Botón calcular
        btnCalcular.setOnClickListener(v -> {
            try {
                double precio_base = Double.parseDouble(txtPrecioBase.getText().toString());
                double precio_instal = Double.parseDouble(lblPrecioInstalacion.getText().toString());
                double precio_for = Double.parseDouble(lblPrecioFormacion.getText().toString());
                double precio_ali = Double.parseDouble(lblPrecioAlimentacionBD.getText().toString());

                double precio_total = precio_base;

                if (tbtnInstalacion.isChecked()) {
                    precio_total += precio_instal;
                }
                if (tbtnFormacion.isChecked()) {
                    precio_total += precio_for;
                }
                if (tbtnAlimentacionBD.isChecked()) {
                    precio_total += precio_ali;
                }

                NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(new Locale("es", "MX"));
                lblTotal.setText(formatoMoneda.format(precio_total));

            } catch (NumberFormatException e) {
                lblTotal.setText("Introduce un precio base válido");
            }
        });
    }

    private void actualizarToggleButtonStyle(ToggleButton toggleButton) {
        if (toggleButton.isChecked()) {
            toggleButton.setBackgroundColor(colorActivo);
            toggleButton.setTextColor(textoActivo);
        } else {
            toggleButton.setBackgroundColor(colorInactivo);
            toggleButton.setTextColor(textoInactivo);
        }
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
