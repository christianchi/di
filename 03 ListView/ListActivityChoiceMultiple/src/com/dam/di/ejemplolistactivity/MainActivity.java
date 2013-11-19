package com.dam.di.ejemplolistactivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
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
				android.R.layout.simple_list_item_multiple_choice, sistemasOperativos);
		setListAdapter(adapter);
		getListView().setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
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
			String seleccionados = "";
			SparseBooleanArray checked = getListView().getCheckedItemPositions();
	        for (int i = 0; i < checked.size(); i++) {
	            if(checked.valueAt(i) == true) {
	                seleccionados += getListView().getItemAtPosition(checked.keyAt(i)).toString()+",";
	               
	            }
	        }
			Toast.makeText(getApplicationContext(), "Seleccionados: "+seleccionados, Toast.LENGTH_SHORT).show();
			return true;
		default:
			return super.onOptionsItemSelected(item);

		}
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// Indico que el elemento sobre el que se ha hecho clic se encuentra
		// seleccionado. Puede haber varios elementos seleccionados, ya que
		// en esta ocasi—n hemos indicado el modo de selecci—n MULTIPLE
		
		// Con esta condici—n hacemos que si el elemento ya est‡ marcado
		// y se ha vuelto a hacer check sobre Žl, se pueda desmarcar
		Log.i("STATE check","Valor checkbox: "+getListView().isItemChecked(position));
		
		if(getListView().isItemChecked(position)){
			Log.i("STATE check","Entra en true");
			getListView().setItemChecked(position, true);
		} else {
			Log.i("STATE check","Entra en false");
			getListView().setItemChecked(position, false);
		}
	}

}
