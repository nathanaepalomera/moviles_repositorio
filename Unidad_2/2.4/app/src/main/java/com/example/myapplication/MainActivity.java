package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public Button uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,cero,suma,resta,divicion,multiplicacion,igual,limpiar;
    public TextView num;
    public String n,r;
    public Double s1,s2,resultado;
    int oper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button uno=findViewById(R.id.button1);
        Button dos=findViewById(R.id.button2);
        Button tres=findViewById(R.id.button3);
        Button cuatro=findViewById(R.id.button4);
        Button cinco=findViewById(R.id.button5);
        Button seis=findViewById(R.id.button6);
        Button siete=findViewById(R.id.button7);
        Button ocho=findViewById(R.id.button8);
        Button nueve=findViewById(R.id.button9);
        Button cero=findViewById(R.id.button0);
        Button suma=findViewById(R.id.buttonmas);
        Button resta=findViewById(R.id.buttonmenos);
        Button multiplicacion=findViewById(R.id.buttonpor);
        Button divicion=findViewById(R.id.buttonentre);
        Button igual=findViewById(R.id.buttonigual);
        Button limpiar=findViewById(R.id.buttonc);

        final TextView num=findViewById(R.id.numeropantalla);
        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=num.getText().toString();
                num.setText(n+"1");
            }
        });
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=num.getText().toString();
                num.setText(n+"2");
            }
        });
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=num.getText().toString();
                num.setText(n+"3");
            }
        });
        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=num.getText().toString();
                num.setText(n+"4");
            }
        });
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=num.getText().toString();
                num.setText(n+"5");
            }
        });
        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=num.getText().toString();
                num.setText(n+"6");
            }
        });
        siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=num.getText().toString();
                num.setText(n+"7");
            }
        });
        ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=num.getText().toString();
                num.setText(n+"8");
            }
        });

        nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=num.getText().toString();
                num.setText(n+"9");
            }
        });
        cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n=num.getText().toString();
                num.setText(n+"0");
            }
        });
        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String aux = num.getText().toString();
                    s1 = Double.parseDouble(aux);
                }
                catch (NumberFormatException nfe){

                }
                num.setText("");
                oper=1;
            }
        });
        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String aux = num.getText().toString();
                    s1 = Double.parseDouble(aux);
                }
                catch (NumberFormatException nfe){

                }
                num.setText("");
                oper=2;
            }
        });
        divicion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String aux = num.getText().toString();
                    s1 = Double.parseDouble(aux);
                }
                catch (NumberFormatException nfe){

                }
                num.setText("");
                oper=3;
            }
        });
        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String aux = num.getText().toString();
                    s1 = Double.parseDouble(aux);
                }
                catch (NumberFormatException nfe){

                }
                num.setText("");
                oper=4;
            }
        });
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String aux2 = num.getText().toString();
                    s2 = Double.parseDouble(aux2);
                }
                catch (NumberFormatException nfe){

                }
                num.setText("");

                if (oper==1){
                    resultado=s1+s2;
                }else if (oper==2){
                    resultado=s1-s2;
                }else if(oper==3){
                    if(s2==0){
                        Toast.makeText(MainActivity.this,"NO SE DIVIDE ENTRE 0", Toast.LENGTH_LONG).show();
                    }
                    else{resultado=s1/s2;}
                }else if (oper==4){
                    resultado=s1*s2;
                }

                num.setText(""+resultado);
                s1=resultado;
            }

        });

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num.setText("");
                s1=0.0;
                s2=0.0;
                resultado=0.0;
            }
        });
    }
}
