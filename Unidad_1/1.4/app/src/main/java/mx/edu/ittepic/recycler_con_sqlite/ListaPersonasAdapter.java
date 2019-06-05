package mx.edu.ittepic.recycler_con_sqlite;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class ListaPersonasAdapter extends RecyclerView.Adapter<ListaPersonasAdapter.PersonasViewHolder> {

    ArrayList<USUARIO> listaUsuario;

    public ListaPersonasAdapter(ArrayList<USUARIO> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }

    @Override
    public PersonasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lis_item_personas,null,false);
        return new PersonasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonasViewHolder holder, int position) {

        holder.id.setText(listaUsuario.get(position).getId().toString());
        holder.nombre.setText(listaUsuario.get(position).getNombre());
        holder.clave.setText(listaUsuario.get(position).getClave());
        holder.telefono.setText(listaUsuario.get(position).getTelefono());
    }

    @Override
    public int getItemCount() {
        return listaUsuario.size();
    }

    public class PersonasViewHolder extends RecyclerView.ViewHolder {

        TextView id,clave,nombre,telefono;

        public PersonasViewHolder(View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.textId);
            nombre =  itemView.findViewById(R.id.textNombre);
            clave = itemView.findViewById(R.id.textClave);
            telefono =  itemView.findViewById(R.id.textTelefono);
        }
    }
}
