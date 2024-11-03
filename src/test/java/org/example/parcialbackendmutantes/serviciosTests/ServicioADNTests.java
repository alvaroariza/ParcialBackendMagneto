package org.example.parcialbackendmutantes.serviciosTests;

import org.example.parcialbackendmutantes.servicios.ServicioAdn;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ServicioADNTests {

    //||||||||||||||||||||||||||||||||||||||||||||||||| TESTs ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

    @Test
    public void testFilasT() {
        String[] dna = {
                "AACATA",
                "TGTACT",
                "GTTTTC",
                "CCGGGG",
                "GTCGTC",
                "ATAAAC"
        };
        assertTrue(ServicioAdn.isMutant(dna));
    }

    @Test
    public void testFilasF() {
        String[] dna = {
                "CTTATG",
                "TGCGGA",
                "GCTTCC",
                "CCACCG",
                "GATGAC",
                "AGCCAC"
        };
        assertFalse(ServicioAdn.isMutant(dna));
    }

    @Test
    public void testColumnasT() {
        String[] dna = {
                "AGCCTG",
                "CGAGGG",
                "GTTACG",
                "TTACTG",
                "CTAGTA",
                "CTTCAC"
        };
        assertTrue(ServicioAdn.isMutant(dna));
    }

    @Test
    public void testColumnasF() {
        String[] dna = {
                "TGAATG",
                "TATAGA",
                "GCCTCG",
                "GTAGTC",
                "TTACTA",
                "CGTCTC"
        };
        assertFalse(ServicioAdn.isMutant(dna));
    }

    @Test
    public void testDiagonalesT() {
        String[] dna = {
                "GGAATA",
                "CACATT",
                "GATTAC",
                "TGTAAG",
                "GTGGGC",
                "AGCGTA"
        };
        assertTrue(ServicioAdn.isMutant(dna));
    }

    @Test
    public void testDiagonalesF() {
        String[] dna = {
                "GGAATA",
                "CACATT",
                "GATCAC",
                "TGTAAG",
                "GAGGGC",
                "AGCGTA"
        };
        assertFalse(ServicioAdn.isMutant(dna));
    }

    @Test
    public void testMultipleT() {
        String[] dna = {
                "ATGTTG",
                "GTCTTA",
                "AGTTGG",
                "ACGTGT",
                "GGAGTC",
                "AGGCGA"
        };
        assertTrue(ServicioAdn.isMutant(dna));
    }

    @Test
    public void testMultipleF() {
        String[] dna = {
                "ATGTTG",
                "GCCTTA",
                "AGTTGG",
                "ACATGT",
                "GGACTC",
                "AGGCGA"
        };
        assertFalse(ServicioAdn.isMutant(dna));
    }
}

