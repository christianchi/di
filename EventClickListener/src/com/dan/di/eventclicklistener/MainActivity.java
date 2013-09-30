package com.dan.di.eventclicklistener;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	Button btn;
	EditText usuarioEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        usuarioEditText = (EditText) findViewById(R.id.usuarioEditText);
        
        btn = (Button) findViewById(R.id.buttonClick);
        btn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Log.i("Evento","Se ha hecho clic en el Bot�n");
				
				String texto = usuarioEditText.getText().toString();
			}
		});
    }
    
    
    
    
}
