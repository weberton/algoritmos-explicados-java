package br.com.aartedeprogramar.problemas;

public class OrganizadorPedidos {

    public static void organizarPedidos(int[] pedidos) {
        int esquerda = 0;
        int direita = 0;

        while (direita < pedidos.length) {
            if (pedidos[direita] != 0) {
                troca(esquerda, direita, pedidos);
                esquerda++;
            }
            direita++;
        }
    }

    private static void troca(int esquerda, int direita, int[] pedidos) {
        int aux = pedidos[esquerda];
        pedidos[esquerda] = pedidos[direita];
        pedidos[direita] = aux;
    }
}
