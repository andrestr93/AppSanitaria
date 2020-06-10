package com.example.appsanitaria.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.appsanitaria.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragmentinfocita#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragmentinfocita extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView nombrecita , fechacita , horacita;
    private View view;

    public Fragmentinfocita() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragmentinfocita.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragmentinfocita newInstance(String param1, String param2) {
        Fragmentinfocita fragment = new Fragmentinfocita();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragmentinfocita, container, false);

        nombrecita = view.findViewById(R.id.nombrefragcitas);
        fechacita = view.findViewById(R.id.fechafragcitas);
        horacita = view.findViewById(R.id.horafragcitas);


        try{
        if (FragmentCita.citas!=null || !FragmentCita.citas.getMedico().equals("")){
        nombrecita.setText("Nombre Colegiado: " + FragmentCita.citas.getMedico());
        fechacita.setText("Fecha: " + FragmentCita.citas.getDia()+"/"+FragmentCita.citas.getMes()+"/"+FragmentCita.citas.getAno());
        horacita.setText("Hora: "+FragmentCita.citas.getHora()+":"+FragmentCita.citas.getMinuto());
        } else{

            Toast.makeText(getContext(), "No tiene citas pendientes", Toast.LENGTH_SHORT).show();
        }
        } catch (NullPointerException o ){

            Toast.makeText(getContext(), "No tiene citas pendientes", Toast.LENGTH_SHORT).show();

        }





        return view;

    }
}
