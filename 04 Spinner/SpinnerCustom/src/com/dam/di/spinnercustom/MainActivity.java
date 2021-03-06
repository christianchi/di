package com.dam.di.spinnercustom;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	// Hay que escribir los valores de ambos arrays en el mismo orden
	// Esto es, si en la primera posici�n de spinnerValues escribo "Enfadado"
	// es necesario que en la primera posici�n de total_images aparezca el icono de enfadado.
	String[] spinnerValues = { "Enfadado", "Gracioso" };
 
    int total_images[] = { R.drawable.icon_emoticono_enfadado, R.drawable.icon_emoticono_gracioso};
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
 
        // Rescato el elemento Spinner del layout main.xml, mediante su id R.id.spinner_show
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner_show);
        
        // El adaptador que aplico al Spinner, en este caso, es MyAdapter que es una clase
        // interna que he definido m�s abajo para personalizar las opciones del desplegable
        // Es necesario pasarle como par�metro a MyAdapter el layout personalizado que hemos
        // dise�ado: R.layout.custom_spinner y los valores que 
        mySpinner.setAdapter(new MyAdapter(this, R.layout.custom_spinner,
                spinnerValues));
    }
 
    public class MyAdapter extends ArrayAdapter<String> {
 
        public MyAdapter(Context ctx, int layoutSpinnerCustomId, String[] opcionesSpinner) {
            super(ctx, layoutSpinnerCustomId, opcionesSpinner);
        }
        
 
        @Override
        public View getDropDownView(int position, View cnvtView, ViewGroup prnt) {
            return getCustomView(position, cnvtView, prnt);
        }
        @Override
        public View getView(int pos, View cnvtView, ViewGroup prnt) {
            return getCustomView(pos, cnvtView, prnt);
        }
        
        // El m�todo que implementa mi Vista personalizada de las opciones del Spinner
        // Mi m�todo recibe la posici�n que ocupa el elemento en la lista de opciones
        // comenzando el primer elemento con el valor de posici�n = 0.
        //
        public View getCustomView(int position, View convertView,
                ViewGroup parent) {
        	
            LayoutInflater bombaDeAire = getLayoutInflater();
            // �De qu� inflo el layout padre? Pues, de mi layout personalizado: R.layout.custom_spinner
            View mySpinner = bombaDeAire.inflate(R.layout.custom_spinner, parent,false);
 
            // Rescato el Texto secundario y lo personalizo con la cadena texto correspondiente
            // a la posici�n en la que me encuentro del array spinnerValues
            TextView subSpinner = (TextView) mySpinner.findViewById(R.id.sub_text_seen);
            subSpinner.setText(spinnerValues[position]);
 
            ImageView left_icon = (ImageView) mySpinner.findViewById(R.id.left_pic);
            left_icon.setImageResource(total_images[position]);
 
            return mySpinner;
        }
    }
}
