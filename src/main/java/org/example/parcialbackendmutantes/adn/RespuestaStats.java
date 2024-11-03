package org.example.parcialbackendmutantes.adn;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RespuestaStats {

    @JsonProperty("Mutantes: ")
    private long countMutantDna;

    @JsonProperty("Humanos: ")
    private long countHumanDna;

    private double ratio;
}