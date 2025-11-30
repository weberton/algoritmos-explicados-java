package br.com.aartedeprogramar.aula3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SelectionSortTest {

    @Test
    @DisplayName("Deve ordenar um array desordenado")
    void deveOrdenarArrayDesordenado() {
        int[] array = {5, 4, 3, 1, 2};
        SelectionSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    @DisplayName("Deve manter um array já ordenado")
    void deveManterArrayOrdenado() {
        int[] array = {1, 2, 3, 4, 5};
        SelectionSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }

    @Test
    @DisplayName("Deve ordenar um array com elementos repetidos")
    void deveOrdenarArrayComElementosRepetidos() {
        int[] array = {4, 2, 4, 1, 2};
        SelectionSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 2, 4, 4}, array);
    }

    @Test
    @DisplayName("Deve lidar com array de tamanho 1")
    void deveLidarComArrayTamanhoUm() {
        int[] array = {1};
        SelectionSort.sort(array);
        assertArrayEquals(new int[]{1}, array);
    }

    @Test
    @DisplayName("Deve lidar com array vazio")
    void deveLidarComArrayVazio() {
        int[] array = {};
        SelectionSort.sort(array);
        assertArrayEquals(new int[]{}, array);
    }

    @Test
    @DisplayName("Deve ordenar array em ordem inversa")
    void deveOrdenarArrayInverso() {
        int[] array = {5, 4, 3, 2, 1};
        SelectionSort.sort(array);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, array);
    }
}