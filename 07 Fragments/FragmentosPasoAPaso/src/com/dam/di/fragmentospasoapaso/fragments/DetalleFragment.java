package com.dam.di.fragmentospasoapaso.fragments;

import com.dam.di.fragmentospasoapaso.R;
import com.dam.di.fragmentospasoapaso.R.layout;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class DetalleFragment extends Fragment {

	public DetalleFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_detalle, container, false);
	}

}