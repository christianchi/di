package com.dam.di.contextualactionmode;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class EdicionActivity extends Activity {
	
	ArrayList<String> usuariosEditados;
	int posiciones[];
	LinearLayout layout;
	int cont;

	@Override
	protected void onCreate(Bundle datos) {
		super.onCreate(datos);
		setContentView(R.layout.activity_edicion);
		
		cont = getIntent().getIntExtra("contador",0);
		
		// TODO
		// Recibir por el Extra como parámetro un String[]
		// con todos los nombres de usuarios
		usuariosEditados = getIntent().getStringArrayListExtra("listUsers");
		posiciones = getIntent().getIntArrayExtra("posiciones");
		
		layout = (LinearLayout)findViewById(R.id.layoutEdicion);
		
		// Itero tantas veces como me indique el contador de Checks
		// que he recibido como parámetro del Intent en la variable "cont"
		for(int i=0; i<cont; i++) {
			// 1. Me creo un nuevo EditText
			EditText cajaTexto = new EditText(EdicionActivity.this);
			cajaTexto.setText(usuariosEditados.get(i));
			// 2. Enlazarlo como un hijo (child) del LinearLayout.
			layout.addView(cajaTexto);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.edicion, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.saveEdit:
			
			
			// Recorro los hijos (children) del LinearLayout
			for(int i=0; i<cont; i++) {
				// Obtengo el EditText (que es hijo de LinearLayout layout)
				// de la posición i.
				EditText cajaTexto = (EditText)layout.getChildAt(i);
				String nombreEditado = cajaTexto.getText().toString();
				usuariosEditados.set(i, nombreEditado);
			}
			
			Intent i = new Intent(EdicionActivity.this, MainActivity.class);
			i.putExtra("listUsersEditados", usuariosEditados);
			i.putExtra("posiciones", posiciones);
			setResult(RESULT_OK, i);
			finish();
			
			return true;
		default:
			return false;
		}
	}
	
	

}
