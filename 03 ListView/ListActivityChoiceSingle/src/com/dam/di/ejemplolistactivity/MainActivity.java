package com.dam.di.ejemplolistactivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*
		 * x Muy importante: cuando se implementa una clase que extiende de
		 * ListActivity es necesario que el layout que se cargue contenga
		 * ListView cuyo id sea "@android:id/list":
		 * 
		 * <ListView android:id="@android:id/list"
		 * android:layout_width="match_parent"
		 * android:layout_height="wrap_content" > </ListView>
		 */

		setContentView(R.layout.activity_main);

		String[] sistemasOperativos = new String[] { "Android", "iPhone",
				"WindowsMobile", "Blackberry" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, sistemasOperativos);
		
		setListAdapter(adapter);
		
		
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.show_selected:
			int posicionSeleccionado = getListView().getCheckedItemPosition();
			Toast.makeText(getApplicationContext(), "Seleccionado: "+getListView().getItemAtPosition(posicionSeleccionado), Toast.LENGTH_SHORT).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);

		}
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// Indico que el elemento sobre el que se ha hecho clic es el que
		// est‡ seleccionado actualmente. Como nos encontramos en el Modo de
		// Selecci—n SINGLE, s—lo puede estar uno de los elementos seleccionados
		// IMPORTANTE: si se seleccionan varios, el que quedar‡ seleccionado ser‡
		// el œltimo elemento sobre el que se ha hecho clic.
		getListView().setItemChecked(position, true);
	}

	

}
