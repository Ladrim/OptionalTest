package org.alfonso.optional;

import org.alfonso.optional.models.Fabricante;
import org.alfonso.optional.repository.PcRepository;
import org.alfonso.optional.repository.PcRepositoryInMemory;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OptionalTest4
{
    public static void main(String[] args)
    {
        PcRepository repository = new PcRepositoryInMemory();

        List names = repository.findByCpu("I15").stream()
                .map(it -> it.getNombre())
                .collect(Collectors.toList());

        String name1 = repository.filtrar("Asus ROG")
                .map(it -> it.getNombre())
                .orElseThrow();

        String name2 = repository.filtrar("MacBook Pro")
                .map(it -> it.getNombre())
                .orElseThrow();

        System.out.println(names);

        List<Optional<String>> test  = repository.findByCpu("I10-8888J").stream()
                .map(it -> it.getProcesador().map(proc -> proc.getNombre()))
                .collect(Collectors.toList());

        String pc1 = repository.filtrar("Msi Gaming")
                .flatMap(it->it.getProcesador())
                .flatMap(it->it.getFabricante())
                .map(it->it.getNombre()).orElse("Nothing found");

        String pc2 = repository.filtrar("Asus ROG")
                .flatMap(it->it.getProcesador())
                .flatMap(it->it.getFabricante())
                .map(it->it.getNombre()).orElse("Nothing found");

        String pc3 = repository.filtrar("MacBook Pro")
                .flatMap(it->it.getProcesador())
                .flatMap(it->it.getFabricante())
                .map(it->it.getNombre()).orElse("Nothing found");

        Optional<Optional<Optional<Fabricante>>> fabricanteOptOptOpt = repository.filtrar("Asus ROG")
                .map( it -> it.getProcesador())

                .map( it -> it.map( cpu -> cpu.getFabricante() ));
        Optional<Fabricante> fabricanteOpt = repository.filtrar("Asus ROG")
                .flatMap( it -> it.getProcesador())
                .flatMap( it -> it.getFabricante());

    }
}
