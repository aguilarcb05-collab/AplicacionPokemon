package com.example.aplicacionpokemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import adapter.PokemonAdapter;
import database.PopulateDatabase;
import model.Pokemon;
import model.TipoPokemon;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnNewPokemon;
    ListView listaPersonalizada;
    Button btnFiltrar;
    Spinner sTipo;
    PokemonAdapter adapterPokemon;
    ArrayAdapter<TipoPokemon> adapterEnum;

    // 1. Creamos una lista temporal que será la que manipule el adapter visualmente
    private List<Pokemon> listaVisual;

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
        PopulateDatabase.populate();

        listaPersonalizada = findViewById(R.id.listaPersonalizada);
        btnFiltrar = findViewById(R.id.btnFiltrar);
        btnNewPokemon = findViewById(R.id.btnNewPokemon);
        sTipo = findViewById(R.id.sTipo);
        btnNewPokemon.setOnClickListener(this);
        btnFiltrar.setOnClickListener(this);

        // Adapter del enum de manera simple:
        adapterEnum = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, TipoPokemon.values());
        adapterEnum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sTipo.setAdapter(adapterEnum);

        // 2. Inicializamos la lista visual copiando los elementos de la base de datos
        listaVisual = new ArrayList<>(PopulateDatabase.pokemons);

        // 3. Pasamos la lista visual al adapter, NUNCA directamente la de PopulateDatabase
        adapterPokemon = new PokemonAdapter(MainActivity.this, 0, listaVisual);
        listaPersonalizada.setAdapter(adapterPokemon);

        listaPersonalizada.setOnItemClickListener((parent, view, position, id) -> {
            // Cogemos el pokemon usando la lista visual actual (por si está filtrada)
            Pokemon p = listaVisual.get(position);
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            intent.putExtra("pokemons", p);
            startActivity(intent);
        });
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnNewPokemon) {
            Intent intent = new Intent(this, CrearPokemon.class);
            startActivity(intent);
        }

        if (view.getId() == R.id.btnFiltrar) {
            // 1. Obtenemos el tipo seleccionado en el Spinner
            TipoPokemon tipoSeleccionado = (TipoPokemon) sTipo.getSelectedItem();

            // 2. Vaciamos nuestra lista visual local (sin tocar PopulateDatabase)
            adapterPokemon.clear();

            // 3. Recorremos la lista maestra intacta y filtramos
            for (Pokemon p : PopulateDatabase.pokemons) {
                if (p.getTipo() == tipoSeleccionado) {
                    adapterPokemon.add(p);
                }
            }

            // 4. Refrescamos el adapter
            adapterPokemon.notifyDataSetChanged();
        }
    }
}