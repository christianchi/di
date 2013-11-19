package com.dam.di.contextualactionmode;

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {
	private String nombre;
	private int id;

	public Usuario(String nombre, int id) {
		super();
		this.nombre = nombre;
		this.id = id;
	}
	
	private Usuario(Parcel in) {
		nombre = in.readString();
		id = in.readInt();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int describeContents() {
		return 0;
	}

	public void writeToParcel(Parcel out, int flags) {
		out.writeString(nombre);
		out.writeInt(id);
	}

	public static final Parcelable.Creator<Usuario> CREATOR = new Parcelable.Creator<Usuario>() {
		public Usuario createFromParcel(Parcel in) {
			return new Usuario(in);
		}

		public Usuario[] newArray(int size) {
			return new Usuario[size];
		}
	};

}
