package org.alfonso.optional.repository;

import org.alfonso.optional.models.Pc;

import java.util.List;
import java.util.Optional;

public interface PcRepository
{
    Optional<Pc> filtrar(String nombre);
    List<Pc> findByCpu(String cpuName);
}
