package br.com.aartedeprogramar.problemas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {

    private final LongestSubstringWithoutRepeatingCharacters sut =
            new LongestSubstringWithoutRepeatingCharacters();

    @Test
    @DisplayName("String vazia => 0")
    void emptyString_returnsZero() {
        assertEquals(0, sut.lengthOfLongestSubstring(""));
    }

    @Test
    @DisplayName("Um único caractere => 1")
    void singleCharacter_returnsOne() {
        assertEquals(1, sut.lengthOfLongestSubstring("a"));
    }

    @Test
    @DisplayName("Todos caracteres iguais => 1")
    void allSameCharacters_returnsOne() {
        assertEquals(1, sut.lengthOfLongestSubstring("bbbbbb"));
    }

    @Test
    @DisplayName("Exemplo clássico: abcabcbb => 3 (abc)")
    void abcabcbb_returnsThree() {
        assertEquals(3, sut.lengthOfLongestSubstring("abcabcbb"));
    }

    @Test
    @DisplayName("Exemplo clássico: pwwkew => 3 (wke)")
    void pwwkew_returnsThree() {
        assertEquals(3, sut.lengthOfLongestSubstring("pwwkew"));
    }

    @Test
    @DisplayName("Exemplo clássico: dvdf => 3 (vdf)")
    void dvdf_returnsThree() {
        assertEquals(3, sut.lengthOfLongestSubstring("dvdf"));
    }

    @Test
    @DisplayName("Caso que testa 'esquerda não volta': abba => 2 (ab/ba)")
    void abba_leftPointerMustNotMoveBackward_returnsTwo() {
        assertEquals(2, sut.lengthOfLongestSubstring("abba"));
    }

    @Test
    @DisplayName("Repetição fora da janela atual não deve afetar a esquerda: tmmzuxt => 5 (mzuxt)")
    void repetitionOutsideWindow_doesNotMoveLeftBackward_returnsFive() {
        assertEquals(5, sut.lengthOfLongestSubstring("tmmzuxt"));
    }

    @Test
    @DisplayName("Com espaços: 'a b c a' => 3 ('a b' etc.)")
    void spacesAreCharacters_returnsCorrectLength() {
        assertEquals(3, sut.lengthOfLongestSubstring("a b c a"));
    }

    @Test
    @DisplayName("Case-sensitive: 'Aa' => 2 (A != a)")
    void caseSensitive_returnsTwo() {
        assertEquals(2, sut.lengthOfLongestSubstring("Aa"));
    }

    @Test
    @DisplayName("Caracteres especiais contam: 'a!a' => 2 ('a!')")
    void specialCharacters_countAsCharacters() {
        assertEquals(2, sut.lengthOfLongestSubstring("a!a"));
    }

    @Test
    @DisplayName("Unicode básico: 'áéíóú' => 5")
    void unicodeAccents_returnsFive() {
        assertEquals(5, sut.lengthOfLongestSubstring("áéíóú"));
    }
}
