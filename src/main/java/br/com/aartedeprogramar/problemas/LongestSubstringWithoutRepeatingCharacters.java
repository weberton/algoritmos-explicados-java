package br.com.aartedeprogramar.problemas;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Encontra o comprimento da maior substring sem caracteres repetidos
     *
     * @param s String de entrada
     * @return Comprimento da maior substring sem repetição
     */
    public static int lengthOfLongestSubstring(String s) {
        int maiorTamanho = 0;
        // Mapeia caracteres para suas últimas posições encontradas
        Map<Character, Integer> vistos = new HashMap<>();
        // Ponteiros para sliding window
        int esquerda = 0;
        int direita = 0;

        while (direita < s.length()) {
            char charAtual = s.charAt(direita);

            if (vistos.containsKey(charAtual)) {
                // Se encontrar caractere repetido, move ponteiro esquerdo
                esquerda = Math.max(esquerda, vistos.get(charAtual) + 1);
            }

            // Calcula e atualiza o maior tamanho encontrado
            int tamanhoSubstringAtual = direita - esquerda + 1;
            maiorTamanho = Math.max(maiorTamanho, tamanhoSubstringAtual);
            vistos.put(charAtual, direita);
            direita++;
        }

        return maiorTamanho;
    }
}
