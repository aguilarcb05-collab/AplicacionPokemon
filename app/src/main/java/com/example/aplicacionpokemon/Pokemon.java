package com.example.aplicacionpokemon;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private int id;
    private String nombre;
    private Double hp;
    private Double attach;
    private Double defense;
    private Double speed;
    private TipoPokemon tipo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getHp() {
        return hp;
    }

    public void setHp(Double hp) {
        this.hp = hp;
    }

    public Double getAttach() {
        return attach;
    }

    public void setAttach(Double attach) {
        this.attach = attach;
    }

    public Double getDefense() {
        return defense;
    }

    public void setDefense(Double defense) {
        this.defense = defense;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }

    public Pokemon(int id, String nombre, Double hp, Double attach, Double defense, Double speed, TipoPokemon tipo) {
        this.id = id;
        this.nombre = nombre;
        this.hp = hp;
        this.attach = attach;
        this.defense = defense;
        this.speed = speed;
        this.tipo = tipo;
    }

    public Pokemon() {
    }
}
