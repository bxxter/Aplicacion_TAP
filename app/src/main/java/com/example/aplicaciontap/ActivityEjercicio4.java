package com.example.aplicaciontap;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class ActivityEjercicio4 extends AppCompatActivity {

    ListView lstNombres;
    Button btnCurso1, btnCurso2, btnVaciar;
    TextView lblResultado;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio4);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lstNombres = findViewById(R.id.lstNombres);
        btnCurso1 = findViewById(R.id.btnCurso1);
        btnCurso2 = findViewById(R.id.btnCurso2);
        btnVaciar = findViewById(R.id.btnVaciar);
        lblResultado = findViewById(R.id.lblResultado);

        btnCurso1.setOnClickListener(v -> {
            String[] curso1 = {"Juan", "María", "Luis"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, curso1);
            lstNombres.setAdapter(adapter);
            lblResultado.setText("");
        });

        btnCurso2.setOnClickListener(v -> {
            String[] curso2 = {"Ana", "Marta", "Jose"};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, curso2);
            lstNombres.setAdapter(adapter);
            lblResultado.setText("");
        });

        btnVaciar.setOnClickListener(v -> {
            String[] vacio = {};
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, vacio);
            lstNombres.setAdapter(adapter);
            lblResultado.setText("");
        });

        lstNombres.setOnItemClickListener((parent, view, position, id) -> {
            String seleccionado = (String) lstNombres.getItemAtPosition(position);
            lblResultado.setText(seleccionado);
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
