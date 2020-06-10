package com.example.appsanitaria.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.appsanitaria.Actividades.ActividadMenuPac;
import com.example.appsanitaria.Actividades.Actividad_Reg_Paciente;
import com.example.appsanitaria.Modelos.Paciente;
import com.example.appsanitaria.R;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragLoginPac extends Fragment {
    private Button butaceptar;
    private Button butcrear;
    private View view;
    private Paciente pacientecomprueba;
    private FirebaseDatabase database;
    private DatabaseReference bd;
    private Paciente paciente;
    private ArrayList<Paciente> listapacientes;
    private EditText nombrepaciente, pass;

    public FragLoginPac() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_frag_login_pac, container, false);
        listapacientes = new ArrayList<>();
        butaceptar = view.findViewById(R.id.butaceptar_pac);
        database = FirebaseDatabase.getInstance();
        butcrear = view.findViewById(R.id.butregistro_pac);
        nombrepaciente = view.findViewById(R.id.textnombre_pac);
        pass = view.findViewById(R.id.textpass_pac);
        muestraPacientes();
        butcrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Actividad_Reg_Paciente.class);
                startActivity(intent);
            }
        });

        butaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ( compruebaPaciente(v) == 1){
                    Intent intent = new Intent(getContext(), ActividadMenuPac.class);
                   intent.putExtra("nombre" , pacientecomprueba.getNombre());
                   intent.putExtra("apellidos" , pacientecomprueba.getApellidos());
                   intent.putExtra("dni" , pacientecomprueba.getDni());
                   intent.putExtra("numseg" , pacientecomprueba.getNumsegsocial());
                    startActivity(intent);

                } else{

                    Snackbar snackbar = Snackbar.make(v, "Usuario o Contraseña Incorrectos. Por favor revise nuevamente los campos ",
                            Snackbar.LENGTH_LONG).
                            setTextColor(getResources().getColor(R.color.colorsnackbar));

                    View view = snackbar.getView();
                    view.setBackgroundColor(getResources().getColor(R.color.colornegro));
                    snackbar.show();

                }


            }
        });
        return view;
    }

    /*
     medicocomprueba = null;

        muestramedicos();
        for (Medico medico : listamedicos) {

            String nombre = nombremedico.getText().toString().toUpperCase().trim();
            String password = pass.getText().toString().toUpperCase().trim();

            if (medico.getNombre().equals(nombre) && medico.getPass().equals(password)) {

                medicocomprueba = medico;
            }


        }

        if (medicocomprueba != null) {

            Intent intent = new Intent(getContext(), ActividadMedico.class);
            startActivity(intent);
        } else {

            Snackbar snackbar = Snackbar.make(v, "Usuario o Contraseña Incorrectos. Por favor revise nuevamente los campos ",
                    Snackbar.LENGTH_LONG).
                    setTextColor(getResources().getColor(R.color.colorsnackbar));

            View view = snackbar.getView();
            view.setBackgroundColor(getResources().getColor(R.color.colornegro));
            snackbar.show();
        }

    }
     */


    public int compruebaPaciente(View v) {
        pacientecomprueba = null;
        int comprueba = 0;
        for (Paciente paciente : listapacientes) {
            String nombre = nombrepaciente.getText().toString().toUpperCase().trim();
            String password = pass.getText().toString().toUpperCase().trim();


            if (paciente.getNombre().equals(nombre) && paciente.getPass().equals(password)) {

                pacientecomprueba = paciente;
            }


        }

        if (pacientecomprueba != null) {
            comprueba = 1;
        } else {

            comprueba = 0;
        }

        nombrepaciente.setText("");
        pass.setText("");

        return comprueba;
    }

    public ArrayList muestraPacientes() {

        bd = FirebaseDatabase.getInstance().getReference();
        bd.child("Datos").child("Pacientes").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listapacientes.clear();
                for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    bd.child("Datos").child("Pacientes").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()) {
                                paciente = dataSnapshot.getValue(Paciente.class);
                                listapacientes.add(paciente);


                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return listapacientes;
    }


}
