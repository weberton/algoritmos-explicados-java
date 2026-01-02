package br.com.aartedeprogramar.problemas;

public class SubarrayMaiorMedia {
    public static double maiorMedia(int[] temperaturas, int k) {
        if (temperaturas == null || k <= 0 || k > temperaturas.length) {
            throw new IllegalArgumentException();
        }
        // Soma dos primeiros k elementos.
        // Isso representa a primeira janela fixa de tamanho k.
        double somaAtual = 0;

        for (int i = 0; i < k; i++) {
            somaAtual += temperaturas[i];
        }

        // Inicialmente, a maior soma encontrada é a soma da primeira janela.
        double maiorSoma = somaAtual;

        // A partir daqui, começamos a "deslizar" a janela pelo array.
        // Em cada passo:
        // - removemos o valor que está saindo da janela
        // - adicionamos o novo valor que está entrando
        for (int i = k; i < temperaturas.length; i++) {
            // Atualiza a soma da janela de forma incremental,
            // evitando recalcular todos os k elementos novamente.
            somaAtual = somaAtual - temperaturas[i - k] + temperaturas[i];

            // Atualiza a maior soma encontrada até agora.
            maiorSoma = Math.max(somaAtual, maiorSoma);
        }

        // Como k é fixo, comparar somas é equivalente a comparar médias.
        // Por isso, dividimos a maior soma por k apenas no final.
        return maiorSoma / k;
    }
}
