package br.com.aartedeprogramar.problemas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class KadaneAlgoritmoTest {

    @Test
    @DisplayName("Deve lançar exceção quando o array é null")
    void deveLancarExcecaoQuandoArrayNull() {
        assertThrows(IllegalArgumentException.class,
                () -> KadaneAlgoritmo.maiorSomaSubarray(null));
    }

    @Test
    @DisplayName("Deve lançar exceção quando o array é vazio")
    void deveLancarExcecaoQuandoArrayVazio() {
        assertThrows(IllegalArgumentException.class,
                () -> KadaneAlgoritmo.maiorSomaSubarray(new int[]{}));
    }

    @ParameterizedTest(name = "{index} => maior soma de {0} = {1}")
    @MethodSource("casosClassicos")
    @DisplayName("Casos clássicos do Kadane (misto, negativos, positivos, zeros)")
    void deveCalcularMaiorSomaSubarray(int[] numeros, int esperado) {
        int resultado = KadaneAlgoritmo.maiorSomaSubarray(numeros);
        assertEquals(esperado, resultado);
    }

    static Stream<Arguments> casosClassicos() {
        return Stream.of(
                // Exemplo clássico do LeetCode
                Arguments.of(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}, 6), // [4,-1,2,1]

                // Todos negativos: pega o "menos negativo"
                Arguments.of(new int[]{-8, -3, -6, -2, -5, -4}, -2),

                // Todos positivos: soma tudo
                Arguments.of(new int[]{1, 2, 3, 4}, 10),

                // Um único elemento
                Arguments.of(new int[]{7}, 7),
                Arguments.of(new int[]{-7}, -7),

                // Com zeros
                Arguments.of(new int[]{0, 0, 0}, 0),
                Arguments.of(new int[]{-1, 0, -2}, 0),

                // “Queda” grande no meio, força reinício
                Arguments.of(new int[]{5, 4, -100, 6, 7}, 13), // [6,7]

                // Melhor subarray no começo
                Arguments.of(new int[]{10, -1, -2, -3}, 10),

                // Melhor subarray no final
                Arguments.of(new int[]{-5, -1, 2, 3, 4}, 9) // [2,3,4]
        );
    }

    @Test
    @DisplayName("Não deve estourar com valores grandes em int dentro do limite")
    void deveFuncionarComValoresGrandesSemOverflow() {
        int[] numeros = {1_000_000_000, -1, 1_000_000_000};
        // 1_000_000_000 + (-1) + 1_000_000_000 = 1_999_999_999 (cabe em int)
        assertEquals(1_999_999_999, KadaneAlgoritmo.maiorSomaSubarray(numeros));
    }
}
