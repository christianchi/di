package com.dam.di.contextualactionmode;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {


	AdaptadorUsuario adapter;
	ListView lista;
	ArrayList<Usuario> listaUsuario;
	ActionMode mActionMode;
	public int selectedItem = -1, contadorCheck = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lista = (ListView) findViewById(R.id.listView);
		listaUsuario = new ArrayList<Usuario>();
		listaUsuario.add(new Usuario("Miguel"));
		listaUsuario.add(new Usuario("Rebeca"));
		listaUsuario.add(new Usuario("Rebeca Campos"));
		listaUsuario.add(new Usuario("Olivia"));
		listaUsuario.add(new Usuario("Miriam"));

		adapter = new AdaptadorUsuario(this);
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
				mActionMode = MainActivity.this
						.startActionMode(mActionModeCallback);
				view.setSelected(true);
				return true;
			}
		});

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
			listaUsuario.remove(selectedItem);
			adapter.notifyDataSetChanged();
		}

	};

	// Adaptador de items de tipo Usuario
	class AdaptadorUsuario extends ArrayAdapter<Usuario> {
		CheckBox check;

		Activity context;

		AdaptadorUsuario(Activity context) {
			super(context, R.layout.user_list_item, listaUsuario);
			this.context = context;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			selectedItem = position;
			View item = convertView;
			LayoutInflater inflater = context.getLayoutInflater();

			item = inflater.inflate(R.layout.user_list_item, null);

			check = (CheckBox) item.findViewById(R.id.checkUsuario);

			Usuario usuario = listaUsuario.get(position);
			check.setText(usuario.getNombre());

			check.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View viewCheck) {
					String titulo = "";
					
					if (((CheckBox) viewCheck).isChecked()) { // Si checkbox = checked
						// Incremento el contador de checkboxes
						contadorCheck++;

						// Compruebo si el actionMode se ha instanciado ya
						if (mActionMode == null) {
							mActionMode = MainActivity.this
									.startActionMode(mActionModeCallback);
						} else {
							// Marco en la lista que el elemento con la posici�n = selectedItem
							// est� chequeado.
							lista.setItemChecked(selectedItem, true);
						}

						
						if(contadorCheck==1) {
							titulo = contadorCheck + " seleccionado";
						} else {
							titulo = contadorCheck + " seleccionados";
						}
						mActionMode.setTitle(titulo);
						
					} else { // Si checkbox != checked
						// Lo primero que hago es indicar que el elemento del ListView lista,
						// que ocupa la posici�n selectedItem no est� chequeado = false.
						lista.setItemChecked(selectedItem, false);
						contadorCheck--;
						if (contadorCheck == 0) {
							// finalizo el actionMode = que el actionBar vuelva a su estado
							// original
							mActionMode.finish();
						} else {
							if(contadorCheck==1) {
								titulo = contadorCheck + " seleccionado";
							} else {
								titulo = contadorCheck + " seleccionados";
							}
							mActionMode.setTitle(titulo);
						}
					}

				}
			});

			return (item);
		}
	}

}
