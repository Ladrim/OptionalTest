package org.alfonso.optional.models;

public class Fabricante
{
    private String nombre;

    public Fabricante(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNombre() {return nombre;}

    public void setNombre(String nombre) {this.nombre = nombre;}

    @Override
    public String toString() {return nombre;}
}

