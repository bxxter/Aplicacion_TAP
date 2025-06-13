package com.example.aplicaciontap;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.MenuItem;
        import android.widget.Button;
        import android.widget.CheckBox;
        import android.widget.TextView;

        import androidx.appcompat.app.AppCompatActivity;
        import androidx.appcompat.widget.Toolbar;

public class ActivityEjercicio1 extends AppCompatActivity {

    CheckBox chkPerro, chkGato, chkRaton;
    Button btnAceptar;
    TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejercicio1);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        chkPerro = findViewById(R.id.chkPerro);
        chkGato = findViewById(R.id.chkGato);
        chkRaton = findViewById(R.id.chkRaton);
        btnAceptar = findViewById(R.id.btnAceptar);
        lblResultado = findViewById(R.id.lblResultado);

        btnAceptar.setOnClickListener(v -> {
            String mensaje = "Animales elegidos: ";
            boolean algunoSeleccionado = false;

            if (chkPerro.isChecked()) {
                mensaje += "Perro ";
                algunoSeleccionado = true;
            }
            if (chkGato.isChecked()) {
                mensaje += "Gato ";
                algunoSeleccionado = true;
            }
            if (chkRaton.isChecked()) {
                mensaje += "Ratón ";
                algunoSeleccionado = true;
            }

            if (!algunoSeleccionado) {
                mensaje = "No hay ningún animal seleccionado";
            }

            lblResultado.setText(mensaje);
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
