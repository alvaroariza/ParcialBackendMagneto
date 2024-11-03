package org.example.parcialbackendmutantes.controladores;

import org.example.parcialbackendmutantes.adn.RespuestaStats;
import org.example.parcialbackendmutantes.servicios.ServicioStats;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class ControladorStats {

    private final ServicioStats servicioStats;
    public ControladorStats(ServicioStats servicioStats) {
        this.servicioStats = servicioStats;
    }
    @GetMapping
    public RespuestaStats getStats() {
        return servicioStats.getStats();
    }
}