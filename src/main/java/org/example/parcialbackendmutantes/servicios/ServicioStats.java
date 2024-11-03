package org.example.parcialbackendmutantes.servicios;

import org.example.parcialbackendmutantes.adn.RespuestaStats;
import org.example.parcialbackendmutantes.repositorio.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioStats {

    private final repository repository;

    @Autowired
    public ServicioStats(repository repository) {
        this.repository = repository;
    }

    public RespuestaStats getStats() {
        long contadorMutante = repository.countByIsMutant(true);
        long contadorHumano = repository.countByIsMutant(false);
        double ratio = contadorHumano == 0 ? 0 : (double) contadorMutante / contadorHumano;
        return new RespuestaStats(contadorMutante, contadorHumano, ratio);
    }
}