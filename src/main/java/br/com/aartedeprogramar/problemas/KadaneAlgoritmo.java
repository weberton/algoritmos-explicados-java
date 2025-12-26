package br.com.aartedeprogramar.problemas;

public class KadaneAlgoritmo {
    public static int maiorSomaSubarray(int[] numeros) {

        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("Array nao pode ser nulo ou vazio.");
        }

        int maiorSomaAteAqui = numeros[0];
        int maiorSomaGlobal = numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            int somaAtual = maiorSomaAteAqui + numeros[i];
            maiorSomaAteAqui = Math.max(numeros[i], somaAtual);
            maiorSomaGlobal = Math.max(maiorSomaGlobal, maiorSomaAteAqui);
        }

        return maiorSomaGlobal;
    }

}
