package org.example.parcialbackendmutantes.controladores;

import org.example.parcialbackendmutantes.adn.PeticionAdn;
import org.example.parcialbackendmutantes.adn.RespuestaAdn;
import org.example.parcialbackendmutantes.servicios.ServicioAdn;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mutant")
public class ControladorAdn {

    private final ServicioAdn servicioAdn;
    public ControladorAdn(ServicioAdn servicioAdn) {
        this.servicioAdn = servicioAdn;
    }

    @PostMapping
    public ResponseEntity<RespuestaAdn> checkMutant(@RequestBody PeticionAdn peticionAdn) {
        boolean isMutant = servicioAdn.inspeccionADN(peticionAdn.getDna());
        RespuestaAdn respuestaAdn = new RespuestaAdn(isMutant);
        if (isMutant) {
            return ResponseEntity.ok(respuestaAdn);
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(respuestaAdn);
        }
    }
}
