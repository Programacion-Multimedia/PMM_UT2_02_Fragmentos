package com.example.fragmentos1;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fragmentos1.placeholder.PlaceholderContent;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView lista;
    private List<String> ejemplosLista;
    ArrayAdapter<String> adaptadorejemplo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        lista =(ListView) findViewById(R.id.ListViewEjemplo);
        ejemplosLista=new ArrayList<>();
        ejemplosLista.add("Madrid");
        ejemplosLista.add("Tenerife");
        ejemplosLista.add("Burgos");
        ejemplosLista.add("Avila");
        ejemplosLista.add("Aragon");
        ejemplosLista.add("Salamanca");
        ejemplosLista.add("Jaen");
        ejemplosLista.add("Cadiz");

        adaptadorejemplo= new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, ejemplosLista);

        lista.setAdapter(adaptadorejemplo);
        lista.setOnItemClickListener(this::onItemClick);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ItemFragment()).commit();
                for (int i = 0; i<=100;i++){
                    PlaceholderContent.ITEMS.add(new PlaceholderContent.PlaceholderItem(String.valueOf(i), "Articulo " + i, "Detallle"));
                    // PlaceholderContent.ITEMS.clear();
                }
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.app_bar_search);
        SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){

            @Override
            public boolean onQueryTextChange(String newText){
                return false   ;

            }
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(MainActivity.this, "Buscando: "+ query, Toast.LENGTH_LONG).show();
                searchView.clearFocus();
                return false;
            }
        });

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();

        if (id==R.id.Opcion_menu1){
            Toast.makeText(this, "Valencia", Toast.LENGTH_SHORT).show();

            ejemplosLista.clear();

            ejemplosLista.add("Alicante");
            ejemplosLista.add("Valencia");
            ejemplosLista.add("Castellon");

            adaptadorejemplo.notifyDataSetChanged();
            PlaceholderContent.ITEMS.clear();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ItemFragment()).commit();

            for (int i = 0; i<ejemplosLista.size();i++){
                PlaceholderContent.ITEMS.add(new PlaceholderContent.PlaceholderItem(String.valueOf(i+1), ejemplosLista.get(i), "Detallle"));
                // PlaceholderContent.ITEMS.clear();
            }


        } else if (id==R.id.Opcion_menu2){
            Toast.makeText(this, "Andalucia", Toast.LENGTH_SHORT).show();

            ejemplosLista.clear();

            ejemplosLista.add("Cadiz");
            ejemplosLista.add("Huelva");
            ejemplosLista.add("Malaga");
            ejemplosLista.add("Sevilla");
            ejemplosLista.add("Cordoba");
            ejemplosLista.add("Almeria");
            ejemplosLista.add("Jaen");


            adaptadorejemplo.notifyDataSetChanged();
            PlaceholderContent.ITEMS.clear();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ItemFragment()).commit();

            for (int i = 0; i<ejemplosLista.size();i++){

                PlaceholderContent.ITEMS.add(new PlaceholderContent.PlaceholderItem(String.valueOf(i+1), ejemplosLista.get(i), "Detallle"));
                // PlaceholderContent.ITEMS.clear();
            }


        } else if (id==R.id.Opcion_menu3){
            Toast.makeText(this, "Galicia", Toast.LENGTH_SHORT).show();

            ejemplosLista.clear();

            ejemplosLista.add("Lugo");
            ejemplosLista.add("Pontevedra");
            ejemplosLista.add("Ourense");
            ejemplosLista.add("A Coruña");



            adaptadorejemplo.notifyDataSetChanged();
            PlaceholderContent.ITEMS.clear();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new ItemFragment()).commit();
            for (int i = 0; i<ejemplosLista.size();i++){
                PlaceholderContent.ITEMS.add(new PlaceholderContent.PlaceholderItem(String.valueOf(i+1), ejemplosLista.get(i), "Detallle"));
                // PlaceholderContent.ITEMS.clear();
            }


        }
        return super.onOptionsItemSelected(item);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"El ejemplo seleccionado es : " + ejemplosLista.get(position),
                Toast.LENGTH_LONG ).show();
    }
}