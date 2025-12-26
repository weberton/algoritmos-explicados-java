package br.com.aartedeprogramar.problemas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class organizarPedidosTest {

    @Test
    void deveOrganizarPedidosComZerosIntercalados() {
        int[] input = {0, 5, 0, 8, 12};
        int[] esperado = {5, 8, 12, 0, 0};

        OrganizadorPedidos.organizarPedidos(input);

        assertArrayEquals(esperado, input);
    }

    @Test
    void deveManterArrayQuandoNaoHaZeros() {
        int[] input = {1, 2, 3};
        int[] esperado = {1, 2, 3};

        OrganizadorPedidos.organizarPedidos(input);

        assertArrayEquals(esperado, input);
    }

    @Test
    void deveManterArrayQuandoTodosSaoZeros() {
        int[] input = {0, 0, 0};
        int[] esperado = {0, 0, 0};

        OrganizadorPedidos.organizarPedidos(input);

        assertArrayEquals(esperado, input);
    }

    @Test
    void deveOrganizarQuandoZerosEstaoNoInicio() {
        int[] input = {0, 0, 3, 4};
        int[] esperado = {3, 4, 0, 0};

        OrganizadorPedidos.organizarPedidos(input);

        assertArrayEquals(esperado, input);
    }


    @Test
    void deveOrganizarQuandoZerosEstaoNoFim() {
        int[] input = {1, 2, 0, 0};
        int[] esperado = {1, 2, 0, 0};

        OrganizadorPedidos.organizarPedidos(input);

        assertArrayEquals(esperado, input);
    }

    @Test
    void deveOrganizarArrayComUmUnicoElementoZero() {
        int[] input = {0};
        int[] esperado = {0};

        OrganizadorPedidos.organizarPedidos(input);

        assertArrayEquals(esperado, input);
    }

    @Test
    void deveOrganizarArrayComUmUnicoElementoNaoZero() {
        int[] input = {7};
        int[] esperado = {7};

        OrganizadorPedidos.organizarPedidos(input);

        assertArrayEquals(esperado, input);
    }

    @Test
    void deveLidarComArrayVazio() {
        int[] input = {};
        int[] esperado = {};

        OrganizadorPedidos.organizarPedidos(input);

        assertArrayEquals(esperado, input);
    }

    @Test
    void devePreservarOrdemDosPedidosValidos() {
        int[] input = {0, 1, 0, 2, 0, 3, 4};
        int[] esperado = {1, 2, 3, 4, 0, 0, 0};

        OrganizadorPedidos.organizarPedidos(input);

        assertArrayEquals(esperado, input);
    }
}
