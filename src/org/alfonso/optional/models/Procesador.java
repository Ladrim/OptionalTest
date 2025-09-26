package org.alfonso.optional.models;

import java.util.Optional;

public class Procesador
{
    private String nombre;
    private Fabricante fabricante;

    public Procesador(String nombre, Fabricante fabricante)
    {
        this.nombre = nombre;
        this.fabricante = fabricante;
    }

    public String getNombre() {return nombre;}

    public Optional<Fabricante> getFabricante()
    {return Optional.ofNullable(fabricante);}

    public void setNombre(String nombre) {this.nombre = nombre;}

    @Override
    public String toString() {return nombre;}
}
