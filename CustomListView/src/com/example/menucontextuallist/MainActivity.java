package com.example.menucontextuallist;


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

public class MainActivity extends Activity {
	
	ListView listview;
	ArrayList<ItemFruta> listaItem;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		listview = (ListView) findViewById(R.id.listView);
		listaItem = new ArrayList<ItemFruta>();

		// A�adimos a nuestra lista los productos que aparecer�n en 
		// el listView
		listaItem.add(new ItemFruta("Cereza", "drawable/cereza"));
		listaItem.add(new ItemFruta("Fresa", "drawable/fresa"));
		listaItem.add(new ItemFruta("Lim�n", "drawable/limon"));
		listaItem.add(new ItemFruta("Manzana", "drawable/manzana"));
		listaItem.add(new ItemFruta("Melocot�n", "drawable/melocoton"));
		listaItem.add(new ItemFruta("Mora", "drawable/mora"));
		listaItem.add(new ItemFruta("Uva", "drawable/uva"));

		//Crear un nuevo adaptador que nos permita asignar al ListView
		// elementos de tipo ItemFruta.
		AdaptadorItemFruta adapter = new AdaptadorItemFruta(this);
		listview.setAdapter(adapter);

		//registerForContextMenu(listview);
	}


	// Adaptador de items
	class AdaptadorItemFruta extends ArrayAdapter<ItemFruta>{
		ImageView icono;
		TextView texto;
		CheckBox check;

		Activity context;

		AdaptadorItemFruta(Activity context) {
			// Le paso al constructor padre el layout que define
			// un elemento de la lista y el listado de elementos
			// que deber� ser mostrado.
			super(context, R.layout.list_item, listaItem);
			this.context = context;
		}

		// El m�todo getView ser� invocado tantas veces como posiciones
		// tenga el array listaItem.
		public View getView(int position, View convertView, ViewGroup parent) {

			View item = convertView;

			/*
			 *      ListView
			 * 			|
			 * 		--------------------------------------
			 * 		|									|
			 * RelativeLayout						RelativeLayout
			 * 		|									|
			 *    -------------------------------	   ...
			 *    |			|					|
			 * Checkbox	   ImageView			TextView
			 * 				|					|
			 * 				drawable/cereza	  Cereza
			 */
			
			// El inflater lo que es obtener View que ser� inyectado
			// en el �rbol de la vista principal en la que est� el ListView
			LayoutInflater inflater = context.getLayoutInflater();
			
			// Cada RelativeLayout que cuelga de ListView en el �rbol
			// anterior, proviene de haber rellenado con los datos de la
			// fruta correspondiente el objeto item definido a continuaci�n.
			item = inflater.inflate(R.layout.list_item, null);

			// Hasta este punto los elementos del layout list_item.xml
			// est�n vac�os. Tendr� que rescatarlos para rellenarlos con 
			// los datos de la fruta que estoy recorriendo en este momento
			icono = (ImageView) item.findViewById(R.id.icono);
			texto = (TextView) item.findViewById(R.id.texto);
			check = (CheckBox) item.findViewById(R.id.seleccionado);

			// La fruta actual es la que ocupa la posici�n "position"
			// dentro del ArrayList listaItem.
			ItemFruta itemFruta = listaItem.get(position);

			// Asigno el texto y la imagen del elemento itemFruta
			// que acabo de obtener del array. 
			// el m�todo getIdintifier() permite obtener un n�mero entero que
			// referencia a un recurso, a partir de un string, p.e. "drawable/cereza"
			// Para este ejemplo devolver�a -> R.drawable.cereza
			int imageResource = getResources().getIdentifier(itemFruta.getImagen(), null, getPackageName());
			icono.setImageDrawable(getResources().getDrawable(imageResource));
			texto.setText(itemFruta.getTexto());

			return(item);
		}
	}




}
