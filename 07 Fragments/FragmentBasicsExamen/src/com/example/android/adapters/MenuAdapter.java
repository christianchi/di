package com.example.android.adapters;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.R;
import com.example.android.models.OpcionMenu;

public class MenuAdapter extends ArrayAdapter<OpcionMenu> {
	
	List<OpcionMenu> listaOpcionesMenu;
	TextView txtMenu;
	ImageView iconMenu;

	Activity context;

	public MenuAdapter(Activity context, List<OpcionMenu> listaOpcionesMenu) {
		super(context, R.layout.list_item_menu, listaOpcionesMenu);
		this.listaOpcionesMenu = listaOpcionesMenu;
		this.context = context;
	}

	// El método getView será invocado tantas veces como posiciones
	// tenga el array listaItem.
	public View getView(int position, View convertView, ViewGroup parent) {

		View item = convertView;

		LayoutInflater inflater = context.getLayoutInflater();		
		item = inflater.inflate(R.layout.list_item_menu, null);

		txtMenu = (TextView) item.findViewById(R.id.textoOpcionMenu);
		iconMenu = (ImageView) item.findViewById(R.id.imagenOpcionMenu);

		OpcionMenu opcion = OpcionMenu.MENU.get(position);
		
		item.setBackgroundColor(context.getResources().getColor(opcion.getColor()));
		txtMenu.setText(opcion.getTexto());
		iconMenu.setImageResource(opcion.getIcon());

		return(item);
	}
	

}
