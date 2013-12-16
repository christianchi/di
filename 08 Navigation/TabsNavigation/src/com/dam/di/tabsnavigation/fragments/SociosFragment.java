package com.dam.di.tabsnavigation.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dam.di.tabsnavigation.R;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class SociosFragment extends Fragment {

	public SociosFragment() {
		// Required empty public constructor
	}
	


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		
		// Rescatar el parámetro que se le pasa al Fragment
		//int idParametro = getArguments().getInt("id");
		
		View v =  inflater.inflate(R.layout.fragment_socios, container, false);
		
		TextView texto = (TextView) v.findViewById(R.id.textoParametro);
		texto.setText("Hola Mundo");
		
		return v;
	}

}
