package com.pay.tools_challange.service;

import com.pay.tools_challange.model.Transacao;

import java.util.List;
import java.util.UUID;

public interface TransacaoService {
    Transacao salvar(Transacao transacao);
    Transacao autorizar(Transacao transacao);
    Transacao estornar(Transacao transacao);
    Transacao buscarTransacao(UUID id);
    Transacao buscarEstorno(String id);
    List<Transacao> listar();
}
