package com.example.appsanitaria.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appsanitaria.R;

public class ActividadMedico extends AppCompatActivity {
    private String nombre  , apellidos , numcolegiado , dni ;
    private TextView viewnombre , viewapellidos , viewnumcolegiado , viewdni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_medico);
        viewapellidos = findViewById(R.id.apellidos_mecperfil);
        viewdni = findViewById(R.id.dni_mecperfil);
        viewnombre = findViewById(R.id.nombre_mecperfil);
        viewnumcolegiado = findViewById(R.id.numcol_mecperfil);
        nombre = getIntent().getStringExtra("nombre");
        apellidos = getIntent().getStringExtra("apellidos");
        numcolegiado = getIntent().getStringExtra("numcol");
        dni = getIntent().getStringExtra("dni");
        viewnombre.setText("Nombre: " + nombre);
        viewapellidos.setText("Apellidos: " + apellidos);
        viewnumcolegiado.setText("NumColegiado: " + numcolegiado);
        viewdni.setText("Dni: " + dni);





    }
}
