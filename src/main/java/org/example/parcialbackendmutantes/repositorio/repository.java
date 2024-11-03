package org.example.parcialbackendmutantes.repositorio;

import org.example.parcialbackendmutantes.adn.adn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface repository extends JpaRepository<adn, Long> {
    Optional<adn> findByDna(String secuencia);

    long countByIsMutant(boolean isMutant);
}
