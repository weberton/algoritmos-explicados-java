package br.com.aartedeprogramar.aula3;

public class BuscaLinear {
    public static int buscaLinear(int[] numeros, int alvo) {
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] == alvo) {
                return i;
            }
        }

        return -1;
    }
}
