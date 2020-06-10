package com.example.appsanitaria.Actividades;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import com.example.appsanitaria.Fragments.FragmentCita;
import com.example.appsanitaria.Fragments.FragmentRecycler;
import com.example.appsanitaria.Fragments.Fragmentinfocita;
import com.example.appsanitaria.R;

public class ActividadMenuPac extends AppCompatActivity {

    String nombre, apellidos, dni, numseg;
    TextView nombreview, dniview, apellidosview, numsegview;
    FragmentRecycler fragmentRecycler;
    FragmentCita fragmentCita;
    Fragmentinfocita fragmentinfocita;
    public static Button butinfocitas  ,butcrearcita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_menu_pac);
        fragmentCita = new FragmentCita();
        fragmentRecycler = new FragmentRecycler();
        fragmentinfocita = new Fragmentinfocita();
        butinfocitas = findViewById(R.id.butinfocita);
        butcrearcita = findViewById(R.id.butcita);
        nombreview = findViewById(R.id.nombre_pacperfil);
        apellidosview = findViewById(R.id.apellidos_pacperfil);
        dniview = findViewById(R.id.dni_pacperfil);
        numsegview = findViewById(R.id.numseg_pacperfil);
        nombre = getIntent().getStringExtra("nombre");
        apellidos = getIntent().getStringExtra("apellidos");
        dni = getIntent().getStringExtra("dni");
        numseg = getIntent().getStringExtra("numseg");
        nombreview.setText("Nombre: " + nombre);
        apellidosview.setText("Apellidos: " + apellidos);
        dniview.setText("Dni: " + dni);
        numsegview.setText("Numero Seguridad Social: " + numseg);

        // MUESTRA POR DEFECTO EL FRAGMENT DEL RECYCLER
        getSupportFragmentManager().beginTransaction().add(R.id.contenedorfragment, fragmentRecycler).commit();

    }

    public void Onclick(View view) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch ((view.getId())) {

            case R.id.butlista:
                transaction.replace(R.id.contenedorfragment, fragmentRecycler);
                break;

            case R.id.butcita:
                transaction.replace(R.id.contenedorfragment, fragmentCita);
                break;

            case R.id.butinfocita:
                transaction.replace(R.id.contenedorfragment , fragmentinfocita);

        }


        transaction.commit();

    }
}
