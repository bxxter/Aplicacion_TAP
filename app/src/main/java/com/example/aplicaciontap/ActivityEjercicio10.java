package com.example.aplicaciontap; // Cambia esto a tu paquete real

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityEjercicio10 extends AppCompatActivity {

    private RadioGroup grupoColores;
    private RadioButton optRojo, optVerde, optAzul;
    private Button btnAceptar;
    private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio10);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        grupoColores = findViewById(R.id.grupoColores);
        optRojo = findViewById(R.id.optRojo);
        optVerde = findViewById(R.id.optVerde);
        optAzul = findViewById(R.id.optAzul);
        btnAceptar = findViewById(R.id.btnAceptar);
        lblResultado = findViewById(R.id.lblResultado);


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mensaje = "Color elegido: ";

                int idSeleccionado = grupoColores.getCheckedRadioButtonId();

                if (idSeleccionado == optRojo.getId()) {
                    mensaje += "Rojo";
                } else if (idSeleccionado == optVerde.getId()) {
                    mensaje += "Verde";
                } else if (idSeleccionado == optAzul.getId()) {
                    mensaje += "Azul";
                } else {
                    mensaje += "Ninguno";
                }

                // Mostrar resultado
                lblResultado.setText(mensaje);
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
