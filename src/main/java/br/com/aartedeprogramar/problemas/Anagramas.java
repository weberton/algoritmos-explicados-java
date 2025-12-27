package br.com.aartedeprogramar.problemas;

import java.util.HashMap;
import java.util.Map;

public class Anagramas {

    /*
      Complexidade:
        T=O(N)
        E=O(K) -> se o conjunto de caracteres for limitado, esse espaço pode ser visto como constante.
     */
    public static boolean isAnagrama(String s1, String s2) {
        // Validação inicial: verifica se as strings são nulas ou vazias
        if (s1 == null || s2 == null || s1.isEmpty() || s2.isEmpty()) {
            return false;
        }

        // Normalização das strings:
        // - Converte para minúsculas para ignorar diferenças de capitalização
        // - Remove todos os espaços em branco
        String s1Normalizada = s1.toLowerCase().replaceAll("\\s", "");
        String s2Normalizada = s2.toLowerCase().replaceAll("\\s", "");

        // Se os comprimentos são diferentes após normalização,
        // não podem ser anagramas
        if (s1Normalizada.length() != s2Normalizada.length()) {
            return false;
        }

        // Mapa para contar a frequência de cada caractere
        Map<Character, Integer> contador = new HashMap<>();

        // Única passagem: incrementa contador para s1 e decrementa para s2
        for (int i = 0; i < s1Normalizada.length(); i++) {
            char currentCharS1 = s1Normalizada.charAt(i);
            char currentCharS2 = s2Normalizada.charAt(i);

            contador.merge(currentCharS1, 1, Integer::sum);
            contador.merge(currentCharS2, -1, Integer::sum);
        }

        // Verifica se todas as contagens são zero
        // Se sim, significa que as strings têm exatamente os mesmos caracteres
        // na mesma quantidade
        return contador.values().stream().allMatch(count -> count == 0);
    }

}
