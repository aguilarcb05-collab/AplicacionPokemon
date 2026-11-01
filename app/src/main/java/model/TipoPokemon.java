package model;

import com.example.aplicacionpokemon.R;

public enum TipoPokemon {
    PLANTA(R.drawable.planta),
    FUEGO(R.drawable.fuego),
    AGUA(R.drawable.agua),
    VENENO(R.drawable.veneno),
    TIERRA(R.drawable.tierra),
    PSIQUICO(R.drawable.psiquico),
    HIELO(R.drawable.hielo);

    private final int resId;

    // Constructor del enum
    TipoPokemon(int resId) {
        this.resId = resId;
    }

    // Getter para obtener el ID de la imagen de forma limpia
    public int getResId() {
        return resId;
    }
}
