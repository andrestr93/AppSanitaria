package com.example.appsanitaria.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.appsanitaria.Modelos.Medico;
import com.example.appsanitaria.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentInicio extends Fragment {


     private View vista;
     private TextView textopres;
    private DatabaseReference databaseReference;
    public static ArrayList<Medico> listamedicos;
    private Medico medico;
    public FragmentInicio() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        vista =  inflater.inflate(R.layout.fragment_inicio, container, false);
      listamedicos = new ArrayList<Medico>();
       textopres = vista.findViewById(R.id.viewtextopres);
        muestraDatosFirebaseMedicos();
        return  vista;


    }

    public void muestraDatosFirebaseMedicos() {
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("Datos").child("Medicos").addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listamedicos.clear();
                for (final DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    databaseReference.child("Datos").child("Medicos").child(snapshot.getKey()).addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()) {
                                medico = dataSnapshot.getValue(Medico.class);
                                listamedicos.add(medico);
                                Log.v("tamano fragmentinicio" , " " + listamedicos.size());

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

}

