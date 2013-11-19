package com.dam.di.contextualactionmode;

import java.util.ArrayList;
import java.util.Iterator;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

public class MainActivity extends Activity {


	AdaptadorUsuario adapter;
	ListView lista;
	ArrayList<Usuario> listaUsuario, seleccionados;
	int posicionesUsuarios[];
	ActionMode mActionMode;
	public int contadorCheck = 0;
	private int EDICION_MULTIPLE_CODE = 1234;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lista = (ListView) findViewById(R.id.listView);
		listaUsuario = new ArrayList<Usuario>();
		listaUsuario.add(new Usuario("Miguel",0));
		listaUsuario.add(new Usuario("Rebeca",1));
		listaUsuario.add(new Usuario("Juan",2));
		listaUsuario.add(new Usuario("Olivia",3));
		listaUsuario.add(new Usuario("Miriam",4));
		
		seleccionados = new ArrayList<Usuario>();
		
		posicionesUsuarios = new int[5];

		adapter = new AdaptadorUsuario(this);
		lista.setAdapter(adapter);

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
			case R.id.item_edit:
				
				editarSeleccionados();

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
			contadorCheck = 0;
		}

		private void editarSeleccionados() {
			Iterator<Usuario> it = seleccionados.iterator();
			ArrayList<String> nombresUsuarios = new ArrayList<String>();
			
			int j=0;
			while(it.hasNext()) {
				Usuario u = (Usuario)it.next();
				int posicion = listaUsuario.lastIndexOf(u);
				String nombre = u.getNombre();
				
				nombresUsuarios.add(nombre);
				posicionesUsuarios[j] = posicion;
				j++;
			}
			
			Intent i = new Intent(MainActivity.this,EdicionActivity.class);
			i.putExtra("contador", contadorCheck);
			i.putStringArrayListExtra("listUsers",nombresUsuarios);
			i.putExtra("posiciones", posicionesUsuarios);
			startActivityForResult(i, EDICION_MULTIPLE_CODE);
			contadorCheck = 0;
			mActionMode.finish();
			
		}

	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// El ArrayList que contiene los nombre de usuarios editados
		ArrayList<String> usuariosEditados = data.getStringArrayListExtra("listUsersEditados");
		int[] posiciones = data.getIntArrayExtra("posiciones");
		
		listaUsuario = new ArrayList<Usuario>();
		Iterator<String> it = usuariosEditados.iterator();
		
		int i=0;
		while(it.hasNext()) {
			String nombreEditado = (String)it.next();
			listaUsuario.get(posiciones[i]).setNombre(nombreEditado);
			i++;
		}
		
		adapter.notifyDataSetChanged();
		contadorCheck = 0;
	}



	// Adaptador de items de tipo Usuario
	class AdaptadorUsuario extends ArrayAdapter<Usuario> {
		CheckBox check;

		Activity context;

		AdaptadorUsuario(Activity context) {
			super(context, R.layout.user_list_item, listaUsuario);
			this.context = context;
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			View item = convertView;
			LayoutInflater inflater = context.getLayoutInflater();

			item = inflater.inflate(R.layout.user_list_item, null);

			check = (CheckBox) item.findViewById(R.id.checkUsuario);
			check.setText(listaUsuario.get(position).getNombre());
			check.setTag(Integer.valueOf(position));

			check.setOnClickListener(new View.OnClickListener() {

				@Override
				public void onClick(View viewCheck) {
					String titulo = "";
					CheckBox checkbox = (CheckBox)viewCheck;
					int posicion = ((Integer)checkbox.getTag()).intValue();
					
					Usuario usuarioSeleccionado = listaUsuario.get(posicion);
					
					if (((CheckBox) viewCheck).isChecked()) { // Si checkbox = checked
						seleccionados.add(usuarioSeleccionado);
						// Incremento el contador de checkboxes
						contadorCheck++;

						// Compruebo si el actionMode se ha instanciado ya
						if (mActionMode == null) {
							mActionMode = MainActivity.this
									.startActionMode(mActionModeCallback);
						}
	
						if(contadorCheck==1) {
							titulo = contadorCheck + " seleccionado";
						} else {
							titulo = contadorCheck + " seleccionados";
						}
						mActionMode.setTitle(titulo);
						
					} else { // Si checkbox != checked
				
						seleccionados.remove(usuarioSeleccionado);
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
