package model;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private int id;
    private String nombre;
    private int hp;
    private int attack;
    private int defense;
    private int speed;
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

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attach) {
        this.attack = attach;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }

    public Pokemon(int id, String nombre, int hp, int attack, int defense, int speed, TipoPokemon tipo) {
        this.id = id;
        this.nombre = nombre;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.tipo = tipo;
    }

    public Pokemon() {
    }
}
