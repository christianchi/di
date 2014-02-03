package com.dam.ontouchexample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.TextView;

public class OnTouchActivity extends Activity implements OnTouchListener, OnClickListener {

	int i;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_on_touch);
		
		TextView entrada = (TextView) findViewById(R.id.TextViewEntrada);
		entrada.setOnTouchListener(this);
		
		Button btnLimpiar = (Button) findViewById(R.id.button1);
		btnLimpiar.setOnClickListener(this);
		i=0;
	}

	@Override
	public boolean onTouch(View v, MotionEvent evento) {
		i++;
		TextView salida = (TextView) findViewById(R.id.TextViewSalida);
		
		// Imprimo información en el campo de texto del layout (TextViewSalida)
		salida.append(i+": ----------------------------"+"\n" );
		salida.append(evento.toString()+"\n");
		
		// Imprimo información por el LOGCAT
		Log.i("Nº evento:",i+": ----------------------------");
		Log.i("MT",evento.toString());
		return true;
	}

	
	@Override
	public void onClick(View v) {
		TextView salida = (TextView) findViewById(R.id.TextViewSalida);
		salida.setText("");
		i=1;
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_on_touch, menu);
		return true;
	}

}
