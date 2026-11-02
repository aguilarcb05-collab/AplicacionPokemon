package com.example.aplicacionpokemon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import database.PopulateDatabase;
import model.Pokemon;

public class detalles extends AppCompatActivity implements View.OnClickListener{

    TextView tvNombre2;
    TextView tvHp2;
    TextView tvAttack2;
    TextView tvDefense2;
    TextView tvSpeed2;
    TextView tvTipo;
    Button btnEditar;
    Button btnBorrar;
    Button btnAtras;
    ImageView ivImagen;

    Pokemon p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.detalles);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Intent detalles = getIntent();
        p = (Pokemon) detalles.getSerializableExtra("pokemons");
        tvNombre2=findViewById(R.id.tvNombre2);
        tvHp2=findViewById(R.id.tvHp2);
        tvAttack2=findViewById(R.id.tvAttach2);
        tvDefense2=findViewById(R.id.tvDefense2);
        tvSpeed2=findViewById(R.id.tvSpeed2);
        tvTipo=findViewById(R.id.tvTipo);
        ivImagen=findViewById(R.id.ivImagen);

        btnEditar=findViewById(R.id.btnEditar);
        btnAtras=findViewById(R.id.btnAtras);
        btnBorrar=findViewById(R.id.btnBorrar);

        tvNombre2.setText(p.getNombre());
        tvHp2.setText("HP: "+p.getHp());
        tvSpeed2.setText("Speed: "+p.getSpeed());
        tvDefense2.setText("Defense: "+p.getDefense());
        tvAttack2.setText("Attack "+p.getAttack());
        tvTipo.setText("Type: "+p.getTipo().name());
        ivImagen.setImageResource(p.getTipo().getResId());


        btnBorrar.setOnClickListener(this);
        btnAtras.setOnClickListener(this);
        btnEditar.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnAtras){
            Intent intentback=new Intent(this, MainActivity.class);
            startActivity(intentback);
        }
        if(v.getId() == R.id.btnEditar){
            Intent intentedit=new Intent(this, editarPokemon.class);
            intentedit.putExtra("pokemon_objeto",p);
            startActivity(intentedit);
        }
        if(v.getId() == R.id.btnBorrar){

            for(int i = 0; i < PopulateDatabase.pokemons.size(); i++){

                if(PopulateDatabase.pokemons.get(i).getId()==(p.getId())){

                    PopulateDatabase.pokemons.remove(i);
                    break;
                }
            }
            Toast.makeText(getApplicationContext(),"Pokemon borrado correctamente",Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}