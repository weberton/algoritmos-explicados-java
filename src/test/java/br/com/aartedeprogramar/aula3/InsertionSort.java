package br.com.aartedeprogramar.aula3;

public class InsertionSort {
    public static void sort(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }

        for (int i = 1; i < array.length; i++) {
            int j = i - 1;
            int chave = array[i];

            while (j >= 0 && array[j] > chave) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = chave;
        }
    }
}
