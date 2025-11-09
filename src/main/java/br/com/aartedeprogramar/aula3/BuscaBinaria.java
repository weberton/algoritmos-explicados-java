package br.com.aartedeprogramar.aula3;

public class BuscaBinaria {


    public static int buscaBinariaRecursivo(int[] array, int alvo) {
        return buscaBinariaRecursivo(array, alvo, 0, array.length - 1);
    }

    private static int buscaBinariaRecursivo(int[] array, int alvo, int inicio, int fim) {
        if (inicio > fim) {
            return -1;
        }

        int metade = inicio + (fim - inicio) / 2;

        if (array[metade] == alvo) {
            return metade;
        }

        if (alvo > array[metade]) {
            return buscaBinariaRecursivo(array, alvo, metade + 1, fim);
        } else {
            return buscaBinariaRecursivo(array, alvo, inicio, metade - 1);
        }

    }


    /*
      T = O(log n)
      E = O(1)
     */
    public static int buscaBinaria(int[] array, int alvo) {
        int inicio = 0;
        int fim = array.length - 1;

        while (inicio <= fim) {
            int metade = inicio + (fim - inicio) / 2;

            if (array[metade] == alvo) {
                return metade;
            }

            if (alvo > array[metade]) {
                inicio = metade + 1;
            } else {
                fim = metade - 1;
            }
        }
        return -1;
    }
}
