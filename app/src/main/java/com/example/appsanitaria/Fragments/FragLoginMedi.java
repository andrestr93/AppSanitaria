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
import android.widget.TextView;

import com.example.appsanitaria.Actividades.ActividadMedico;
import com.example.appsanitaria.Actividades.Actividad_Reg_Medico;
import com.example.appsanitaria.Modelos.Medico;
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
 * create an instance of this fragment.
 */
public class FragLoginMedi extends Fragment {

    //CREACION DE VARIABLES

    private Button butaceptar;
    private Button butcrear;
    private View view;
    private FirebaseDatabase database;
    private DatabaseReference bd;
    private Medico medico;
    private Medico medicocomprueba;
    private ArrayList<Medico> listamedicos;
    private EditText nombremedico, pass;

    public FragLoginMedi() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_frag_login_medi, container, false);
        butaceptar = view.findViewById(R.id.butaceptar_medico);
        butcrear = view.findViewById(R.id.butregistro_medico);
        nombremedico = view.findViewById(R.id.textnombre_medico);
        pass = view.findViewById(R.id.textpass_medico);
        listamedicos = new ArrayList<>();
        database = FirebaseDatabase.getInstance();
        muestramedicos();
        butcrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Actividad_Reg_Medico.class);
                startActivity(intent);
            }
        });

        butaceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (compruebaMedico(v) == 1) {
                    Intent intent = new Intent(getContext(), ActividadMedico.class);
                    intent.putExtra("nombre", medicocomprueba.getNombre());
                    intent.putExtra("apellidos", medicocomprueba.getApellidos());
                    intent.putExtra("dni", medicocomprueba.getDni());
                    intent.putExtra("numcol", medicocomprueba.getNumcolegiado());
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
        });

        return view;


    }

    public int compruebaMedico(View v) {
        medicocomprueba = null;
        int comprueba = 0;
        for (Medico medico : listamedicos) {
            Log.v("tamanocomprueba" , " " + listamedicos.size());

            String nombre = nombremedico.getText().toString().toUpperCase().trim();
            String password = pass.getText().toString().toUpperCase().trim();

            if (medico.getNombre().equals(nombre) && medico.getPass().equals(password)) {

                medicocomprueba = medico;
            }


        }

        if (medicocomprueba != null) {

            comprueba = 1;


        } else {

            comprueba = 0;

        }
        nombremedico.setText("");
        pass.setText("");

        return comprueba;

    }

    public ArrayList muestramedicos() {

        bd = FirebaseDatabase.getInstance().getReference();
        bd.child("Datos").child("Medicos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    bd.child("Datos").child("Medicos").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            if (dataSnapshot.exists()) {
                                medico = dataSnapshot.getValue(Medico.class);
                                listamedicos.add(medico);
                                for (Medico medico : listamedicos){
                                }

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

        return listamedicos;

    }



    /*
    // METODO QUE RECOGE LOS DATOS DE FIREBASE
    public void muestraDatosFirebaseUsuarios() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Datos").child("Usuarios").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    databaseReference.child("Datos").child("Usuarios").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                usuarios = dataSnapshot.getValue(Usuarios.class);
                                Log.v("usarios ", "" + usuarios.getUsuario());
                                listadeusuarios.add(usuarios);
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

    }

 */


}
