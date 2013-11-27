package com.dam.di.fragmentospasoapaso;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.Menu;

import com.dam.di.fragmentospasoapaso.fragments.ListadoFragment;

public class MainActivity extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		
		
		if(findViewById(R.id.contenedor)!=null) {
			// En este caso me encuentro en un m—vil (handset)
			// porque existe el FrameLayout cuyo id es contenedor
			
			ListFragment listadoFragment = new ListadoFragment();
			
			getSupportFragmentManager().beginTransaction()
            .add(R.id.contenedor, listadoFragment).commit();

		} 
		
		// e.o.c. Me encuentro en una tablet
			
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
