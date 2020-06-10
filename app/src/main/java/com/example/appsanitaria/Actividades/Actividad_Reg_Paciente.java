package com.example.appsanitaria.Actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.appsanitaria.Modelos.Paciente;
import com.example.appsanitaria.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;

public class Actividad_Reg_Paciente extends AppCompatActivity {

    EditText editnombre, editdni, editapellidos, editnumsegsocial , editpass;
    Button butaceptar;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference bd;
    private ArrayList<Paciente> listapacientes;
    private Paciente paciente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad__reg__paciente);
        listapacientes = new ArrayList<>();
        editnombre = findViewById(R.id.editnombrepac);
        editdni = findViewById(R.id.editdnipac);
        editapellidos = findViewById(R.id.editapellidopac);
        editnumsegsocial = findViewById(R.id.editnumseg);
        editpass = findViewById(R.id.editpass_pac);
        butaceptar = findViewById(R.id.butaceptar_pac);
        firebaseDatabase = FirebaseDatabase.getInstance();
        butaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String idpaciente = UUID.randomUUID().toString().toUpperCase().trim();
                String nombre = editnombre.getText().toString().toUpperCase().trim();
                String apellidos = editapellidos.getText().toString().toUpperCase().trim();
                String dni = editdni.getText().toString().toUpperCase().trim();
                String numseg = editnumsegsocial.getText().toString().toUpperCase().trim();
                String pass = editpass.getText().toString().toUpperCase().trim();

                if (nombre.equals("")) {

                    editnombre.setError("Campo Nombre vacio.Por favos reviselo");


                } else if (apellidos.equals("")) {

                    editapellidos.setError("Campo Apellidos vacio.Por favos reviselo");



                } else if (numseg.equals("")) {

                    editnumsegsocial.setError("Campo Numero de Seguridad Social vacio .Por favor reviselo");



                } else if (dni.equals("")) {

                    editdni.setError("Campo Dni vacio .Por favos reviselo");


                }else if (pass.equals("")){

                    editpass.setError("Campo Contraseña vacio . Por favor reviselo");

                } else {

                    paciente = new Paciente(nombre, apellidos, dni, numseg, idpaciente , pass);
                    listapacientes.add(paciente);
                    bd = firebaseDatabase.getReference("Datos").child("Pacientes").child(idpaciente);
                    bd.setValue(paciente);
                    Snackbar snackbar = Snackbar.make(v, "                             REGISTRO CORRECTO ",
                            Snackbar.LENGTH_LONG).
                            setTextColor(getResources().getColor(R.color.colorsnackbar));

                    View view = snackbar.getView();
                    view.setBackgroundColor(getResources().getColor(R.color.colornegro));
                    snackbar.show();

                    editnombre.setText("");
                    editapellidos.setText("");
                    editdni.setText("");
                    editpass.setText("");
                    editnumsegsocial.setText("");



                }
            }
        });


    }

}
