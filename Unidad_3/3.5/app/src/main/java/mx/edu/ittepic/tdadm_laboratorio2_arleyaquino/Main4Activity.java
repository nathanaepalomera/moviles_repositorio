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

public class Main4Activity extends AppCompatActivity {
    EditText identificador, licencia, monto, puntos, celular, email;
    Button insertar, consultar, regresar, limpiar;
    BaseDatos base;
    String id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        identificador = findViewById(R.id.idd);
        licencia = findViewById(R.id.lic1);
        monto = findViewById(R.id.monto1);
        puntos = findViewById(R.id.puntos1);
        celular = findViewById(R.id.cel1);
        email = findViewById(R.id.email1);

        regresar = findViewById(R.id.regresar);


        base = new BaseDatos(this, "primera", null, 1); //clase de conexion BaseDatos y la bd se llama primera


        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otra = new Intent(Main4Activity.this, MainActivity.class);
                startActivity(otra);

            }
        });
        final EditText pidoID= new EditText(this);
        String mensaje="ESCRIBA LA LICENCIA A BUSCAR";
        String botonAccion="BUSCAR";

        pidoID.setInputType(InputType.TYPE_CLASS_NUMBER);
        pidoID.setHint("VALOR ENTERO MAYOR DE 0 Y DE 5 DIGITOS");


        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setTitle("ATENCION").setMessage(mensaje)
                .setView(pidoID)
                .setPositiveButton(botonAccion, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(pidoID.getText().toString().isEmpty()){ //isEmpy si esta vacio
                            Toast.makeText(Main4Activity.this, "DEBES ESCRIBIR LA LICENCIA", Toast.LENGTH_LONG).show();
                            return;
                        }
                        buscarDato(pidoID.getText().toString());
                        dialog.dismiss();
                    }
                })
                .setNegativeButton("CANCELAR", null)
                .show();
    }
    private void buscarDato(String idBuscar) { //row query
        try{
            SQLiteDatabase tabla= base.getReadableDatabase();
            String SQL ="SELECT * FROM CONDUCTOR WHERE LICENCIA="+idBuscar;

            Cursor resultado =tabla.rawQuery(SQL, null); //cursor permite navegar enre los renglones d ela consulta

            if(resultado.moveToFirst()){

                    identificador.setText(resultado.getString(0));
                    licencia.setText(resultado.getString(1));
                    monto.setText(resultado.getString(2));
                    puntos.setText(resultado.getString(3));
                    celular.setText(resultado.getString(4));
                    email.setText(resultado.getString(5));

            }else{
                //no hay resultados
                Toast.makeText(this, "NO SE ECONTRARON RESULTADOS!", Toast.LENGTH_LONG).show();
            }
            tabla.close();
        }catch (SQLiteException e){
            Toast.makeText(this, "NO SE PUDO REALIZAR LA BUSQUEDA", Toast.LENGTH_LONG).show();
        }
    }
}