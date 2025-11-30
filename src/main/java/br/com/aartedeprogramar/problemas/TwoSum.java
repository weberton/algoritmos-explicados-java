package br.com.aartedeprogramar.problemas;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] somaDoisNumerosHashMap(int[] numeros, int alvo) {

        if (numeros == null) {
            return new int[]{};
        }

        Map<Integer, Integer> numerosVistos = new HashMap<>();

        for (int i = 0; i < numeros.length; i++) {
            int diferenca = alvo - numeros[i];

            if (numerosVistos.containsKey(diferenca)) {
                return new int[]{numerosVistos.get(diferenca), i};
            }

            numerosVistos.put(numeros[i], i);
        }

        return new int[]{};
    }
}
