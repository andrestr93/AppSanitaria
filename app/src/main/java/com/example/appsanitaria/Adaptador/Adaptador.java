package com.example.appsanitaria.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appsanitaria.Modelos.Medico;
import com.example.appsanitaria.R;


import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> implements View.OnClickListener {

    ArrayList<Medico> listamedicos = new ArrayList<Medico>();
    private View.OnClickListener listener;
    private Context context;


    public Adaptador(ArrayList<Medico> listamedicos, Context context) {
        this.listamedicos = listamedicos;
        this.context = context;


    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, null, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.nombre.setText("Nombre: " + listamedicos.get(position).getNombre());
        holder.colegiado.setText("Colegiado: " + listamedicos.get(position).getNumcolegiado());


    }

    @Override
    public int getItemCount() {
        return listamedicos.size();

    }


    public void setOnclicklistener(View.OnClickListener listener) {

        this.listener = listener;
    }

    @Override
    public void onClick(View v) {

        if (listener != null) {

            listener.onClick(v);
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre;
        TextView colegiado;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.texto_nombre);
            colegiado = itemView.findViewById(R.id.text_colegiado);


        }


    }

}

