package org.alfonso.optional.repository;

import org.alfonso.optional.models.Fabricante;
import org.alfonso.optional.models.Pc;
import org.alfonso.optional.models.Procesador;

import java.util.ArrayList;
import java.util.List;

public class PcRepositoryInMemory
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
}
