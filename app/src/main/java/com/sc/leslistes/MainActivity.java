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
    ArrayAdapter adapter ;
    ArrayList<String> source_donnees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // faire le lien entre notre objet à programmer et l'interface XML qui concerne la liste
        liste = (ListView) findViewById(R.id.liste);
        // créer la source de données pour la liste, donc notre cas simple il s'agit d'une liste de chaînes de caractères
        source_donnees = new ArrayList<>();
        source_donnees.add("élément1");
        source_donnees.add("élément2");

        // créer un adaptateur qui joue le rôle d'un intermidiaire
        // entre le coomposant graphique (liste) et la source des donnée (source_donnees)
        // android.R.layout.simple_list_item_1 est une vue déjà définit par développeur Android
        adapter = new ArrayAdapter(getApplicationContext(),
                android.R.layout.simple_list_item_1, source_donnees);

        // attacher l'adaptateur à notre liste
        liste.setAdapter(adapter);

        // définir un événenement qui sera lancé quand on clique sur un élément de la liste
        // on affiche un message contenat la position de l'élément cliqué et
        liste.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("MYTAG", "l'élément " + position + " a été cliqué");
                String contenu = liste.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "l'élément " + position + " a été cliqué"
                                + " sont contenu :" + contenu, Toast.LENGTH_LONG).show();
                // Ajouter un nouvelle élément quand un élément existe est cliqué
                source_donnees.add("élément" + String.valueOf(id));
                adapter.notifyDataSetChanged();

            }
        });


    }
}
