package br.com.aartedeprogramar.problemas;

import java.text.Normalizer;

public class Palindromo {

    public static boolean isPalindromo(String s) {
        if (s == null) {
            return false;
        }

        s = Normalizer.normalize(s, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "");

        // Inicializa dois ponteiros: um no início e outro no fim da string
        int esquerda = 0;
        int direita = s.length() - 1;

        while (esquerda < direita) {
            // Avança o ponteiro da esquerda até encontrar um caractere alfanumérico
            while (esquerda < direita && !Character.isLetterOrDigit(s.charAt(esquerda))) {
                esquerda++;
            }

            // Retrocede o ponteiro da direita até encontrar um caractere alfanumérico
            while (esquerda < direita && !Character.isLetterOrDigit(s.charAt(direita))) {
                direita--;
            }

            // Compara os caracteres ignorando maiúsculas/minúsculas
            if (Character.toLowerCase(s.charAt(esquerda))
                    != Character.toLowerCase(s.charAt(direita))) {
                return false;
            }
            esquerda++;
            direita--;
        }

        // Se chegou até aqui, é um palíndromo
        return true;
    }
}
