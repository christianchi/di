package com.dam.di.contextualactionmode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

	UsuarioArrayAdapter adapter;
	List<Usuario> listaUsuario;


	/** Called when the activity is first created. */

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		// create an array of Strings, that will be put to our ListActivity
		ArrayAdapter<Usuario> adapter = new UsuarioArrayAdapter(this,
				getModel());
		setListAdapter(adapter);
	}


	private List<Usuario> getModel() {
		listaUsuario = new ArrayList<Usuario>();
		listaUsuario.add(new Usuario("Miguel"));
		listaUsuario.add(new Usuario("Rebeca"));
		listaUsuario.add(new Usuario("Rebeca Campos"));
		listaUsuario.add(new Usuario("Olivia"));
		listaUsuario.add(new Usuario("Miriam"));

		listaUsuario.get(1).setSeleccionado(true);
		return listaUsuario;
	}

	private Usuario get(String s) {
		return new Usuario(s);
	}

	

}
