package br.com.aartedeprogramar.problemas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParentesesValidosTest {

    @ParameterizedTest(name = "[{index}] \"{0}\" deve ser válido")
    @MethodSource("entradasValidas")
    @DisplayName("Deve retornar true para sequências válidas")
    void deveRetornarTrueParaSequenciasValidas(String texto) {
        assertTrue(ParentesesValidos.saoValidos(texto));
    }

    @ParameterizedTest(name = "[{index}] \"{0}\" deve ser inválido")
    @MethodSource("entradasInvalidas")
    @DisplayName("Deve retornar false para sequências inválidas")
    void deveRetornarFalseParaSequenciasInvalidas(String texto) {
        assertFalse(ParentesesValidos.saoValidos(texto));
    }

    private static Stream<String> entradasValidas() {
        return Stream.of(
                "",          // string vazia é válida (nada para invalidar)
                "()",        // caso básico
                "()[]{}",    // múltiplos pares independentes
                "{[]}",      // aninhado correto
                "([])",      // aninhado correto
                "({[]})",    // aninhado mais profundo
                "((()))",    // repetição/aninhamento do mesmo tipo
                "[{()}([])]" // mistura e profundidade
        );
    }

    private static Stream<String> entradasInvalidas() {
        return Stream.of(
                "(",     // sobra abertura
                ")",     // fecha sem abrir
                "(]",    // fecha tipo errado
                "([)]",  // ordem errada (clássico de entrevista)
                "{[}",   // fecha incorreto e sobra
                "(()",   // sobra abertura em aninhamento
                "())",   // fecha a mais
                "}{",    // começa fechando (e fora de ordem)
                "[]]",   // fecha a mais
                "([{}]))"// fecha a mais no final
        );
    }
}
