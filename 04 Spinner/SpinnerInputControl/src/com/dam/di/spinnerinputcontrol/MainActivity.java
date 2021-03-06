package com.dam.di.spinnerinputcontrol;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Tenemos 2 formas de generar el listado de opciones del Spinner
		// 1. A PARTIR DE UN ARRAY DE STRINGS DECLARADO EN /res/values/strings.xml
		
		Spinner spinner = (Spinner) findViewById(R.id.spinnerPlanetas);
		// Creamos un ArrayAdapter haciendo uso del Layout para array de String por defecto
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.planetas, android.R.layout.simple_spinner_item);
		// Especificamos qu� layout va a mostrarse cuando aparezca el listado de opciones
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Una vez definido el Adaptador, necesitamos aplicarlo al Spinner.
		spinner.setAdapter(adapter);
		
		// 2. A PARTIR DE UN ARRAY QUE SE DECLARE EN ESTA MISMA CLASE
		String colors[] = {"Rojo","Naranja","Amarillo","Verde", "Azul","A�il","Violeta"};
		Spinner spinnerColores = (Spinner) findViewById(R.id.spinnerColores);

		// Aplicamos el array de String colors[] declarado al Spinner (3er par�metro).
		ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(this,  android.R.layout.simple_spinner_item, colors);
		spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
		spinnerColores.setAdapter(spinnerArrayAdapter);
		
		// 3. A PARTIR DE DATOS DE UNA BBDD.
		// A�n no veremos este caso...
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
