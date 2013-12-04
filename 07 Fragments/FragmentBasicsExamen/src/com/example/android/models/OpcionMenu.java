package com.example.android.models;

import java.util.ArrayList;
import java.util.List;

import com.example.android.R;

public class OpcionMenu {
	private int icon, color;
	private String texto;

	public OpcionMenu(int icon, String texto, int color) {
		super();
		this.icon = icon;
		this.texto = texto;
		this.color = color;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public static List<OpcionMenu> MENU = new ArrayList<OpcionMenu>();
	
	static {
		MENU.add(new OpcionMenu(R.drawable.ic_regalo,"Regalos",R.color.color_uno));
		MENU.add(new OpcionMenu(R.drawable.ic_santa_claus,"Disfraces",R.color.color_dos));
		MENU.add(new OpcionMenu(R.drawable.ic_galleta,"Galletas",R.color.color_tres));
		MENU.add(new OpcionMenu(R.drawable.ic_bola_arbol,"Decoraci—n",R.color.color_cuatro));
		MENU.add(new OpcionMenu(R.drawable.ic_calcetin,"Accesorios",R.color.color_cinco));
		MENU.add(new OpcionMenu(R.drawable.ic_calcetin,"Juguetes",R.color.color_seis));
		MENU.add(new OpcionMenu(R.drawable.ic_calcetin,"Accesorios",R.color.color_siete));
	}

}
