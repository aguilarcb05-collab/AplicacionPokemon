package database;

import java.util.ArrayList;
import java.util.List;

import model.Pokemon;
import model.TipoPokemon;

public class PopulateDatabase {
    public static List<Pokemon> pokemons=new ArrayList<>();

    public static void populate(){
        if(pokemons.isEmpty()){
            // Lista de Pokémon con atributos realistas y todos los tipos cubiertos
            pokemons.add(new Pokemon(1, "Bulbasaur", 45, 49, 49, 45, TipoPokemon.PLANTA));
            pokemons.add(new Pokemon(4, "Charmander", 39, 52, 43, 65, TipoPokemon.FUEGO));
            pokemons.add(new Pokemon(7, "Squirtle", 44, 48, 65, 43, TipoPokemon.AGUA));
            pokemons.add(new Pokemon(23, "Ekans", 35, 60, 44, 55, TipoPokemon.VENENO));
            pokemons.add(new Pokemon(27, "Sandshrew", 50, 75, 85, 40, TipoPokemon.TIERRA));
            pokemons.add(new Pokemon(63, "Abra", 25, 20, 15, 90, TipoPokemon.PSIQUICO));
            pokemons.add(new Pokemon(361, "Snorunt", 50, 50, 50, 50, TipoPokemon.HIELO));
            pokemons.add(new Pokemon(2, "Ivysaur", 60, 62, 63, 60, TipoPokemon.PLANTA));
            pokemons.add(new Pokemon(5, "Charmeleon", 58, 64, 58, 80, TipoPokemon.FUEGO));
            pokemons.add(new Pokemon(8, "Wartortle", 59, 63, 80, 58, TipoPokemon.AGUA));
            pokemons.add(new Pokemon(24, "Arbok", 60, 85, 69, 80, TipoPokemon.VENENO));
            pokemons.add(new Pokemon(28, "Sandslash", 75, 100, 110, 65, TipoPokemon.TIERRA));
            pokemons.add(new Pokemon(64, "Kadabra", 40, 35, 30, 105, TipoPokemon.PSIQUICO));
            pokemons.add(new Pokemon(471, "Glaceon", 65, 60, 110, 65, TipoPokemon.HIELO));
            pokemons.add(new Pokemon(3, "Venusaur", 80, 82, 83, 80, TipoPokemon.PLANTA));
            pokemons.add(new Pokemon(6, "Charizard", 78, 84, 78, 100, TipoPokemon.FUEGO));
            pokemons.add(new Pokemon(9, "Blastoise", 79, 83, 100, 78, TipoPokemon.AGUA));
            pokemons.add(new Pokemon(74, "Geodude", 40, 80, 100, 20, TipoPokemon.TIERRA));
            pokemons.add(new Pokemon(150, "Mewtwo", 106, 110, 90, 130, TipoPokemon.PSIQUICO));
            pokemons.add(new Pokemon(131, "Lapras", 130, 85, 80, 60, TipoPokemon.HIELO));
            pokemons.add(new Pokemon(10, "Caterpie", 45, 30, 35, 45, TipoPokemon.PLANTA));
            pokemons.add(new Pokemon(37, "Vulpix", 38, 41, 40, 65, TipoPokemon.FUEGO));
            pokemons.add(new Pokemon(54, "Psyduck", 50, 52, 48, 55, TipoPokemon.AGUA));
            pokemons.add(new Pokemon(41, "Zubat", 40, 45, 35, 55, TipoPokemon.VENENO));
            pokemons.add(new Pokemon(50, "Diglett", 10, 55, 25, 95, TipoPokemon.TIERRA));
            pokemons.add(new Pokemon(122, "Mr. Mime", 40, 45, 65, 90, TipoPokemon.PSIQUICO));
            pokemons.add(new Pokemon(220, "Swinub", 50, 50, 40, 50, TipoPokemon.HIELO));
            pokemons.add(new Pokemon(43, "Oddish", 45, 50, 55, 30, TipoPokemon.PLANTA));
            pokemons.add(new Pokemon(126, "Magmar", 65, 95, 57, 93, TipoPokemon.FUEGO));
            pokemons.add(new Pokemon(129, "Magikarp", 20, 10, 55, 80, TipoPokemon.AGUA));
        }
    }
}
