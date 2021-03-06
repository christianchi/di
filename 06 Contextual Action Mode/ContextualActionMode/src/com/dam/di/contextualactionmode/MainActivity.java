package com.dam.di.contextualactionmode;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ActionMode mActionMode;
	ListView lista;
	ArrayAdapter<String> adapter;
	ArrayList<String> listaItems;
	public int selectedItem = -1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lista = (ListView) findViewById(R.id.listView);
		listaItems = new ArrayList<String>();
		listaItems.add("Miguel");
		listaItems.add("Pepito");
		listaItems.add("Fulanito");
		listaItems.add("Olivia");
		listaItems.add("Popeye");
		

		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, listaItems);
		lista.setAdapter(adapter);

		lista.setOnItemLongClickListener(new OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {

				if (mActionMode != null) {
					return false;
				}

				selectedItem = position;
				Toast.makeText(getApplicationContext(),
						"Seleccionado el " + position, Toast.LENGTH_LONG)
						.show();

				// Start the CAB using the ActionMode.Callback defined above
				mActionMode = MainActivity.this.startActionMode(mActionModeCallback);
				view.setSelected(true);
				return true;
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.options_menu_main, menu);
		return true;
	}
	
	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.addUsuario:
			listaItems.add("Nuevo");
			// Actualizar el listView del layout
			adapter.notifyDataSetChanged();
			return true;
		default:
			return false;
		}
	}



	private ActionMode.Callback mActionModeCallback = new ActionMode.Callback() {

		// Called when the action mode is created; startActionMode() was called
		@Override
		public boolean onCreateActionMode(ActionMode mode, Menu menu) {
			// Inflate a menu resource providing context menu items
			MenuInflater inflater = mode.getMenuInflater();
			inflater.inflate(R.menu.action_mode_context_menu, menu);
			return true;
		}

		// Called each time the action mode is shown. Always called after
		// onCreateActionMode, but
		// may be called multiple times if the mode is invalidated.
		@Override
		public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
			return false; // Return false if nothing is done
		}

		// Called when the user selects a contextual menu item
		@Override
		public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
			switch (item.getItemId()) {
			case R.id.item_delete:
				Toast.makeText(getApplicationContext(), "Eliminado",
						Toast.LENGTH_LONG).show();
				eliminar(selectedItem);
				mode.finish(); // Action picked, so close the CAB
				return true;
			default:
				return false;
			}
		}

		// Called when the user exits the action mode
		@Override
		public void onDestroyActionMode(ActionMode mode) {
			mActionMode = null;
			selectedItem = -1;
		}

		private void eliminar(int selectedItem) {
			listaItems.remove(selectedItem);
			adapter.notifyDataSetChanged();
		}

	};

}
