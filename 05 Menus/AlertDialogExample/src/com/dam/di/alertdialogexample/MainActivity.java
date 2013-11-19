package com.dam.di.alertdialogexample;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	final Context context = this;
	private Button button;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		button = (Button) findViewById(R.id.buttonAlert);

		// Capturamos el evento clic del bot—n
		// que lanzar‡ el cuadro de Di‡logo.
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
						context);

				// t’tulo del Di‡logo
				alertDialogBuilder.setTitle("Ejemplo AlertDialog");

				// mensaje del Di‡logo
				alertDialogBuilder
						.setMessage("ÀDesea cerrar la aplicaci—n?")
						.setCancelable(false)
						.setPositiveButton("S’",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										// si se pulsa en el bot—n "S’"
										// del cuadro de di‡logo, destruimos 
										// el activity actual.
										MainActivity.this.finish();
									}
								})
						.setNegativeButton("No",
								new DialogInterface.OnClickListener() {
									public void onClick(DialogInterface dialog,
											int id) {
										// Si se pulsa sobre el bot—n "No"
										// del cuadro de di‡logo, cerramos 
										// el di‡logo y no ocurre nada m‡s.
										dialog.cancel();
									}
								});

				// crear el di‡logo
				AlertDialog alertDialog = alertDialogBuilder.create();

				// mostrar el di‡logo.
				alertDialog.show();

			}

		});

	}

}