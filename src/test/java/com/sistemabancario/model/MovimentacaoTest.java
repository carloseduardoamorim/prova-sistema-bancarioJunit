package com.sistemabancario.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Classe de teste base para implementação dos testes
 * unitários para a classe {@link Movimentacao}.
 * Os testes foram gerados pelo IDE apenas como modelo
 * (fiz apenas algumas melhorias de boas práticas 
 * como tirar visibilidade public e definir variáveis como final).
 * 
 * Assim, NENHUM DELES FUNCIONA E O CÓDIGO PRECISA SER ALTERADO
 * de acordo com as regras de negócio dos métodos da classe {@link Movimentacao}.
 * Ao iniciar a alteração de um teste aqui,
 * a primeira coisa a fazer é remover a chamada de fail(),
 * que indica que o teste é apenas um protótipo.
 * 
 * @author Manoel Campos da Silva Filho
 */
class MovimentacaoTest {
    @Test
    void testGetId() {
        final Movimentacao instance = new Movimentacao(new Conta());
        final long esperado = 1;
        instance.setId(esperado);
        final long obtido = instance.getId();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testR01SetTipoC(){
        final char esperado = 'C';
        final Movimentacao instance = new Movimentacao(new Conta());
        instance.setTipo(esperado);
        final char obtido = instance.getTipo();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testR01SetTipoD(){
        final char esperado = 'D';
        final Movimentacao instance = new Movimentacao(new Conta());
        instance.setTipo(esperado);
        final char obtido = instance.getTipo();
        assertEquals(esperado, obtido);
    }
    
    @Test
    void testR01SetTipoInvalido(){
        final char invalido = 'W';
        final Movimentacao instance = new Movimentacao(new Conta());
        assertThrows(IllegalArgumentException.class, () -> instance.setTipo(invalido));
        final char obtido = instance.getTipo();
        assertNotEquals(invalido, obtido);
    }
    
    @Test 
    void testR02SetValorPositivo(){
        final Movimentacao instance = new Movimentacao(new Conta());
        final double esperado = 100;
        instance.setValor(esperado);
        final double obtido = instance.getValor();
        assertEquals(esperado, obtido);
    }
    
    @Test 
    void testR02SetValorNegativo(){
        final Movimentacao instance = new Movimentacao(new Conta());
        final double invalido = -100;
        assertThrows(IllegalArgumentException.class, () -> instance.setValor(invalido));
        final double obtido = instance.getValor();
        assertNotEquals(invalido, obtido);
    }
    
    @Test
    void testR03SaldoTotalValido() {
        final double limite = 1500, esperado = 1500;
        final Conta instance = new Conta();
        final Movimentacao movimentacao = new Movimentacao(instance);
        movimentacao.setTipo('D');
        instance.setLimite(limite);
        movimentacao.setValor(esperado);
        final double obtido = instance.getSaldoTotal();
        assertEquals(esperado, obtido);

    }
    
    @Test 
    void testR03SaldoTotalInvalido(){
        final double limite = 1500, invalido = 2000;
        final Conta instance = new Conta();
        final Movimentacao movimentacao = new Movimentacao(instance);
        movimentacao.setTipo('D');
        instance.setLimite(limite);
        assertThrows(IllegalArgumentException.class, () -> movimentacao.setValor(invalido));
        final double obtido = instance.getSaldoTotal();
        assertNotEquals(invalido, obtido);
    }
    
    @Test
    void testR04Confirmado(){
        final Movimentacao instance = new Movimentacao(new Conta());
        instance.setConfirmada(true);
        final boolean obtido = instance.isConfirmada();
        assertTrue(obtido);
    }
    
    @Test
    void testR05AddMovimentação(){
        final Conta conta = new Conta();
        final Movimentacao movimentacao = new Movimentacao(conta);
        movimentacao.setId(1);
        final long esperado = 1;
        conta.addMovimentacao(movimentacao);
        final long obtido = movimentacao.getId();
        assertEquals(esperado, obtido);
    }
}
