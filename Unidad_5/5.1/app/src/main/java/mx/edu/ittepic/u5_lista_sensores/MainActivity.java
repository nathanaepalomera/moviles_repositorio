package mx.edu.ittepic.u5_lista_sensores;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ProductAdapter adapter;
    List<DataProvider> productList;

    SensorManager sensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productList = new ArrayList<>();

        recyclerView = findViewById(R.id.recycler_view);

        sensorManager= (SensorManager)this.getSystemService(SENSOR_SERVICE);
        List<Sensor> lista = sensorManager.getSensorList(Sensor.TYPE_ALL);
        StringBuilder data = new StringBuilder();


        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Aquí va la adición de elementos a la lista

        for(int i=1; i< lista.size(); i++){
            productList.add(new DataProvider(
                    "Nombre:"+ lista.get(i).getName(),
                    "Fabricante:"+lista.get(i).getVendor(),
                    "Version:"+lista.get(i).getVersion(),
                    "Rango maximo:"+lista.get(i).getMaximumRange(),
                    "Retraso minimo:"+lista.get(i).getMinDelay(),
                    "Potencia:"+lista.get(i).getPower()));
        }
        adapter = new ProductAdapter(this,productList);
        recyclerView.setAdapter(adapter);
    }
}
