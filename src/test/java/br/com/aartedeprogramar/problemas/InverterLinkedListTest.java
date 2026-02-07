package br.com.aartedeprogramar.problemas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InverterLinkedListTest {

    @Test
    void deveRetornarNullQuandoListaVazia() {
        assertNull(InverterLinkedList.inverter(null));
    }

    @Test
    void deveManterMesmaListaQuandoHaApenasUmNo() {
        InverterLinkedList.No unico = lista(7);

        InverterLinkedList.No invertida = InverterLinkedList.inverter(unico);

        // Conteúdo
        assertListaIgual(invertida, 7);

        // Identidade (a cabeça continua sendo o mesmo nó)
        assertSame(unico, invertida);
        assertNull(invertida.proximo);
    }

    @Test
    void deveInverterListaComDoisNos() {
        InverterLinkedList.No head = lista(1, 10);

        InverterLinkedList.No invertida = InverterLinkedList.inverter(head);

        assertListaIgual(invertida, 10, 1);
        assertNull(ultimo(invertida).proximo);
    }

    @Test
    void deveInverterListaComMultiplosNos() {
        InverterLinkedList.No head = lista(1, 10, 20, 30, 40);

        InverterLinkedList.No invertida = InverterLinkedList.inverter(head);

        assertListaIgual(invertida, 40, 30, 20, 10, 1);
        assertNull(ultimo(invertida).proximo);
    }

    @Test
    void deveReutilizarOsMesmosNosSemCriarNovos() {
        // Cria nós manualmente para testar identidade
        InverterLinkedList.No n1 = no(1);
        InverterLinkedList.No n10 = no(10);
        InverterLinkedList.No n20 = no(20);
        InverterLinkedList.No n30 = no(30);

        n1.proximo = n10;
        n10.proximo = n20;
        n20.proximo = n30;

        InverterLinkedList.No invertida = InverterLinkedList.inverter(n1);

        // A nova cabeça deve ser o último nó original (n30)
        assertSame(n30, invertida);

        // E a cadeia deve ser a inversa, usando os mesmos objetos
        assertSame(n20, invertida.proximo);
        assertSame(n10, invertida.proximo.proximo);
        assertSame(n1, invertida.proximo.proximo.proximo);
        assertNull(invertida.proximo.proximo.proximo.proximo);

        assertListaIgual(invertida, 30, 20, 10, 1);
    }

    // ---------- Helpers de teste ----------

    private InverterLinkedList.No no(int value) {
        return new InverterLinkedList.No(value);
    }

    private InverterLinkedList.No lista(int... values) {
        if (values == null || values.length == 0) return null;

        InverterLinkedList.No head = no(values[0]);
        InverterLinkedList.No curr = head;

        for (int i = 1; i < values.length; i++) {
            curr.proximo = no(values[i]);
            curr = curr.proximo;
        }
        return head;
    }

    private void assertListaIgual(InverterLinkedList.No head, int... expected) {
        InverterLinkedList.No curr = head;
        int idx = 0;

        while (curr != null && idx < expected.length) {
            assertEquals(expected[idx], curr.valor, "Valor diferente no índice " + idx);
            curr = curr.proximo;
            idx++;
        }

        assertEquals(expected.length, idx, "Lista terminou antes do esperado");
        assertNull(curr, "Lista tem mais nós do que o esperado");
    }

    // helper extra
    private InverterLinkedList.No ultimo(InverterLinkedList.No head) {
        InverterLinkedList.No curr = head;
        if (curr == null) return null;
        while (curr.proximo != null) curr = curr.proximo;
        return curr;
    }


}
