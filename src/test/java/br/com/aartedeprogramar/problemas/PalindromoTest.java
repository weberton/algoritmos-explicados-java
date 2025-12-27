package br.com.aartedeprogramar.problemas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PalindromoTest {

    @Test
    void testPalindromoSimples() {
        assertTrue(Palindromo.isPalindromo("ana"));
        assertTrue(Palindromo.isPalindromo("ovo"));
        assertTrue(Palindromo.isPalindromo("arara"));
        assertTrue(Palindromo.isPalindromo("osso"));
        assertTrue(Palindromo.isPalindromo("radar"));
    }

    @Test
    void testPalindromoComEspacos() {
        assertTrue(Palindromo.isPalindromo("a base do teto desaba"));
        assertTrue(Palindromo.isPalindromo("apos a sopa"));
        assertTrue(Palindromo.isPalindromo("luz azul"));
    }

    @Test
    void testPalindromoComPontuacao() {
        assertTrue(Palindromo.isPalindromo("Socorram-me, subi no ônibus em Marrocos!"));
        assertTrue(Palindromo.isPalindromo("A Rita, sobre vovô, verbos atira!"));
    }

    @Test
    void testPalindromoComMaiusculasEMinusculas() {
        assertTrue(Palindromo.isPalindromo("A sacada da casa"));
        assertTrue(Palindromo.isPalindromo("O lobo ama o bolo"));
        assertTrue(Palindromo.isPalindromo("A torre da derrota"));
    }

    @Test
    void testNaoPalindromo() {
        assertFalse(Palindromo.isPalindromo("programação"));
        assertFalse(Palindromo.isPalindromo("desenvolvedor"));
        assertFalse(Palindromo.isPalindromo("computador"));
    }

    @Test
    void testCasosEspeciais() {
        assertFalse(Palindromo.isPalindromo(null));
        assertTrue(Palindromo.isPalindromo(""));
        assertTrue(Palindromo.isPalindromo("a"));
    }

    @Test
    void testPalindromoComNumeros() {
        assertTrue(Palindromo.isPalindromo("12321"));
        assertTrue(Palindromo.isPalindromo("1a2b2a1"));
        assertFalse(Palindromo.isPalindromo("123"));
    }

    @Test
    void testFrasesComplexas() {
        assertTrue(Palindromo.isPalindromo("Anotaram a data da maratona"));
        assertTrue(Palindromo.isPalindromo("A diva em Argel alegra-me a vida"));
        assertTrue(Palindromo.isPalindromo("A mala nada na lama"));
    }
}