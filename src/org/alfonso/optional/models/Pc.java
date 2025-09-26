package org.alfonso.optional.models;

import java.util.Optional;

public class Pc
{
    private String nombre;
    private String modelo;
    private Procesador procesador;

    public Pc(String nombre, String modelo , Procesador procesador)
    {
        this.nombre = nombre;
        this.modelo = modelo;
        this.procesador = procesador;

    }

    public String getNombre() {return nombre;}
    public String getModelo() {return modelo;}
    public Optional<Procesador> getProcesador()
    {return Optional.ofNullable(procesador);}

    public void setNombre(String nombre) {this.nombre = nombre;}
    public void setModelo(String modelo) {this.modelo = modelo;}
    public void setProcesador(Procesador procesador) {this.procesador = procesador;}

    @Override
    public String toString() {
        return nombre + ", " + modelo;
    }
}
