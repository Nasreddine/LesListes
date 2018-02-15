package com.sc.leslistes;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import javax.xml.datatype.Duration;

public class MainActivity extends Activity {

    ListView liste;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        liste = (ListView) findViewById(R.id.liste);

        ArrayList<String> elements = new ArrayList<>();
        elements.add("élément1");
        elements.add("élément2");

        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1,elements);

        liste.setAdapter(adapter);



        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
          Log.i("MYTAG", "l'élément " + position +
                        " a été cliqué");
          Toast.makeText(getApplicationContext(),"l'élément " + position
                        + " a été cliqué", Toast.LENGTH_LONG).show();
            }
        });


    }
}
