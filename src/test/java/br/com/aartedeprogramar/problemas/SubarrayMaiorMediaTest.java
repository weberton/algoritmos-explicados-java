package br.com.aartedeprogramar.problemas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SubarrayMaiorMediaTest {

    private static final double DELTA = 1e-9;

    @Test
    @DisplayName("Deve retornar a maior média para janela fixa (caso básico)")
    void deveRetornarMaiorMediaCasoBasico() {
        int[] temperaturas = {18, 20, -5, 19, 25, 27, 26, 24};
        int k = 3;

        // Somatórias por janela (k=3):
        // 18+20-5=33 => 11.0
        // 20-5+19=34 => 11.3333333333
        // -5+19+25=39 => 13.0
        // 19+25+27=71 => 23.6666666667
        // 25+27+26=78 => 26.0  (máxima)
        // 27+26+24=77 => 25.6666666667
        double esperado = 26.0;

        double resultado = SubarrayMaiorMedia.maiorMedia(temperaturas, k);

        assertEquals(esperado, resultado, DELTA);
    }

    @Test
    @DisplayName("Deve funcionar com todos valores negativos")
    void deveFuncionarComTodosNegativos() {
        int[] temperaturas = {-10, -5, -7, -12};
        int k = 2;

        // janelas:
        // -10 + -5 = -15 => -7.5
        // -5 + -7 = -12 => -6.0 (máxima)
        // -7 + -12 = -19 => -9.5
        double esperado = -6.0;

        double resultado = SubarrayMaiorMedia.maiorMedia(temperaturas, k);

        assertEquals(esperado, resultado, DELTA);
    }

    @Test
    @DisplayName("k=1: maior média deve ser o maior elemento do array")
    void kIgualUm() {
        int[] temperaturas = {3, -2, 5, 1};
        int k = 1;

        double esperado = 5.0;

        double resultado = SubarrayMaiorMedia.maiorMedia(temperaturas, k);

        assertEquals(esperado, resultado, DELTA);
    }

    @Test
    @DisplayName("k=n: média deve ser a média do array inteiro")
    void kIgualTamanhoDoArray() {
        int[] temperaturas = {2, 4, 6, 8};
        int k = 4;

        double esperado = (2 + 4 + 6 + 8) / 4.0; // 5.0

        double resultado = SubarrayMaiorMedia.maiorMedia(temperaturas, k);

        assertEquals(esperado, resultado, DELTA);
    }

    @Test
    @DisplayName("Deve retornar médias decimais corretamente")
    void deveRetornarMediaDecimalCorretamente() {
        int[] temperaturas = {1, 2, 3, 4};
        int k = 3;

        // janelas:
        // 1+2+3=6 => 2.0
        // 2+3+4=9 => 3.0 (máxima)
        double esperado = 3.0;

        double resultado = SubarrayMaiorMedia.maiorMedia(temperaturas, k);

        assertEquals(esperado, resultado, DELTA);
    }

    @Test
    @DisplayName("Deve lidar com mistura de positivos e negativos (média pode ser fracionária)")
    void misturaPositivosENegativos() {
        int[] temperaturas = {5, -1, 2, -1, 3};
        int k = 2;

        // janelas:
        // 5 + -1 = 4 => 2.0
        // -1 + 2 = 1 => 0.5
        // 2 + -1 = 1 => 0.5
        // -1 + 3 = 2 => 1.0
        double esperado = 2.0;

        double resultado = SubarrayMaiorMedia.maiorMedia(temperaturas, k);

        assertEquals(esperado, resultado, DELTA);
    }

    // -----------------------
    // Casos de validação (recomendado)
    // -----------------------

    @Test
    @DisplayName("Deve lançar exceção se o array for null")
    void deveLancarExcecaoSeArrayNull() {
        assertThrows(IllegalArgumentException.class,
                () -> SubarrayMaiorMedia.maiorMedia(null, 3));
    }

    @Test
    @DisplayName("Deve lançar exceção se k <= 0")
    void deveLancarExcecaoSeKInvalido() {
        int[] temperaturas = {1, 2, 3};

        assertThrows(IllegalArgumentException.class,
                () -> SubarrayMaiorMedia.maiorMedia(temperaturas, 0));

        assertThrows(IllegalArgumentException.class,
                () -> SubarrayMaiorMedia.maiorMedia(temperaturas, -1));
    }

    @Test
    @DisplayName("Deve lançar exceção se k for maior que o tamanho do array")
    void deveLancarExcecaoSeKMaiorQueArray() {
        int[] temperaturas = {1, 2};

        assertThrows(IllegalArgumentException.class,
                () -> SubarrayMaiorMedia.maiorMedia(temperaturas, 3));
    }
}
