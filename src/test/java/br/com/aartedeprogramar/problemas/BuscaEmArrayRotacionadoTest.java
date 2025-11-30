package br.com.aartedeprogramar.problemas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BuscaEmArrayRotacionadoTest {

    @Test
    void deveBuscarEmArrayNull() {
        assertEquals(-1, BuscaEmArrayRotacionado.buscar(null, 5));
    }

    @Test
    void deveBuscarEmArrayVazio() {
        int[] array = {};
        assertEquals(-1, BuscaEmArrayRotacionado.buscar(array, 5));
    }

    @Test
    void deveBuscarElementoExistenteNoPrimeiroSegmento() {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(2, BuscaEmArrayRotacionado.buscar(array, 6));
    }

    @Test
    void deveBuscarElementoExistenteNoSegundoSegmento() {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(5, BuscaEmArrayRotacionado.buscar(array, 1));
    }

    @Test
    void deveBuscarElementoNoPrimeiroIndice() {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(0, BuscaEmArrayRotacionado.buscar(array, 4));
    }

    @Test
    void deveBuscarElementoNoUltimoIndice() {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(6, BuscaEmArrayRotacionado.buscar(array, 2));
    }

    @Test
    void deveBuscarElementoInexistente() {
        int[] array = {4, 5, 6, 7, 0, 1, 2};
        assertEquals(-1, BuscaEmArrayRotacionado.buscar(array, 3));
    }

    @Test
    void deveBuscarEmArrayComApenasUmElemento() {
        int[] array = {1};
        assertEquals(0, BuscaEmArrayRotacionado.buscar(array, 1));
    }

    @Test
    void deveBuscarEmArrayComDoisElementos() {
        int[] array = {2, 1};
        assertEquals(1, BuscaEmArrayRotacionado.buscar(array, 1));
    }

    @Test
    public void deveExecutarEmTempoLogaritmico() {
        // Usando tamanhos menores que ainda mostram a diferença
        int tamanhoMenor = 10_000;    // 10 mil
        int tamanhoMaior = 1_000_000; // 1 milhão (100x maior)

        // Medir tempo para o array menor
        long tempoMenor = medirTempoBusca(tamanhoMenor);

        // Medir tempo para o array maior
        long tempoMaior = medirTempoBusca(tamanhoMaior);

        // Calcular a razão entre os tempos
        double razaoTempo = (double) tempoMaior / tempoMenor;

        System.out.println("Tempo array menor: " + tempoMenor + "ns");
        System.out.println("Tempo array maior: " + tempoMaior + "ns");
        System.out.println("Razão de tempo: " + razaoTempo);

        // Para um algoritmo O(n), a razão seria próxima de 100
        // Para um algoritmo O(log n), a razão seria muito menor
        assertTrue(razaoTempo < 10,
                "Razão de tempo (" + razaoTempo + ") muito alta para um algoritmo logarítmico");
    }

    private long medirTempoBusca(int tamanho) {
        int[] array = new int[tamanho];
        // Preencher apenas com números sequenciais
        for (int i = 0; i < tamanho; i++) {
            array[i] = i;
        }

        // Rotacionar o array (usando menos memória)
        int pontoRotacao = tamanho / 2;
        int temp;
        for (int i = 0; i < pontoRotacao; i++) {
            temp = array[i];
            array[i] = array[i + pontoRotacao];
            array[i + pontoRotacao] = temp;
        }

        // Aquecer a JVM com algumas execuções
        for (int i = 0; i < 100; i++) {
            BuscaEmArrayRotacionado.buscar(array, -1);
        }

        // Medir o tempo real
        long inicio = System.nanoTime();
        for (int i = 0; i < 100; i++) {  // Média de 100 execuções para mais precisão
            BuscaEmArrayRotacionado.buscar(array, -1);
        }
        return (System.nanoTime() - inicio) / 100; // Retorna tempo médio
    }


}
