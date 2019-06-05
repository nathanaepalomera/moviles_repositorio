package mx.edu.ittepic.tdadm_laboratorio2_arleyaquino;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Main3Activity extends AppCompatActivity {
    EditText identificador, licencia, monto, puntos, celular, email;
    Button actualizar, regresar, limpiar;
    BaseDatos base;
    String id;
    int imonto=0, ipuntos=0, im, ip;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        identificador = findViewById(R.id.idd);
        licencia = findViewById(R.id.lic1);
        monto = findViewById(R.id.monto1);
        puntos = findViewById(R.id.puntos1);
        celular = findViewById(R.id.cel1);
        email = findViewById(R.id.email1);

        regresar = findViewById(R.id.regresar);
        actualizar = findViewById(R.id.actualizar);
//cacho la posicion
        id=getIntent().getStringExtra("id");

        base = new BaseDatos(this, "primera", null, 1); //clase de conexion BaseDatos y la bd se llama primera


        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otra = new Intent(Main3Activity.this, MainActivity.class);
                startActivity(otra);

            }
        });
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actualizar();
            }
        });
        base = new BaseDatos(this, "primera", null, 1);
        try{
            SQLiteDatabase tabla= base.getReadableDatabase();
            String SQL ="SELECT * FROM CONDUCTOR WHERE ID="+id;

            Cursor resultado =tabla.rawQuery(SQL, null);
            if(resultado.moveToFirst()) {
                identificador.setText(resultado.getString(0));
                licencia.setText(resultado.getString(1));
                monto.setText(resultado.getString(2));
                puntos.setText(resultado.getString(3));
                celular.setText(resultado.getString(4));
                email.setText(resultado.getString(5));
                imonto+=Integer.valueOf(resultado.getString(2));
                ipuntos+=Integer.valueOf(resultado.getString(3));
            }
            tabla.close();
        }catch (SQLiteException e){
            Toast.makeText(this, "NO SE PUDO REALIZAR"+e.toString(), Toast.LENGTH_LONG).show();
        }

}
    private void actualizar() {

        try

        {
            if(Integer.valueOf(puntos.getText().toString())>10){
                Toast.makeText(this,"PUNTOS DE 1 AL 10", Toast.LENGTH_LONG).show();
                puntos.setText("");
            }else {
                SQLiteDatabase tabla = base.getWritableDatabase();
                int v = imonto + Integer.valueOf(monto.getText().toString());
                int p = ipuntos + Integer.valueOf(puntos.getText().toString());

                String SQL = "UPDATE CONDUCTOR SET LICENCIA='" + licencia.getText().toString() + "', MONTO='" + v + "', PUNTOS='" + p + "', CELULAR='" + celular.getText().toString() + "', EMAIL='" + email.getText().toString()
                        + "'WHERE ID=" + id;

                tabla.execSQL(SQL);
                tabla.close();

                monto.setText(String.valueOf(v));
                puntos.setText(String.valueOf(p));
                database = FirebaseDatabase.getInstance().getReference("Multa"+id);
                database.child("ID"+id).setValue(identificador.getText().toString());
                database.child("LICENCIA"+id).setValue(licencia.getText().toString());
                database.child("MONTO"+id).setValue(monto.getText().toString());
                database.child("PUNTOS"+id).setValue(puntos.getText().toString());
                database.child("CELULAR"+id).setValue(celular.getText().toString());
                database.child("EMAIL"+id).setValue(email.getText().toString());
                Toast.makeText(this, "SE ACTUALIZO", Toast.LENGTH_LONG).show();
                identificador.setText(id);
            }

        }catch(
                SQLiteException e)

        {
            Toast.makeText(this, "NO SE PUDO ACTUALIZAR", Toast.LENGTH_LONG).show();
        }

    }
}
