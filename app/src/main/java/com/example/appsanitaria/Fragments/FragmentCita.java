package com.example.appsanitaria.Fragments;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.appsanitaria.Modelos.Citas;
import com.example.appsanitaria.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentCita#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentCita extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private Spinner spinner;
    private View view;
    public static String nombremed;
    private ArrayList<String> medicos;
    private Button butfecha, buthora;
    private TextView editfecha, edithora;
    public  static  Citas citas;
    private int dia, mes, ano, hora, minuto;
    public static String datedia , datemes , dateano , datehora , dateminuto;

    public FragmentCita() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentCita.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentCita newInstance(String param1, String param2) {
        FragmentCita fragment = new FragmentCita();
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
        view = inflater.inflate(R.layout.fragment_cita, container, false);
        citas = new Citas();
        spinner = view.findViewById(R.id.spinnermedico);
        butfecha = view.findViewById(R.id.butfecha);
        buthora = view.findViewById(R.id.buthora);
        editfecha = view.findViewById(R.id.textfecha);
        edithora = view.findViewById(R.id.texthora);
        medicos = new ArrayList<>();
        rellenaArray();
        rellenaspinner();
        butfecha.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                dia = c.get(Calendar.DAY_OF_MONTH);
                mes = c.get(Calendar.MONTH);
                ano = c.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        editfecha.setText(dayOfMonth + "/" + (month + 1) + "/" + year);


                    }
                }
                        , dia, mes, ano);

                datePickerDialog.show();
                datedia = ""+dia;
                datemes = ""+mes;
                dateano = ""+ano;
                citas.setDia(""+dia);
                citas.setMes(""+mes);
                citas.setAno(""+ano);



            }
        });

        buthora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();

                hora = c.get(Calendar.HOUR_OF_DAY);
                minuto = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        edithora.setText(hourOfDay + ":" + minute);
                    }
                }, hora, minuto, false);
                timePickerDialog.show();
                datehora = ""+hora;
                dateminuto =""+minuto;
                citas.setHora(""+hora);
                citas.setMinuto(""+minuto);
            }


        });






        return view;
    }

    public ArrayList rellenaArray() {

        medicos.add("Seleccione Medico:");
        for (int i = 0; i < FragmentInicio.listamedicos.size(); i++) {

            medicos.add(FragmentInicio.listamedicos.get(i).getNombre());

        }

        return medicos;
    }


    public void rellenaspinner() {

        ArrayAdapter adapter = new ArrayAdapter(getContext(),
                android.R.layout.simple_spinner_item, medicos);
        spinner.setAdapter(adapter);


        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (!parent.getItemAtPosition(position).toString().equals("Seleccione Medico:")) {
                    nombremed = parent.getItemAtPosition(position).toString();
                    citas.setMedico(""+ parent.getItemAtPosition(position).toString());
                    Toast.makeText(getContext(), " " + parent.getItemAtPosition(position).toString(), Toast.LENGTH_SHORT).show();
                }
                Log.v("informacion citas" , " " + nombremed);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }


}
