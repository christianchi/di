package com.dam.di.fragmentospasoapaso.fragments;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dam.di.fragmentospasoapaso.R;

/**
 * A simple {@link android.support.v4.app.Fragment} subclass.
 * 
 */
public class ListadoFragment extends ListFragment {

	public ListadoFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		return inflater.inflate(R.layout.fragment_listado, container, false);
	}

}
