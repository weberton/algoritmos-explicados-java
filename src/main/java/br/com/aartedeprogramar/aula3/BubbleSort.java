package br.com.aartedeprogramar.aula3;

public class BubbleSort {
    public static void bubbleSort(int[] array) {
        boolean estaOrdenado = false;
        int n = array.length - 1;

        while (!estaOrdenado) {
            estaOrdenado = true;
            for (int i = 0; i < n; i++) {
                if (array[i] > array[i + 1]) {
                    estaOrdenado = false;
                    int aux = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = aux;
                }
            }
            n--;
        }
    }
}
