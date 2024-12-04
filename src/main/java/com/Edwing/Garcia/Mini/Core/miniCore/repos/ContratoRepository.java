package com.Edwing.Garcia.Mini.Core.miniCore.repos;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Edwing.Garcia.Mini.Core.miniCore.model.Contrato;

@Repository
public interface ContratoRepository extends JpaRepository<Contrato, Long> {

    @Query("SELECT c.cliente.nombre, SUM(c.monto) FROM Contrato c WHERE c.fecha BETWEEN :fechaInicio AND :fechaFin GROUP BY c.cliente.nombre")
    List<Object[]> findSumaMontosPorCliente(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);
}