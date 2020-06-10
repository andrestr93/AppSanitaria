package com.example.appsanitaria.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.appsanitaria.Actividades.ActividadMenuPac;
import com.example.appsanitaria.Adaptador.Adaptador;
import com.example.appsanitaria.R;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentRecycler#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentRecycler extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recicler;
    private  View view;
    private Adaptador adaptador;

    public FragmentRecycler() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentRecycler.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentRecycler newInstance(String param1, String param2) {
        FragmentRecycler fragment = new FragmentRecycler();
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
        view = inflater.inflate(R.layout.fragment_recycler, container, false);;
        recicler = view.findViewById(R.id.reciclerlista);
        recicler.setLayoutManager(new LinearLayoutManager(getContext()));
        if (!FragmentInicio.listamedicos.isEmpty()){
        adaptador = new Adaptador(FragmentInicio.listamedicos , getContext());
        recicler.setAdapter(adaptador);
        } else{

            ActividadMenuPac.butinfocitas.setEnabled(false);
            ActividadMenuPac.butcrearcita.setEnabled(false);

            Snackbar.make(view, "Actualmente no hay datos en la lista" ,  Snackbar.LENGTH_LONG).
                    setTextColor(getResources().getColor(R.color.colorblanco))
                    .show();


        }
        return view;
    }


}
