package br.com.aartedeprogramar.aula2;

import java.util.Arrays;

public class AnaliseBigOPratica {

    public static int pegarPrimeiro(int[] numeros) {
        return numeros[0];
    }

    public static long somarTodos(int[] numeros) {
        long soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }
        return soma;
    }

    public static long somarTodosOsPares(int[] numeros) {
        long soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length; j++) {
                soma += numeros[i] + numeros[j];
            }
        }
        return soma;
    }

    // Mede o tempo das três funções
    public static void medirTempo(int n) {
        System.out.println("Executando métodos com n = " + n);
        int[] numeros = new int[n];
        Arrays.fill(numeros, 1);

        long inicio = System.nanoTime();
        long primeiroElemento = pegarPrimeiro(numeros);
        long tempoConstante = System.nanoTime() - inicio;
        //System.out.println("Primeiro elementos: " + primeiroElemento);


        inicio = System.nanoTime();
        long somaTodos = somarTodos(numeros);
        long tempoLinear = System.nanoTime() - inicio;
        //System.out.println("SomaTodos: " + primeiroElemento);


        inicio = System.nanoTime();
        long somaPares = somarTodosOsPares(numeros);
        long tempoQuadratico = System.nanoTime() - inicio;
        //System.out.println("Soma de todos os pares: " + somaPares);

        System.out.printf("N=%d → O(1): %.3f ms | O(n): %.3f ms | O(n²): %.3f ms%n",
                n, tempoConstante / 1e6, tempoLinear / 1e6, tempoQuadratico / 1e6);
    }
}
