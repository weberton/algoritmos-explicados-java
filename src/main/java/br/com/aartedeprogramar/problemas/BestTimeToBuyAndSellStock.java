package br.com.aartedeprogramar.problemas;

public class BestTimeToBuyAndSellStock {

    /**
     * Calcula o maior lucro possível na compra e venda de ações.
     * O lucro é determinado pela diferença entre o preço de compra (menor) e o preço de venda (maior)
     * que ocorre em um dia posterior.
     *
     * @param precos Array contendo os preços diários das ações
     * @return O maior lucro possível. Retorna 0 se não houver lucro ou se o array for vazio/nulo
     */
    public static int maiorLucro(int[] precos) {
        // Validação inicial do array
        if (precos == null || precos.length == 0) {
            return 0;
        }

        // Inicializa com o primeiro preço do array
        int menorPreco = precos[0];
        int maiorLucro = 0;

        // Analisa cada preço do array
        for (int i = 0; i < precos.length; i++) {
            int precoAtual = precos[i];

            if (precoAtual < menorPreco) {
                // Atualiza o menor preço encontrado
                menorPreco = precoAtual;
            } else {
                // Calcula o lucro possível vendendo no preço atual
                int lucroAtual = precoAtual - menorPreco;
                // Atualiza o maior lucro se necessário
                maiorLucro = Math.max(maiorLucro, lucroAtual);
            }
        }

        return maiorLucro;
    }
}
