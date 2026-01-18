package br.com.aartedeprogramar.problemas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockTest {

    @Test
    void deveCalcularMaiorLucroCasoBasico() {
        int[] precos = {9, 2, 4, 1, 7, 3};
        // Comprar a 1 e vender a 7 => lucro 6
        assertEquals(6, BestTimeToBuyAndSellStock.maiorLucro(precos));
    }

    @Test
    void deveRetornarZeroQuandoNaoHaLucroPossivel() {
        int[] precos = {8, 6, 5, 3, 2};
        assertEquals(0, BestTimeToBuyAndSellStock.maiorLucro(precos));
    }

    @Test
    void deveCalcularLucroComSequenciaCrescente() {
        int[] precos = {1, 2, 3, 4, 5};
        // Comprar a 1 e vender a 5 => lucro 4
        assertEquals(4, BestTimeToBuyAndSellStock.maiorLucro(precos));
    }

    @Test
    void deveRetornarZeroComUmUnicoDia() {
        int[] precos = {10};
        assertEquals(0, BestTimeToBuyAndSellStock.maiorLucro(precos));
    }

    @Test
    void deveCalcularCorretamenteComPrecosRepetidos() {
        int[] precos = {3, 3, 3, 3};
        assertEquals(0, BestTimeToBuyAndSellStock.maiorLucro(precos));
    }

    @Test
    void deveCalcularQuandoMenorPrecoApareceDepois() {
        int[] precos = {5, 4, 3, 2, 10};
        // Comprar a 2 e vender a 10 => lucro 8
        assertEquals(8, BestTimeToBuyAndSellStock.maiorLucro(precos));
    }

    @Test
    void deveRetornarZeroQuandoArrayEhNulo() {
        assertEquals(0, BestTimeToBuyAndSellStock.maiorLucro(null));
    }

    @Test
    void deveLancarExcecaoQuandoArrayEstaVazio() {
        assertEquals(0, BestTimeToBuyAndSellStock.maiorLucro(new int[]{}));
    }
}
