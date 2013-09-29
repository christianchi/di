package com.dam.di.holamundo;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class HolaMundoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Cargamos la interfaz de usuario definida en el fichero /res/layout/activity_hola_mundo.xml
        setContentView(R.layout.activity_hola_mundo);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hola_mundo, menu);
        return true;
    }
    
}
