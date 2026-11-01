package com.example.aplicacionpokemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

import database.PopulateDatabase;
import model.Pokemon;
import model.TipoPokemon;

public class CrearPokemon extends AppCompatActivity implements View.OnClickListener{

    ArrayAdapter<TipoPokemon> adapterEnum;
    Button btnGuardar;
    Button btnAtras;
    EditText tfNombre;
    EditText tfAttack;
    EditText tfHp;
    EditText tfDefense;
    EditText tfSpeed;
    Spinner sTipo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.crear_pokemon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        tfNombre=findViewById(R.id.tfNombre);
        tfAttack=findViewById(R.id.tfAttack);
        tfHp=findViewById(R.id.tfHp);
        tfDefense=findViewById(R.id.tfDefense);
        tfSpeed=findViewById(R.id.tfSpeed);
        sTipo=findViewById(R.id.sTipo);
        btnGuardar=findViewById(R.id.btnGuardar);
        btnAtras=findViewById(R.id.btnAtras);

        btnGuardar.setOnClickListener(this);
        btnAtras.setOnClickListener(this);

        // Adapter del enum de manera simple:
        adapterEnum = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, TipoPokemon.values());
        adapterEnum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sTipo.setAdapter(adapterEnum);
    }


    @Override
    public void onClick(View v) {

        Intent intent=new Intent(CrearPokemon.this, MainActivity.class);
        boolean encontrado=false;
        Pokemon pokemonNuevo=new Pokemon();

        if(v.getId()==R.id.btnGuardar){
            if(!tfNombre.getText().toString().isEmpty()
                    && !tfAttack.getText().toString().isEmpty()
                    && !tfDefense.getText().toString().isEmpty()
                    && !tfHp.getText().toString().isEmpty()
                    && !tfSpeed.getText().toString().isEmpty()){

                for(Pokemon p: PopulateDatabase.pokemons){

                    if(p.getNombre().equals(tfNombre.getText().toString())){
                        encontrado=true;
                        break;
                    }

                }

            }else{
                Toast.makeText(getApplicationContext(),"Necesita rellenar los datos de ese pokemon para crearlo",Toast.LENGTH_SHORT).show();
                return;
            }



            if(encontrado==false){
                pokemonNuevo=new Pokemon(generarIdAleatorioUnico(),tfNombre.getText().toString(),Integer.parseInt(tfHp.getText().toString()), Integer.parseInt(tfAttack.getText().toString()), Integer.parseInt(tfDefense.getText().toString()),Integer.parseInt(tfSpeed.getText().toString()),(TipoPokemon) sTipo.getSelectedItem());
                PopulateDatabase.pokemons.add(pokemonNuevo);
                Toast.makeText(getApplicationContext(),"Pokemon nuevo añadido",Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(),"No se ha encontrado ese pokemon en la base de datos",Toast.LENGTH_SHORT).show();
            }

        }
        if(v.getId()==R.id.btnAtras){
            startActivity(intent);
        }
    }
    public static int generarIdAleatorioUnico() {
        Random random = new Random();
        int idAleatorio;
        boolean idExiste;

        do {
            // Genera un número aleatorio entre 1 y 999
            idAleatorio = random.nextInt(999) + 1;
            idExiste = false;

            // Buscamos en la lista si algún Pokémon ya tiene este ID
            for (Pokemon p : PopulateDatabase.pokemons) {
                if (p.getId() == idAleatorio) { // Cambia getId() por como se llame tu método descriptor del ID
                    idExiste = true;
                    break; // Si ya existe, rompemos el bucle interno para generar otro número
                }
            }

        } while (idExiste); // Si el ID existe, el bucle repite y genera uno nuevo

        return idAleatorio;
    }

}