package com.pay.tools_challange.transacaoServiceTests;

import com.pay.tools_challange.enums.StatusTransacao;
import com.pay.tools_challange.exception.TransacaoCanceladaException;
import com.pay.tools_challange.model.Descricao;
import com.pay.tools_challange.model.Transacao;
import com.pay.tools_challange.repository.TransacaoRepository;
import com.pay.tools_challange.service.TransacaoServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class TransacaoServiceTests {

    private TransacaoServiceImpl transacaoService;

    private TransacaoRepository transacaoRepository;

    private Transacao transacao;
    private Descricao descricao;

    @BeforeEach
    void setup() {
        transacao = new Transacao();
        descricao = new Descricao();
        transacao.setId(UUID.randomUUID());
        transacao.setDescricao(descricao);
        transacaoService = new TransacaoServiceImpl(transacaoRepository);
    }

    @Test
    void testAutorizarTransacao() {
        transacao = transacaoService.autorizar(transacao);

        assertNotNull(transacao);
        assertNotNull(transacao.getDescricao().getNsu());
        assertNotNull(transacao.getDescricao().getCodigoAutorizacao());
        assertTrue(transacao.getDescricao().getNsu().matches("\\d{10}"));
        assertTrue(transacao.getDescricao().getCodigoAutorizacao().matches("\\d{10}"));
        assertEquals(StatusTransacao.AUTORIZADO, transacao.getDescricao().getStatus());
    }

    @Test
    void testEstornarTransacao() {
        transacao.getDescricao().setStatus(StatusTransacao.AUTORIZADO);
        transacao = transacaoService.estornar(transacao);

        assertNotNull(transacao);
        assertEquals(StatusTransacao.CANCELADO, transacao.getDescricao().getStatus());
    }

    @Test
    void testValidarTransacaoEstornoComStatusCancelado() {
        descricao.setStatus(StatusTransacao.CANCELADO);

        TransacaoCanceladaException exception = assertThrows(TransacaoCanceladaException.class, () -> {
            transacaoService.validarTransacaoEstorno(transacao);
        });

        String expectedMessage = "Essa transação já se encontra cancelada.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage), "A mensagem de erro não é a esperada");
    }
}
