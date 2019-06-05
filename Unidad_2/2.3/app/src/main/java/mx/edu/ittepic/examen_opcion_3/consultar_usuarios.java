package mx.edu.ittepic.examen_opcion_3;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class consultar_usuarios extends AppCompatActivity {

    EditText campoId,campoNombre,campoNocontrol,campoCel,campoEmail,campoCarrera;
    Button buscar, actualizar, borrar;
    BaseDatos conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuarios);

        conn=new BaseDatos(getApplicationContext(),"bd_usuarios",null,1);

        campoId= findViewById(R.id.documentoId);
        campoNombre= findViewById(R.id.campoNombreConsulta);
        campoNocontrol= findViewById(R.id.campoNocontrolconsulta);
        campoCel= findViewById(R.id.campoCelconsulta);
        campoEmail= findViewById(R.id.campoEmailconsulta);
        campoCarrera= findViewById(R.id.campoCarreraconsulta);

        buscar = findViewById(R.id.btnConsultar);
        actualizar = findViewById(R.id.btnActualizar);
        borrar = findViewById(R.id.btnEliminar);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                consultar();
            }
        });

        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizarUsuario();
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarusuario();
            }
        });
    }

    private void eliminarusuario() {
        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};

        db.delete(Utilidades.TABLA_USUARIO,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se Eliminó el usuario",Toast.LENGTH_LONG).show();
        campoId.setText("");
        limpiar();
        db.close();

    }

    private void actualizarUsuario() {

        SQLiteDatabase db=conn.getWritableDatabase();
        String[] parametros={campoId.getText().toString()};
        ContentValues values=new ContentValues();
        values.put(Utilidades.CAMPO_NOMBRE,campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_NOCONTROL,campoNocontrol.getText().toString());
        values.put(Utilidades.CAMPO_CEL,campoCel.getText().toString());
        values.put(Utilidades.CAMPO_EMAIL,campoEmail.getText().toString());
        values.put(Utilidades.CAMPO_CARRERA,campoCarrera.getText().toString());

        db.update(Utilidades.TABLA_USUARIO,values,Utilidades.CAMPO_ID+"=?",parametros);
        Toast.makeText(getApplicationContext(),"Ya se actualizó el usuario",Toast.LENGTH_LONG).show();
        db.close();


    }

    private void consultar() {
        SQLiteDatabase db=conn.getReadableDatabase();
        String[] parametros={campoId.getText().toString()};

        try {
            //select nombre,telefono from usuario where codigo=?
            Cursor cursor=db.rawQuery("SELECT "+Utilidades.CAMPO_NOMBRE+","+Utilidades.CAMPO_NOCONTROL+","+Utilidades.CAMPO_CEL+","+Utilidades.CAMPO_EMAIL+","+Utilidades.CAMPO_CARRERA+
                    " FROM "+Utilidades.TABLA_USUARIO+" WHERE "+Utilidades.CAMPO_ID+"=? ",parametros);

            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoNocontrol.setText(cursor.getString(1));
            campoCel.setText(cursor.getString(2));
            campoEmail.setText(cursor.getString(3));
            campoCarrera.setText(cursor.getString(4));

        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"El documento no existe",Toast.LENGTH_LONG).show();
            limpiar();
        }

    }

    private void limpiar() {
        campoNombre.setText("");
        campoNocontrol.setText("");
        campoCel.setText("");
        campoEmail.setText("");
        campoCarrera.setText("");
    }
}
