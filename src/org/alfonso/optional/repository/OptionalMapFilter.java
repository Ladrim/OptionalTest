package org.alfonso.optional.repository;

import org.alfonso.optional.models.Fabricante;
import org.alfonso.optional.models.Procesador;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalMapFilter
{
    public static void main(String[] args)
    {
        PcRepository repositorio = new PcRepositoryInMemory();


        String nombre1 = repositorio.filtrar("Asus ROG")
                .map(it -> it.getNombre())
                .orElseThrow();


        String nombre2 = repositorio.filtrar("MacBook Pro")
                .map(it -> it.getNombre())
                .orElseThrow();


        List nombres = repositorio.findByCpu("I15").stream()
                .map(it -> it.getNombre())
                .collect(Collectors.toList());

        System.out.println(nombres);


        List<Optional<String>> test  = repositorio.findByCpu("I10-8888J").stream()
                .map(it -> it.getProcesador().map(proc -> proc.getNombre()))
                .collect(Collectors.toList());



        String pc = repositorio.filtrar("Asus ROG")
                .flatMap(it->it.getProcesador())
                .flatMap(it->it.getFabricante())
                .map(it->it.getNombre()).orElse("No se ha encontrado nada");



        String pc2 = repositorio.filtrar("MacBook Pro")
                .flatMap(it->it.getProcesador())
                .flatMap(it->it.getFabricante())
                .map(it->it.getNombre()).orElse("No se ha encontrado nada");


        Optional<Fabricante> fabricanteOpt = repositorio.filtrar("Asus ROG")
                .flatMap( it -> it.getProcesador())
                .flatMap( it -> it.getFabricante());

        Optional<Optional<Optional<Fabricante>>> fabricanteOptOptOpt = repositorio.filtrar("Asus ROG")
                .map( it -> it.getProcesador())
                .map( it -> it.map( cpu -> cpu.getFabricante() ));

        System.out.println(pc);

        System.out.println(pc2);
    }
}
