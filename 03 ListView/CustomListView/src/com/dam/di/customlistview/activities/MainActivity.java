package com.dam.di.customlistview.activities;


import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dam.di.customlistview.R;
import com.dam.di.customlistview.adapters.AdaptadorItemFruta;

public class MainActivity extends Activity {
	
	ListView listview;
	ArrayList<ItemFruta> listaItem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listview = (ListView) findViewById(R.id.listView);
		listaItem = new ArrayList<ItemFruta>();

		// A–adimos a nuestra lista los productos que aparecer‡n en 
		// el listView
		listaItem.add(new ItemFruta("Cereza", R.drawable.cereza));
		listaItem.add(new ItemFruta("Fresa",  R.drawable.fresa));
		listaItem.add(new ItemFruta("Lim—n",  R.drawable.limon));
		listaItem.add(new ItemFruta("Manzana",  R.drawable.manzana));
		listaItem.add(new ItemFruta("Melocot—n",  R.drawable.melocoton));
		listaItem.add(new ItemFruta("Mora",  R.drawable.mora));
		listaItem.add(new ItemFruta("Uva",  R.drawable.uva));

		//Crear un nuevo adaptador que nos permita asignar al ListView
		// elementos de tipo ItemFruta.
		AdaptadorItemFruta adapter = new AdaptadorItemFruta(this, listaItem);
		listview.setAdapter(adapter);

		//registerForContextMenu(listview);
	}




}
