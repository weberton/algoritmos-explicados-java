package br.com.aartedeprogramar.problemas;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ContainsDuplicateTest {

    @Test
    void deveRetornarTrueQuandoExistirNumerosDuplicados() {
        // Arrange
        int[] nums = {1, 2, 3, 1};
        
        // Act
        boolean resultado = ContainsDuplicate.containsDuplicate(nums);
        
        // Assert
        assertTrue(resultado, "Deveria retornar true para array com números duplicados");
    }

    @Test
    void deveRetornarFalseQuandoNaoExistirNumerosDuplicados() {
        // Arrange
        int[] nums = {1, 2, 3, 4};
        
        // Act
        boolean resultado = ContainsDuplicate.containsDuplicate(nums);
        
        // Assert
        assertFalse(resultado, "Deveria retornar false para array sem números duplicados");
    }

    @Test
    void deveRetornarFalseParaArrayVazio() {
        // Arrange
        int[] nums = {};
        
        // Act
        boolean resultado = ContainsDuplicate.containsDuplicate(nums);
        
        // Assert
        assertFalse(resultado, "Deveria retornar false para array vazio");
    }

    @Test
    void deveRetornarFalseParaArrayComUmElemento() {
        // Arrange
        int[] nums = {1};
        
        // Act
        boolean resultado = ContainsDuplicate.containsDuplicate(nums);
        
        // Assert
        assertFalse(resultado, "Deveria retornar false para array com um único elemento");
    }

    @Test
    void deveRetornarTrueParaArrayComMultiplosDuplicados() {
        // Arrange
        int[] nums = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        
        // Act
        boolean resultado = ContainsDuplicate.containsDuplicate(nums);
        
        // Assert
        assertTrue(resultado, "Deveria retornar true para array com múltiplos números duplicados");
    }
}