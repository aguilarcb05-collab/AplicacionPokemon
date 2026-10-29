package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.aplicacionpokemon.R;

import org.w3c.dom.Text;

import java.util.List;

import model.Pokemon;

public class PokemonAdapter extends ArrayAdapter<Pokemon> {
    public PokemonAdapter(Context context, int resource, List<Pokemon> objects) {
        super(context, resource, objects);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pokemon p = getItem(position);

        if (convertView == null) {
            // Saco el layoutInflater del context (activity)
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(R.layout.item_personalizado, parent, false);
        }
        TextView tvNombre=convertView.findViewById(R.id.tvNombre);
        TextView tvHp = convertView.findViewById(R.id.tvHp);
        TextView tvAttack = convertView.findViewById(R.id.tvAttack);
        TextView tvDefense = convertView.findViewById(R.id.tvDefense);
        TextView tvSpeed = convertView.findViewById(R.id.tvSpeed);

        tvNombre.setText(p.getNombre());
        tvHp.setText(String.valueOf(p.getHp()));
        tvDefense.setText(String.valueOf(p.getDefense()));
        tvAttack.setText(String.valueOf(p.getAttach()));
        tvSpeed.setText(String.valueOf(p.getSpeed()));


        return convertView;
    }
}
