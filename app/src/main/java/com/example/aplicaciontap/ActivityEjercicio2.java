package com.example.aplicaciontap;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityEjercicio2 extends AppCompatActivity {

    ListView lstColores;
    Button btnAceptar;
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        lstColores = findViewById(R.id.lstColores);
        btnAceptar = findViewById(R.id.btnAceptar);
        lblResultado = findViewById(R.id.lblResultado);

        String[] colores = {"Rojo", "Verde", "Azul"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, colores);
        lstColores.setAdapter(adapter);

        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String mensaje;
                int pos = lstColores.getCheckedItemPosition();

                if (pos == ListView.INVALID_POSITION) {
                    mensaje = "No hay un color seleccionado.";
                } else {
                    mensaje = "El color seleccionado es: " + lstColores.getItemAtPosition(pos).toString();
                }

                lblResultado.setText(mensaje);
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
