package br.com.aartedeprogramar.problemas;

public class InverterLinkedList {

    public static No inverter(No inicio) {
        No atual = inicio; // Nó que está sendo processado atualmente
        No anterior = null;  // Armazena o nó anterior na nova ordem
        No proximo = null; // Guarda temporariamente o próximo nó

        while (atual != null) {
            proximo = atual.proximo;
            atual.proximo = anterior;
            anterior = atual;
            atual = proximo;
        }

        return anterior;
    }

    // Definição do nó da lista encadeada
    public static class No {
        int valor;
        No proximo;

        public No(int valor) {
            this.valor = valor;
        }

        public No(int valor, No proximo) {
            this.valor = valor;
            this.proximo = proximo;
        }
    }
}

