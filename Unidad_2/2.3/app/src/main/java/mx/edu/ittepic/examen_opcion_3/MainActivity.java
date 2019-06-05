package mx.edu.ittepic.examen_opcion_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button registro, recycle, consultar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registro= findViewById(R.id.registrarusuarios);

        recycle = findViewById(R.id.mostar);
        consultar = findViewById(R.id.consultar);


        BaseDatos conn = new BaseDatos(this,"bd_usuarios",null,1);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraventana  = new Intent(MainActivity.this,regristro_usuarios.class);
                startActivityForResult(otraventana, 1);
            }
        });

        recycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraventana  = new Intent(MainActivity.this,lista_personas_recycler.class);
                startActivityForResult(otraventana, 1);
            }
        });

        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraventana  = new Intent(MainActivity.this,consultar_usuarios.class);
                startActivityForResult(otraventana, 2);

            }
        });




    }
}
