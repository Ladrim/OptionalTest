package org.alfonso.optional;

import org.alfonso.optional.models.Pc;
import org.alfonso.optional.repository.PcRepository;
import org.alfonso.optional.repository.PcRepositoryInMemory;

import java.util.Optional;

public class OptionalTest3
{
    public static void main(String[] args)
    {
        PcRepository repTelef = new PcRepositoryInMemory();

        Optional<Pc> telefOptTest = repTelef.filtrar("Appless");
        telefOptTest.map(it -> it.getNombre() + it.getModelo());

        System.out.println(telefOptTest.orElseThrow());
        System.out.println(telefOptTest.orElseThrow(() -> new RuntimeException("No se ha encontrado")));

        String archivo = "documento.pdf";

        String extension = Optional.ofNullable(archivo)
                .filter(it -> it.contains("."))
                .map(it -> it.substring(archivo.lastIndexOf(".")+1))
                .orElseThrow(() -> new RuntimeException("No"));

        System.out.println(extension);
    }
}
