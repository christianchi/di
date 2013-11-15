package com.dam.di.contextualactionmode;

public class Usuario {
	private String nombre;
	private boolean seleccionado;

	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
		this.seleccionado = false;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isSeleccionado() {
		return seleccionado;
	}

	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
	
	
	
	
}
