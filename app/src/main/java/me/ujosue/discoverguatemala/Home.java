package me.ujosue.discoverguatemala;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Home extends AppCompatActivity {
    ListView lvEjemplo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        lvEjemplo = (ListView) findViewById(R.id.lvEjemplo);

        String[] array = {"dato 1", "dato 2", "dato 3", "dato 4", "dato 5"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, array);
        lvEjemplo.setAdapter(adaptador);
    }
}
