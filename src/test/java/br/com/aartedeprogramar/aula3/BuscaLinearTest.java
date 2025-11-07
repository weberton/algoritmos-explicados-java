package br.com.aartedeprogramar.aula3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuscaLinearTest {

    @Test
    @DisplayName("Deve encontrar elemento no início do array")
    void deveEncontrarElementoNoInicio() {
        int[] numeros = {1, 2, 3, 4, 5};
        assertEquals(0, BuscaLinear.buscaLinear(numeros, 1));
    }

    @Test
    @DisplayName("Deve encontrar elemento no meio do array")
    void deveEncontrarElementoNoMeio() {
        int[] numeros = {1, 2, 3, 4, 5};
        assertEquals(2, BuscaLinear.buscaLinear(numeros, 3));
    }

    @Test
    @DisplayName("Deve encontrar elemento no final do array")
    void deveEncontrarElementoNoFinal() {
        int[] numeros = {1, 2, 3, 4, 5};
        assertEquals(4, BuscaLinear.buscaLinear(numeros, 5));
    }

    @Test
    @DisplayName("Deve retornar -1 quando elemento não existe no array")
    void deveRetornarMenosUmQuandoElementoNaoExiste() {
        int[] numeros = {1, 2, 3, 4, 5};
        assertEquals(-1, BuscaLinear.buscaLinear(numeros, 6));
    }

    @Test
    @DisplayName("Deve lidar com array vazio")
    void deveLidarComArrayVazio() {
        int[] numeros = {};
        assertEquals(-1, BuscaLinear.buscaLinear(numeros, 1));
    }

    @Test
    @DisplayName("Deve encontrar elemento em array com um único elemento")
    void deveEncontrarElementoEmArrayUnico() {
        int[] numeros = {1};
        assertEquals(0, BuscaLinear.buscaLinear(numeros, 1));
    }

    @Test
    @DisplayName("Deve encontrar elemento em array com elementos repetidos")
    void deveEncontrarPrimeiraOcorrenciaEmArrayComRepetidos() {
        int[] numeros = {1, 2, 2, 3, 2, 4};
        assertEquals(1, BuscaLinear.buscaLinear(numeros, 2));
    }
}
