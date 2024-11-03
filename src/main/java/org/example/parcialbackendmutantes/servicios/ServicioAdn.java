package org.example.parcialbackendmutantes.servicios;

import org.example.parcialbackendmutantes.adn.adn;
import org.example.parcialbackendmutantes.repositorio.repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioAdn {

    private final repository repository;
    private static final int SEQUENCE_LENGTH = 4;

    @Autowired
    public ServicioAdn(repository repository) {
        this.repository = repository;
    }

    public static boolean isMutant(String[] dna) {
        int n = dna.length;
        int contador = 0;

        contador += Filas(dna, n);
        if (contador > 1) return true;

        contador += Columnas(dna, n);
        if (contador > 1) return true;

        contador += Diagonales(dna, n);
        return contador > 1;
    }

    public boolean inspeccionADN(String[] dna) {
        String secuencia = String.join("-", dna);

        boolean isMutant = isMutant(dna);
        adn adnEntity = adn.builder()
                .dna(secuencia)
                .isMutant(isMutant)
                .build();
        repository.save(adnEntity);

        return isMutant(dna);
    }

    private static int Filas(String[] dna, int n) {
        int contador = 0;

        for (int i = 0; i < n; i++) {
            int cuenta = 1;
            for (int j = 1; j < n; j++) {
                if (dna[i].charAt(j) == dna[i].charAt(j - 1)) {
                    cuenta++;
                    if (cuenta == SEQUENCE_LENGTH) {
                        contador++;
                        if (contador > 1) return contador;
                    }
                } else {
                    cuenta = 1;
                }
            }
        }
        return contador;
    }

    private static int Columnas(String[] dna, int n) {
        int contador = 0;

        for (int j = 0; j < n; j++) {
            int cuenta = 1;
            for (int i = 1; i < n; i++) {
                if (dna[i].charAt(j) == dna[i - 1].charAt(j)) {
                    cuenta++;
                    if (cuenta == SEQUENCE_LENGTH) {
                        contador++;
                        if (contador > 1) return contador;
                    }
                } else {
                    cuenta = 1;
                }
            }
        }
        return contador;
    }

    private static boolean Diagonal(String[] dna, int x, int y, int dx, int dy, int n) {
        char first = dna[x].charAt(y);
        for (int i = 1; i < SEQUENCE_LENGTH; i++) {
            if (x + i * dx >= n || y + i * dy >= n || y + i * dy < 0 || dna[x + i * dx].charAt(y + i * dy) != first) {
                return false;
            }
        }
        return true;
    }

    private static int Diagonales(String[] dna, int n) {
        int contador = 0;
        for (int i = 0; i <= n - SEQUENCE_LENGTH; i++) {
            for (int j = 0; j <= n - SEQUENCE_LENGTH; j++) {
                if (Diagonal(dna, i, j, 1, 1, n)) {
                    contador++;
                    if (contador > 1) return contador;
                }
            }
        }

        for (int i = 0; i <= n - SEQUENCE_LENGTH; i++) {
            for (int j = SEQUENCE_LENGTH - 1; j < n; j++) {
                if (Diagonal(dna, i, j, 1, -1, n)) {
                    contador++;
                    if (contador > 1) return contador;
                }
            }
        }
        return contador;
    }
}
