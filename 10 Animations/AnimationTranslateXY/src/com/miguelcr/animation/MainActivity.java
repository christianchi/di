package com.miguelcr.animation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {
	ImageView imagenAnimada;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imagenAnimada = (ImageView) findViewById(R.id.imageView1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void startAnimation(View view) {

		switch (view.getId()) {

		case R.id.button1:
			Button btn1 = (Button) findViewById(R.id.button1);
			
			if (imagenAnimada.getTranslationX() == 200) {
				imagenAnimada.animate().translationX(0).setDuration(1000);
			} else {
				imagenAnimada.animate().translationX(200);
			}

			break;

		case R.id.button2:
			if (imagenAnimada.getTranslationY() == 200) {
				imagenAnimada.animate().translationY(0);
			} else {
				imagenAnimada.animate().translationY(200);
			}

			break;

		}

	}

}
