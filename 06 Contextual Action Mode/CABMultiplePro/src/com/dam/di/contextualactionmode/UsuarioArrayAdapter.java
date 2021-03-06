package com.dam.di.contextualactionmode;

import java.util.Iterator;
import java.util.List;

import android.app.Activity;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

public class UsuarioArrayAdapter extends ArrayAdapter<Usuario> {

	private final List<Usuario> listaUsuario;
	private final Activity context;
	ActionMode mActionMode;
	public int contadorCheck = 0;

	public UsuarioArrayAdapter(Activity context, List<Usuario> list) {
		super(context, R.layout.user_list_item, list);
		this.context = context;
		this.listaUsuario = list;
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

				eliminarTodos();

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

		private void eliminarTodos() {
			Iterator<Usuario> it = listaUsuario.iterator();
			while (it.hasNext()) {
				Usuario actual = (Usuario) it.next();
				if (actual.isSeleccionado())
					listaUsuario.remove(actual);
			}

		}

	};

	static class VistaUsuario {
		protected CheckBox checkbox;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = null;
		if (convertView == null) {
			LayoutInflater inflator = context.getLayoutInflater();
			view = inflator.inflate(R.layout.user_list_item, null);
			final VistaUsuario vistaUsuario = new VistaUsuario();
			vistaUsuario.checkbox = (CheckBox) view
					.findViewById(R.id.checkUsuario);
			vistaUsuario.checkbox
					.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

						@Override
						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							Usuario element = (Usuario) vistaUsuario.checkbox
									.getTag();
							element.setSeleccionado(buttonView.isChecked());
							String titulo="";
							if (buttonView.isChecked()) {
								// Incremento el contador de checkboxes
								contadorCheck++;

								// Compruebo si el actionMode se ha instanciado
								// ya
								if (mActionMode == null) {
									mActionMode = context
											.startActionMode(mActionModeCallback);
								}

								if (contadorCheck == 1) {
									titulo = contadorCheck + " seleccionado";
								} else {
									titulo = contadorCheck + " seleccionados";
								}
								mActionMode.setTitle(titulo);
							} else {
								contadorCheck--;
								if (contadorCheck == 0) {
									// finalizo el actionMode = que el actionBar
									// vuelva a su estado
									// original
									mActionMode.finish();
								} else {
									if (contadorCheck == 1) {
										titulo = contadorCheck
												+ " seleccionado";
									} else {
										titulo = contadorCheck
												+ " seleccionados";
									}
									mActionMode.setTitle(titulo);
								}
							}

						}
					});
			view.setTag(vistaUsuario);
			vistaUsuario.checkbox.setTag(listaUsuario.get(position));
		} else {
			view = convertView;
			((VistaUsuario) view.getTag()).checkbox.setTag(listaUsuario
					.get(position));
		}
		VistaUsuario holder = (VistaUsuario) view.getTag();
		holder.checkbox.setText(listaUsuario.get(position).getNombre());
		holder.checkbox.setChecked(listaUsuario.get(position).isSeleccionado());
		return view;
	}
}