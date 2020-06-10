package com.example.appsanitaria.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.appsanitaria.R;

public class ActividadPaciente extends AppCompatActivity {

    String nombre , apellidos , dni , numseg;
    TextView nombreview , dniview , apellidosview , numsegview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_paciente);
        nombreview = findViewById(R.id.nombre_pacperfil);
        apellidosview = findViewById(R.id.apellidos_pacperfil);
        dniview = findViewById(R.id.dni_pacperfil);
        numsegview = findViewById(R.id.numseg_pacperfil);
        nombre = getIntent().getStringExtra("nombre");
        apellidos = getIntent().getStringExtra("apellidos");
        dni = getIntent().getStringExtra("dni");
        numseg = getIntent().getStringExtra("numseg");
        nombreview.setText("Nombre " + nombre);
        apellidosview.setText("Apellidos " + apellidos);
        dniview.setText("Dni " + dni);
        numsegview.setText("Numero Seguridad Social " + numseg);




    }
}
