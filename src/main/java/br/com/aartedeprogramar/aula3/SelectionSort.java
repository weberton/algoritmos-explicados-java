package br.com.aartedeprogramar.aula3;

public class SelectionSort {
    /*

                         j
        [2, 3, 4, 5, 8]
                  I
        menor = 5
     */
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int indiceMenor = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[indiceMenor]) {
                    indiceMenor = j;
                }
            }

            if ( i != indiceMenor) {
                int aux = array[i]; //8
                array[i] = array[indiceMenor];
                array[indiceMenor] = aux;
            }
        }
    }

}
