package br.com.aartedeprogramar.aula3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class BuscaBinariaTest {
    @Test
    @DisplayName("Deve encontrar elemento em array ordenado")
    void deveEncontrarElemento() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(4, BuscaBinaria.buscaBinaria(array, 5));
    }

    @Test
    @DisplayName("Deve retornar -1 quando elemento não existe")
    void deveRetornarMenosUmQuandoElementoNaoExiste() {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        assertEquals(-1, BuscaBinaria.buscaBinaria(array, 11));
    }

    @Test
    @DisplayName("Deve encontrar elemento no início do array")
    void deveEncontrarElementoNoInicio() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(0, BuscaBinaria.buscaBinaria(array, 1));
    }

    @Test
    @DisplayName("Deve encontrar elemento no final do array")
    void deveEncontrarElementoNoFinal() {
        int[] array = {1, 2, 3, 4, 5};
        assertEquals(4, BuscaBinaria.buscaBinaria(array, 5));
    }

    @Test
    @DisplayName("Deve lidar com array vazio")
    void deveLidarComArrayVazio() {
        int[] array = {};
        assertEquals(-1, BuscaBinaria.buscaBinaria(array, 1));
    }

    @Test
    @DisplayName("Deve funcionar com array de um elemento")
    void deveFuncionarComArrayUnicoElemento() {
        int[] array = {1};
        assertEquals(0, BuscaBinaria.buscaBinaria(array, 1));
        assertEquals(-1, BuscaBinaria.buscaBinaria(array, 2));
    }

    @Test
    @DisplayName("Deve completar busca em array grande dentro do timeout")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void deveCompletarBuscaEmArrayGrandeComTimeout() {
        // Criar array com 1 milhão de elementos
        int[] arrayGrande = new int[1_000_000];
        for (int i = 0; i < arrayGrande.length; i++) {
            arrayGrande[i] = i;
        }

        assertEquals(999_999, BuscaBinaria.buscaBinaria(arrayGrande, 999_999)); // último elemento
        assertEquals(500_000, BuscaBinaria.buscaBinaria(arrayGrande, 500_000)); // elemento do meio
        assertEquals(0, BuscaBinaria.buscaBinaria(arrayGrande, 0));            // primeiro elemento
        assertEquals(-1, BuscaBinaria.buscaBinaria(arrayGrande, 1_000_001));   // elemento não existente
    }

    @Test
    @DisplayName("Deve manter performance logarítmica com arrays de diferentes tamanhos")
    void deveManterPerformanceLogaritmica() {
        // Testar com diferentes tamanhos de array
        int[] tamanhos = {100, 1_000, 10_000, 100_000, 1_000_000};
        long[] tempos = new long[tamanhos.length];

        for (int i = 0; i < tamanhos.length; i++) {
            int[] array = new int[tamanhos[i]];
            for (int j = 0; j < array.length; j++) {
                array[j] = j;
            }

            long inicio = System.nanoTime();
            BuscaBinaria.buscaBinaria(array, array.length - 1); // buscar último elemento
            long fim = System.nanoTime();
            tempos[i] = fim - inicio;
        }

        // Verificar se o aumento no tempo é aproximadamente logarítmico
        // Se dobrarmos o tamanho do array, o tempo não deve dobrar
        for (int i = 1; i < tempos.length; i++) {
            double razaoTamanhos = (double) tamanhos[i] / tamanhos[i - 1];
            double razaoTempos = (double) tempos[i] / tempos[i - 1];

            assertTrue(razaoTempos < razaoTamanhos,
                    String.format("O aumento no tempo (%f) não deveria ser maior que o aumento no tamanho (%f)",
                            razaoTempos, razaoTamanhos));
        }
    }

    //recursao
    @Test
    @DisplayName("Deve lidar com recursão profunda sem StackOverflow")
    void deveLidarComRecursaoProfunda() {
        // Criar um array grande o suficiente para gerar muitas chamadas recursivas
        int[] arrayGrande = new int[1 << 20]; // 2^20 = 1.048.576 elementos
        for (int i = 0; i < arrayGrande.length; i++) {
            arrayGrande[i] = i;
        }

        // Este teste verificará se a implementação recursiva pode lidar
        // com uma profundidade máxima de log2(1048576) ≈ 20 chamadas
        assertDoesNotThrow(() -> {
            assertEquals(1000000, BuscaBinaria.buscaBinariaRecursivo(arrayGrande, 1000000));
        });
    }

    @Test
    @DisplayName("Deve manter consistência em buscas sucessivas")
    void deveManterConsistenciaEmBuscasSucessivas() {
        int[] array = {1, 3, 5, 7, 9, 11, 13, 15};

        // Realizar múltiplas buscas para verificar se a recursão não afeta o estado
        assertEquals(0, BuscaBinaria.buscaBinariaRecursivo(array, 1));  // primeiro
        assertEquals(7, BuscaBinaria.buscaBinariaRecursivo(array, 15)); // último
        assertEquals(3, BuscaBinaria.buscaBinariaRecursivo(array, 7));  // meio
        assertEquals(0, BuscaBinaria.buscaBinariaRecursivo(array, 1));  // primeiro novamente
    }

    @Test
    @DisplayName("Deve lidar com array vazio")
    void deveLidarComArrayVazioEmBuscaBinariaRecursiva() {
        int[] array = {};
        assertEquals(-1, BuscaBinaria.buscaBinariaRecursivo(array, 1));
    }
}