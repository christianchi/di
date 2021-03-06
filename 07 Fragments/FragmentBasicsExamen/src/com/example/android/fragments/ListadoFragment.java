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
    // Declaraci�n de la interfaz
	OnListadoSelectedListener mCallback;

    // Declaramos una interfaz que deber� ser implementada por el Activity que
    // contiene a este Fragment para que puedan comunicarse datos. En este
    // caso, el Art�culo de noticia seleccioado por el usuario.
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
        // en la pantalla principal est� presente el detalle_fragment, establecemos
        // el ListView con el modo de selecci�n simple (CHOICE_MODE_SINGLE),
        // as� se pondr� en color el elemento que se seleccione.
        if (getFragmentManager().findFragmentById(R.id.detalle_fragment) != null) {
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // Con estas l�neas de c�digo nos aseguramos que el MainActivity
        // que contiene a este Fragment, implemente la interfaz
        // OnHeadlineSelectedListener. Si no es as�, lanzamos una excepci�n.
        try {
            mCallback = (OnListadoSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        // Cuando hagamos clic en un elemento de la lista, invocamos al m�todo
    	// onArticleSelected implementado en el MainActivity.
        mCallback.onArticleSelected(position);
        
        // Indicamos al ListView que el elemento que ocupa la posici�n "position"
        // ha sido seleccionado.
        getListView().setItemChecked(position, true);
    }
}