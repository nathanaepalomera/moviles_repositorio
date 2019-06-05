package mx.edu.ittepic.clima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView t1_temp,t2_city,t3_description,t4_date, temminima, temmaxima, longitud, latitud;
    EditText ciudad;
    Button buscar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1_temp = (TextView)findViewById(R.id.textView);
        t2_city = (TextView)findViewById(R.id.textView3);
        t3_description = (TextView)findViewById(R.id.textView4);
        t4_date = (TextView)findViewById(R.id.textView2);
        temminima= (TextView) findViewById(R.id.temminima);
        temmaxima= (TextView) findViewById(R.id.temmaxima);
        longitud = (TextView)findViewById(R.id.lon);
        latitud = (TextView)findViewById(R.id.lat);
        ciudad=findViewById(R.id.editciudad);
        buscar=findViewById(R.id.botonbuscar);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find_weather();
            }
        });

    }
    public void find_weather()
    {

        String url ="http://api.openweathermap.org/data/2.5/weather?q="+ciudad.getText().toString()+",mx&APPID=85f8bb7677bdc2e4163c3b3b09787dc9&units=metric";

        JsonObjectRequest jor = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try
                {
                    JSONObject main_object = response.getJSONObject("main");
                    JSONArray array = response.getJSONArray("weather");
                    JSONObject coordenadas = response.getJSONObject("coord");
                    JSONObject object = array.getJSONObject(0);



                    String temp = String.valueOf(main_object.getDouble("temp"));
                    String description = object.getString("description");
                    String city = response.getString("name");

                    String temp_min = String.valueOf(main_object.getDouble("temp_min"));
                    String temp_max = String.valueOf(main_object.getDouble("temp_max"));

                    String lon = String.valueOf(coordenadas.getDouble("lon"));
                    String lat = String.valueOf(coordenadas.getDouble("lat"));



                    t1_temp.setText(temp);
                    temminima.setText("Temperatura minima:   " + temp_min);
                    temmaxima.setText("Temperatura maxima:   " + temp_max);
                    t2_city.setText("Ciudad:  " + city);
                    t3_description.setText("Descripcion:  " + description);
                    longitud.setText(lon + " - ");
                    latitud.setText(lat);


                    Calendar calendar = Calendar.getInstance();
                    SimpleDateFormat sdf = new SimpleDateFormat("EEEE=MM-dd");
                    String formatted_date = sdf.format(calendar.getTime());

                    t4_date.setText(formatted_date);



                    //EN CASO DE CONVERTIR IMPERIAL A CELCIUS en este caso no lo ocupamos puesto que lo convertimos directamente en el URL

                   /* double temp_int = Double.parseDouble(temp);
                    double centi = (temp_int - 32) /1.8000;
                    centi = Math.round(centi);
                    int i = (int)centi;*/
                    //  t1_temp.setText(String.valueOf(i));

                    /*double tempmin_int = Double.parseDouble(temp_min);
                    double centigra = (tempmin_int - 32) /1.8000;
                    centigra = Math.round(centigra);
                    int s = (int)centigra;*/
                    //  temminima.setText(String.valueOf(s));

                   /* double tempmax_int = Double.parseDouble(temp_max);
                    double centigrados = (tempmax_int - 32) /1.8000;
                    centigrados = Math.round(centigrados);
                    int g = (int)centigrados;*/
                    // temmaxima.setText(String.valueOf(g));

                }catch(JSONException e)
                {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jor);


    }
}
