package mx.edu.ittepic.recycler_con_sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button registro, recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registro= findViewById(R.id.registrarusuarios);

        recycle = findViewById(R.id.mostar);


        BaseDatos conn = new BaseDatos(this,"bd_usuarios",null,1);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent otraventana  = new Intent(MainActivity.this,REGRISTRO_USUARIOS.class);
                startActivityForResult(otraventana, 1);
            }
        });

        recycle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otraventana  = new Intent(MainActivity.this,LISTAPERSONASRECYCLER.class);
                startActivityForResult(otraventana, 1);
            }
        });




    }
}
