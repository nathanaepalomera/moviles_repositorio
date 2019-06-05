package com.ejemplo.rcview2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lenovo on 20/02/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private String[] nombres;
    Context con;

    public RecyclerAdapter(String[] nombres, Context context) {
        this.nombres = nombres;
        this.con = context;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;

    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.campo_nombre.setText(nombres[position]);
        holder.borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(con, "se borro corectamente el registro"+nombres[position], Toast.LENGTH_LONG).show();
            }

        });

        holder.actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(con, "esta seguro que quiere actualizar a: "+nombres[position], Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return nombres.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView campo_nombre;
        ImageView borrar;
        ImageView actualizar;


        public RecyclerViewHolder(View itemView) {
            super(itemView);

            campo_nombre = itemView.findViewById(R.id.alumno_id);
            borrar = itemView.findViewById(R.id.eliminar);
            actualizar = itemView.findViewById(R.id.contacto);



        }
    }

}
