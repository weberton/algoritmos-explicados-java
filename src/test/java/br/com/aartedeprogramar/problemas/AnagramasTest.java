
package br.com.aartedeprogramar.problemas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnagramasTest {

    @Test
    @DisplayName("Deve retornar true quando as strings forem anagramas")
    void deveRetornarTrueQuandoStringsForemAnagramas() {
        // Arrange
        String palavra1 = "amor";
        String palavra2 = "roma";

        // Act
        boolean resultado = Anagramas.isAnagrama(palavra1, palavra2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar false quando as strings não forem anagramas")
    void deveRetornarFalseQuandoStringsNaoForemAnagramas() {
        // Arrange
        String palavra1 = "amor";
        String palavra2 = "casa";

        // Act
        boolean resultado = Anagramas.isAnagrama(palavra1, palavra2);

        // Assert
        assertFalse(resultado);
    }

    @Test
    @DisplayName("Deve retornar true para anagramas com letras maiúsculas e minúsculas")
    void deveRetornarTrueParaAnagramasComCaseSensitive() {
        // Arrange
        String palavra1 = "Amor";
        String palavra2 = "Roma";

        // Act
        boolean resultado = Anagramas.isAnagrama(palavra1, palavra2);

        // Assert
        assertTrue(resultado);
    }

    @Test
    @DisplayName("Deve retornar false quando uma string for vazia")
    void deveRetornarFalseQuandoUmaStringForVazia() {
        // Arrange
        String palavra1 = "amor";
        String palavra2 = "";

        // Act
        boolean resultado = Anagramas.isAnagrama(palavra1, palavra2);

        // Assert
        assertFalse(resultado);
    }

    @Test
    @DisplayName("Deve retornar false quando uma string for null")
    void deveRetornarFalseQuandoUmaStringForNull() {
        // Arrange
        String palavra1 = "amor";
        String palavra2 = null;

        // Act
        boolean resultado = Anagramas.isAnagrama(palavra1, palavra2);

        // Assert
        assertFalse(resultado);
    }

    @Test
    @DisplayName("Deve retornar true para anagramas com espaços")
    void deveRetornarTrueParaAnagramasComEspacos() {
        // Arrange
        String palavra1 = "amor eterno";
        String palavra2 = "amor e norte";

        // Act
        boolean resultado = Anagramas.isAnagrama(palavra1, palavra2);

        // Assert
        assertTrue(resultado);
    }
}