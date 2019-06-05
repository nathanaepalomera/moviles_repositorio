package mx.edu.ittepic.myapplication;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView aleatorio;
    Button generar, numeros;
    CountDownTimer timer;
    float contador, cap, nfin;
    String c1, c2, c3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generar = findViewById(R.id.boton);
        aleatorio = findViewById(R.id.texto);
        numeros = findViewById(R.id.cuenta);

        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final DecimalFormat df = new DecimalFormat("#.0");
                float random = (float) (Math.random()*3);
                c1 = df.format(random);
                aleatorio.setText(c1);
                nfin = Float.parseFloat(c1);

                timer = new CountDownTimer(10000,300) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        contador = (float) (contador+0.1);
                        c2 = df.format(contador);
                        numeros.setText(""+c2);

                        if (contador>=2.9){
                            contador= (float) 0.0;
                        }
                    }

                    @Override
                    public void onFinish() {
                        timer.start();
                    }
                }; timer.start();





            }



        });


        numeros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c3=c2;
                cap = Float.parseFloat(c3);

                if (nfin==cap){
                    Toast.makeText(MainActivity.this,"¡LO LOGRASTE! ", Toast.LENGTH_LONG).show();
                    timer.cancel();
                }else {

                    Toast.makeText(MainActivity.this, "SUERTE PARA LA PROXIMA", Toast.LENGTH_SHORT).show();
                    timer.cancel();
                }


            }
        });


    }
}
