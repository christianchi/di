package com.example.menucontextuallist;


import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	ListView listview;
	ArrayList<ItemFruta> listaItem;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listview = (ListView) findViewById(R.id.listView);
		listaItem = new ArrayList<ItemFruta>();

		listaItem.add(new ItemFruta("Cereza", "drawable/cereza"));
		listaItem.add(new ItemFruta("Fresa", "drawable/fresa"));
		listaItem.add(new ItemFruta("Lim�n", "drawable/limon"));
		listaItem.add(new ItemFruta("Manzana", "drawable/manzana"));
		listaItem.add(new ItemFruta("Melocot�n", "drawable/melocoton"));
		listaItem.add(new ItemFruta("Mora", "drawable/mora"));
		listaItem.add(new ItemFruta("Uva", "drawable/uva"));

		AdaptadorItem adapter = new AdaptadorItem(this);
		listview.setAdapter(adapter);

		// Asociar al listView el Men� Contextual que ser�
		// declarado por la funci�n onCreateContextMenu
		registerForContextMenu(listview);
	}


	// Adaptador de items
	class AdaptadorItem extends ArrayAdapter<ItemFruta>{
		ImageView icono;
		TextView texto;
		CheckBox check;

		Activity context;

		AdaptadorItem(Activity context) {
			super(context, R.layout.list_item, listaItem);
			this.context = context;
		}

		public View getView(int position, View convertView, ViewGroup parent) {

			View item = convertView;

			LayoutInflater inflater = context.getLayoutInflater();
			item = inflater.inflate(R.layout.list_item, null);

			icono = (ImageView) item.findViewById(R.id.icono);
			texto = (TextView) item.findViewById(R.id.texto);
			check = (CheckBox) item.findViewById(R.id.seleccionado);

			ItemFruta itemFruta = listaItem.get(position);

			int imageResource = getResources().getIdentifier(itemFruta.getImagen(), null, getPackageName());
			icono.setImageDrawable(getResources().getDrawable(imageResource));
			texto.setText(itemFruta.getTexto());
			
			return(item);
		}
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
	                                ContextMenuInfo menuInfo) {
	    super.onCreateContextMenu(menu, v, menuInfo);
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.context_menu,menu);
	}




}
