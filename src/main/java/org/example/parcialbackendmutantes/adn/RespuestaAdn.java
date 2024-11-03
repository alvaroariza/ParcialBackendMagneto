package org.example.parcialbackendmutantes.adn;

import lombok.AllArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
public class RespuestaAdn {
    private boolean isMutant;
    public boolean isMutant() {
        return isMutant;
    }
}