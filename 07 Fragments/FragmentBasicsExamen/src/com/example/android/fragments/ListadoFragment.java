/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.fragments;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.R;
import com.example.android.adapters.MenuAdapter;
import com.example.android.models.OpcionMenu;

public class ListadoFragment extends ListFragment {
    // Declaración de la interfaz
	OnListadoSelectedListener mCallback;

    // Declaramos una interfaz que deberá ser implementada por el Activity que
    // contiene a este Fragment para que puedan comunicarse datos. En este
    // caso, el Artículo de noticia seleccioado por el usuario.
    public interface OnListadoSelectedListener {
        /** Llamado por ListadoFragment cuando se selecciona un 
         * usuario de la lista de Usuarios */
        public void onArticleSelected(int position);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ArrayAdapter<OpcionMenu> adapter = new MenuAdapter(getActivity(),OpcionMenu.MENU);
        setListAdapter(adapter);
   
    }

    @Override
    public void onStart() {
        super.onStart();

        //Cuando nos encontremos en una tablet, que es lo mismo que decir que 
        // en la pantalla principal esté presente el detalle_fragment, establecemos
        // el ListView con el modo de selección simple (CHOICE_MODE_SINGLE),
        // así se pondrá en color el elemento que se seleccione.
        if (getFragmentManager().findFragmentById(R.id.detalle_fragment) != null) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Con estas líneas de código nos aseguramos que el MainActivity
        // que contiene a este Fragment, implemente la interfaz
        // OnHeadlineSelectedListener. Si no es así, lanzamos una excepción.
        try {
            mCallback = (OnListadoSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Cuando hagamos clic en un elemento de la lista, invocamos al método
    	// onArticleSelected implementado en el MainActivity.
        mCallback.onArticleSelected(position);
        
        // Indicamos al ListView que el elemento que ocupa la posición "position"
        // ha sido seleccionado.
        getListView().setItemChecked(position, true);
    }
}