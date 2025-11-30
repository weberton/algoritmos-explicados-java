package br.com.aartedeprogramar.problemas;

public class BuscaEmArrayRotacionado {

    public static int buscar(int[] numeros, int alvo) {

        if (numeros == null) {
            return -1;
        }

        int esquerda = 0;
        int direita = numeros.length - 1;

        while (esquerda <= direita) {
            int metade = esquerda + (direita - esquerda) / 2;

            if (numeros[metade] == alvo) {
                return metade;
            }

            //identificar qual lado esta ordenado
            if (numeros[metade] >= numeros[esquerda]) {
                if (alvo >= numeros[esquerda] && alvo < numeros[metade]) {
                    direita = metade - 1;
                } else {
                    esquerda = metade + 1;
                }
            } else {
                if (alvo > numeros[metade] && alvo <= numeros[direita]) {
                    esquerda = esquerda + 1;
                } else {
                    direita = metade - 1;
                }
            }
        }

        return -1;
    }
}
