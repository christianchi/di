package com.miguelcr.animation;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {
	EditText gradosRotacion;
	ImageView imagenAnimada;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gradosRotacion = (EditText) findViewById(R.id.editText1);
		imagenAnimada = (ImageView) findViewById(R.id.imageView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void startAnimation(View view) {
		float dest = 0;
		
		switch (view.getId()) {

		case R.id.button1:
			
			ObjectAnimator animation1 = ObjectAnimator.ofFloat(imagenAnimada,
					"rotation", Float.valueOf(gradosRotacion.getText().toString()));
			animation1.setDuration(2000);
			animation1.start();
			
			// El c—digo siguiente hace lo mismo que las 3 l’neas de c—digo anteriores
			imagenAnimada.animate().rotation(Float.valueOf(gradosRotacion.getText().toString())).setDuration(2000);

			break;

		}

	}

}
