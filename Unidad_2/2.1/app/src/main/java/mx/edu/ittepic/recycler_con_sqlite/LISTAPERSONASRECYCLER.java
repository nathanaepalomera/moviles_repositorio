package mx.edu.ittepic.recycler_con_sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class LISTAPERSONASRECYCLER extends AppCompatActivity {

    ArrayList<USUARIO> listaUsuario;
    RecyclerView recyclerViewUsuarios;

    BaseDatos conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listapersonasrecycler);

        conn=new BaseDatos(getApplicationContext(),"bd_usuarios",null,1);
        listaUsuario=new ArrayList<>();

        recyclerViewUsuarios=  findViewById(R.id.recyclerPersonas);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));

        consultarListaPersonas();

        ListaPersonasAdapter adapter=new ListaPersonasAdapter(listaUsuario);
        recyclerViewUsuarios.setAdapter(adapter);


    }

    private void consultarListaPersonas() {
        SQLiteDatabase db=conn.getReadableDatabase();

        USUARIO usuario = null;
        // listaUsuarios=new ArrayList<Usuario>();
        //select * from usuarios
        Cursor cursor=db.rawQuery("SELECT * FROM "+ UTILIDADES.TABLA_USUARIO,null);

        while (cursor.moveToNext()){
            usuario=new USUARIO();
            usuario.setId(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setClave(cursor.getString(2));
            usuario.setTelefono(cursor.getString(3));

            listaUsuario.add(usuario);
        }
    }
}
