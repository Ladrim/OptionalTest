package org.alfonso.optional.repository;

import org.alfonso.optional.models.Fabricante;
import org.alfonso.optional.models.Pc;
import org.alfonso.optional.models.Procesador;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PcRepositoryInMemory implements PcRepository
{
    private List<Pc> dataSource;

    public PcRepositoryInMemory()
    {
        this.dataSource = new ArrayList<>();

        Fabricante fabricante = new Fabricante("Intel");
        Procesador proc = new Procesador("I9-9880H", fabricante);
        Pc asus = new Pc("Asus ROG", "Strix G512", proc);

        Fabricante fabricante2 = new Fabricante("Apple");
        Procesador proc2 = new Procesador("I15", fabricante2);
        Pc apple = new Pc("MacBook Pro", "MVVK2CI", proc2);

        Fabricante fabricante3 = new Fabricante("Intel");
        Procesador proc3 = new Procesador("I10-8888J", fabricante3);
        Pc msi = new Pc("Msi Gaming","ZJ200", proc3);

        dataSource.add(asus);
        dataSource.add(apple);
        dataSource.add(msi);
    }

    @Override
    public Optional<Pc> filtrar(String nombre)
    {
        return dataSource.stream()
                .filter(it -> it.getNombre().equalsIgnoreCase(nombre))
                .findFirst();
    }

    @Override
    public List<Pc> findByCpu(String cpuName)
    {
        return dataSource.stream()
                .filter( it -> it.getProcesador().map( cpu -> cpu.getNombre().equalsIgnoreCase(cpuName)).orElse(false)  )
                .toList();
    }
}
