package com.example.appsanitaria.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appsanitaria.Modelos.*;
import com.example.appsanitaria.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;

public class Actividad_Reg_Medico extends AppCompatActivity {

    private EditText editnombre, editcolegiado, editapellidos, editdni , editpass ;
    private Button aceptar;
    private Medico medico;
    private FirebaseDatabase database;
    private DatabaseReference bd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad__reg__medico);
        database = FirebaseDatabase.getInstance();
        editnombre = findViewById(R.id.editnombremed);
        editcolegiado = findViewById(R.id.editcolegiadomed);
        editapellidos = findViewById(R.id.editapellidosmed);
        editdni = findViewById(R.id.edtidnimed);
        editpass = findViewById(R.id.edtipass_med);
        aceptar = findViewById(R.id.butaceptarreg_medico);

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = editnombre.getText().toString().toUpperCase().trim();
                String numcolegiado = editcolegiado.getText().toString().toUpperCase().trim();
                String apellidos = editapellidos.getText().toString().toUpperCase().trim();
                String dni = editdni.getText().toString().toUpperCase().trim();
                String idmedico = UUID.randomUUID().toString().toUpperCase().trim();
                String pass = editpass.getText().toString().toUpperCase().trim();


                if (nombre.equals("")) {

                    editnombre.setError("Campo Nombre vacio. Reviselo nuevamente");

                } else if (apellidos.equals("")) {

                    editapellidos.setError("Campo Apellidos vacio. Reviselo nuevamente");

                } else if (numcolegiado.equals("")) {

                    editdni.setError("Campo Numero Colegiado vacio . Reviselo nuevamente");

                } else if (dni.equals("")) {

                    editcolegiado.setError("Campo Dni vacio. Reviselo nuevamente");

                } else if (pass.equals("")){

                    editpass.setError("Campo Contraseña vacio . Reviselo nuevamente");

                } else {
                    medico = new Medico(nombre, apellidos, numcolegiado, dni, idmedico , pass);
                    bd = database.getReference("Datos").child("Medicos").child(idmedico);
                    bd.setValue(medico);
                    limpiacajas();
                    Snackbar snackbar = Snackbar.make(v, "                             REGISTRO CORRECTO ",
                            Snackbar.LENGTH_LONG).
                            setTextColor(getResources().getColor(R.color.colorsnackbar));
                    View view = snackbar.getView();
                    view.setBackgroundColor(getResources().getColor(R.color.colornegro));
                    snackbar.show();


                }

            }

        });


    }


    public void limpiacajas() {

        editnombre.setText("");
        editapellidos.setText("");
        editcolegiado.setText("");
        editdni.setText("");
        editpass.setText("");

    }

}
