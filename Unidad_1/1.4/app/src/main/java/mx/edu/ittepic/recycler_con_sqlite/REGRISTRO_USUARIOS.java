package mx.edu.ittepic.recycler_con_sqlite;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class REGRISTRO_USUARIOS extends AppCompatActivity {

    EditText Id,Nombre,Telefono,Clave;
    Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regristro__usuarios);

        Id = findViewById(R.id.campoId);
        Nombre = findViewById(R.id.campoNombre);
        Clave = findViewById(R.id.campoClave);
        Telefono = findViewById(R.id.campoTelefono);

        registrar = findViewById(R.id.btnRegistro);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registarusuarios();
            }
        });


    }

    private void registarusuarios() {
        BaseDatos conn=new BaseDatos(this,"bd_usuarios",null,1);

        SQLiteDatabase db=conn.getWritableDatabase();

        ContentValues values=new ContentValues();
        values.put(UTILIDADES.CAMPO_ID,Id.getText().toString());
        values.put(UTILIDADES.CAMPO_NOMBRE,Nombre.getText().toString());
        values.put(UTILIDADES.CAMPO_CLAVE,Clave.getText().toString());
        values.put(UTILIDADES.CAMPO_TELEFONO,Telefono.getText().toString());

        Long idResultante=db.insert(UTILIDADES.TABLA_USUARIO,UTILIDADES.CAMPO_ID,values);

        Toast.makeText(getApplicationContext(),"Id Registro: "+idResultante,Toast.LENGTH_SHORT).show();
        db.close();
    }
}
