package br.com.aartedeprogramar.aula3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BubbleSortTest {

    @Test
    @DisplayName("Deve ordenar um array vazio")
    void ordenarArrayVazio() {
        int[] array = {};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    @DisplayName("Deve manter um array com único elemento inalterado")
    void ordenarArrayUnicoElemento() {
        int[] array = {1};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    @DisplayName("Deve manter a ordem de um array já ordenado")
    void ordenarArrayJaOrdenado() {
        int[] array = {1, 2, 3, 4, 5};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    @DisplayName("Deve ordenar um array desordenado")
    void ordenarArrayDesordenado() {
        int[] array = {5, 1, 4, 2, 3};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    @DisplayName("Deve ordenar um array com números repetidos")
    void ordenarArrayComNumerosRepetidos() {
        int[] array = {3, 5, 3, 2, 5};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{2, 3, 3, 5, 5}, array);
    }

    @Test
    @DisplayName("Deve ordenar um array com números negativos")
    void ordenarArrayComNumerosNegativos() {
        int[] array = {-3, 5, -7, 2, -1};
        BubbleSort.bubbleSort(array);
        assertArrayEquals(new int[]{-7, -3, -1, 2, 5}, array);
    }

    @Test
    @DisplayName("Deve garantir que o array esteja completamente ordenado")
    void verificarOrdenacaoCompleta() {
        int[] array = {5, 2, 8, 1, 9};
        BubbleSort.bubbleSort(array);

        for (int i = 0; i < array.length - 1; i++) {
            assertTrue(array[i] <= array[i + 1],
                    String.format("Array não está ordenado: elemento %d na posição %d é maior que %d",
                            array[i], i, array[i + 1]));
        }
    }
}