package dev.bolt.powerplant.repository;

import dev.bolt.powerplant.model.Usina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsinaRepository extends JpaRepository<Usina, Long> {

    @Query("SELECT u FROM Usina u ORDER BY u.mdaPotenciaOutorgadaKw DESC")
    List<Usina> findTop5ByPotencia();
}