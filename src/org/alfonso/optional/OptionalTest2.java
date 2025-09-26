package org.alfonso.optional;

import org.alfonso.optional.models.Pc;
import org.alfonso.optional.repository.PcRepository;
import org.alfonso.optional.repository.PcRepositoryInMemory;

import java.util.Optional;

public class OptionalTest2
{
    public static void main(String[] args)
    {
        PcRepository repComp = new PcRepositoryInMemory();

        java.util.Optional<Pc> compOpt = repComp.filtrar("Asus ROG");
        compOpt.map(it -> it.getNombre() + it.getModelo());
        System.out.println(compOpt.orElseThrow(() -> new RuntimeException("No se encontró")));
    }
}
