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

import database.PopulateDatabase;
import model.Pokemon;
import model.TipoPokemon;

public class editarPokemon extends AppCompatActivity implements View.OnClickListener{
    ArrayAdapter<TipoPokemon> adapterEnum;
    Button btnGuardar;
    Button btnAtras;
    EditText tfNombre;
    EditText tfAttack;
    EditText tfHp;
    EditText tfDefense;
    EditText tfSpeed;
    Spinner sTipo;
    Pokemon pokemonAEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.editar_pokemon);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        if (getIntent() != null) {
            pokemonAEditar = (Pokemon) getIntent().getSerializableExtra("pokemon_objeto");
        }

        tfNombre=findViewById(R.id.tfNombre);
        tfAttack=findViewById(R.id.tfAttack);
        tfHp=findViewById(R.id.tfHp);
        tfDefense=findViewById(R.id.tfDefense);
        tfSpeed=findViewById(R.id.tfSpeed);
        sTipo=findViewById(R.id.sTipo);
        btnGuardar=findViewById(R.id.btnGuardar);
        btnAtras=findViewById(R.id.btnAtras);

        tfNombre.setText(pokemonAEditar.getNombre());
        tfHp.setText(String.valueOf(pokemonAEditar.getHp()));
        tfAttack.setText(String.valueOf(pokemonAEditar.getAttack()));
        tfDefense.setText(String.valueOf(pokemonAEditar.getDefense()));
        tfSpeed.setText(String.valueOf(pokemonAEditar.getSpeed()));

        btnGuardar.setOnClickListener(this);
        btnAtras.setOnClickListener(this);

        // Adapter del enum de manera simple:
        adapterEnum = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, TipoPokemon.values());
        adapterEnum.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sTipo.setAdapter(adapterEnum);
    }


    @Override
    public void onClick(View v) {

        Intent intent=new Intent(editarPokemon.this, MainActivity.class);

        boolean encontrado=false;
        if(v.getId()==R.id.btnGuardar){
            if(!tfNombre.getText().toString().isEmpty()
                    && !tfAttack.getText().toString().isEmpty()
                    && !tfDefense.getText().toString().isEmpty()
                    && !tfHp.getText().toString().isEmpty()
                    && !tfSpeed.getText().toString().isEmpty()){

                for (Pokemon p : PopulateDatabase.pokemons) {
                    if (p.getId() == pokemonAEditar.getId()) {
                        p.setNombre(tfNombre.getText().toString().trim());
                        p.setHp(Integer.parseInt(tfHp.getText().toString()));
                        p.setAttack(Integer.parseInt(tfAttack.getText().toString()));
                        p.setDefense(Integer.parseInt(tfDefense.getText().toString()));
                        p.setSpeed(Integer.parseInt(tfSpeed.getText().toString()));
                        p.setTipo((TipoPokemon) sTipo.getSelectedItem());
                        encontrado=true;
                        break;
                    }
                }

            }else{
                Toast.makeText(getApplicationContext(),"Necesita rellenar los datos de ese pokemon para modificarlo",Toast.LENGTH_SHORT).show();
                return;
            }



            if(encontrado==true){
                Toast.makeText(getApplicationContext(),"Pokemon modificado",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(getApplicationContext(),"No se ha encontrado ese pokemon en la base de datos",Toast.LENGTH_SHORT).show();
            }

            startActivity(intent);
        }
        if(v.getId()==R.id.btnAtras){
            startActivity(intent);
        }
    }
}