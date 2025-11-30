package br.com.aartedeprogramar.problemas;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {
    @Test
    void deveEncontrarParNoMeioDoArray() {
        int[] numeros = {3, 4, 5, 2, 8};
        int alvo = 10;

        int[] resultado = TwoSum.somaDoisNumerosHashMap(numeros, alvo);

        int[] esperado = {3, 4}; // índices esperados

        Arrays.sort(resultado);
        Arrays.sort(esperado);

        assertArrayEquals(esperado, resultado);
    }

    @Test
    void deveEncontrarParComNumerosRepetidos() {
        int[] numeros = {3, 3, 4};
        int alvo = 6;

        int[] resultado = TwoSum.somaDoisNumerosHashMap(numeros, alvo);

        int[] esperado = {0, 1};

        Arrays.sort(resultado);
        Arrays.sort(esperado);

        assertArrayEquals(esperado, resultado);
    }

    @Test
    void deveEncontrarParQuandoSolucaoEnvolvePrimeiroEUltimoIndice() {
        int[] numeros = {5, 1, 2, 3, 5};
        int alvo = 10;

        int[] resultado = TwoSum.somaDoisNumerosHashMap(numeros, alvo);

        int[] esperado = {0, 4}; // índices do 5 e 5

        Arrays.sort(resultado);
        Arrays.sort(esperado);

        assertArrayEquals(esperado, resultado);
    }

    @Test
    void deveFuncionarComNumerosNegativos() {
        int[] numeros = {-3, 1, 4, -1, 2};
        int alvo = 1;

        // -3 (0) + 4 (2) = 1
        int[] resultado = TwoSum.somaDoisNumerosHashMap(numeros, alvo);

        int[] esperado = {0, 2};

        Arrays.sort(resultado);
        Arrays.sort(esperado);

        assertArrayEquals(esperado, resultado);
    }

    @Test
    void deveRetornarArrayVazioQuandoNumerosForNulo() {
        int[] resultado = TwoSum.somaDoisNumerosHashMap(null, 10);

        assertNotNull(resultado);
        assertEquals(0, resultado.length);
    }

    @Test
    void deveRetornarArrayVazioQuandoNaoHaElementosSuficientes() {
        int[] numeros = {5};
        int alvo = 5;

        int[] resultado = TwoSum.somaDoisNumerosHashMap(numeros, alvo);

        assertNotNull(resultado);
        assertEquals(0, resultado.length);
    }

    @Test
    void deveRetornarArrayVazioQuandoNaoExisteSolucao() {
        int[] numeros = {1, 2, 3, 4};
        int alvo = 100;

        int[] resultado = TwoSum.somaDoisNumerosHashMap(numeros, alvo);

        assertNotNull(resultado);
        assertEquals(0, resultado.length);
    }
}