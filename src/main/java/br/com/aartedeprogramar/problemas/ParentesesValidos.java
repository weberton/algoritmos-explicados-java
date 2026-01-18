package br.com.aartedeprogramar.problemas;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Set;

public class ParentesesValidos {

    public static boolean saoValidos(String texto) {
        // Conjunto com os caracteres de abertura
        Set<Character> caracteresAbertura = Set.of('(', '[', '{');

        // Mapeia cada caractere de fechamento para o seu correspondente de abertura
        Map<Character, Character> simbolos = Map.of(
                ')', '(',
                ']', '[',
                '}', '{'
        );

        // Pilha usada para armazenar os caracteres de abertura
        Deque<Character> pilha = new ArrayDeque<>();

        // Percorremos a string caractere por caractere
        for (int i = 0; i < texto.length(); i++) {
            char charAtual = texto.charAt(i);

            // Se for um caractere de abertura, empilhamos
            if (caracteresAbertura.contains(charAtual)) {
                pilha.push(charAtual);
            } else {
                // Se for fechamento e a pilha estiver vazia, é inválido
                if (pilha.isEmpty()) {
                    return false;
                }

                // Verificamos qual caractere de abertura é esperado
                Character aberturaEsperada = simbolos.get(charAtual);

                // Se não existir mapeamento ou o topo não corresponder, é inválido
                if (aberturaEsperada == null || pilha.peek() != aberturaEsperada) {
                    return false;
                }

                // Se corresponder, removemos o topo da pilha
                pilha.pop();
            }
        }

        // Ao final, a pilha deve estar vazia para a sequência ser válida
        return pilha.isEmpty();
    }
}
