package com.pay.tools_challange.service;

import com.pay.tools_challange.enums.StatusTransacao;
import com.pay.tools_challange.exception.TransacaoCanceladaException;
import com.pay.tools_challange.exception.TransacaoNaoEncontradaException;
import com.pay.tools_challange.model.Transacao;
import com.pay.tools_challange.repository.TransacaoRepository;
import com.pay.tools_challange.utils.IndentifyGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TransacaoService {

    private final TransacaoRepository repository;

    public TransacaoService(TransacaoRepository repository) {
        this.repository = repository;
    }

    public Transacao salvar(Transacao transacao) {
        return repository.save(transacao);
    }

    public Transacao autorizar(Transacao transacao) {
        transacao.getDescricao().setNsu(IndentifyGenerator.sequencialCodeGenerator());
        transacao.getDescricao().setCodigoAutorizacao(IndentifyGenerator.sequencialCodeGenerator());
        transacao.getDescricao().setStatus(StatusTransacao.AUTORIZADO);

        return transacao;
    }

    @Transactional
    public Transacao estornar(Transacao transacao) {
        validarTransacaoEstorno(transacao);
        transacao.getDescricao().setStatus(StatusTransacao.CANCELADO);

        return transacao;
    }

    public Transacao buscarPorId(UUID id) {
        return repository.findById(id).orElseThrow(() -> new TransacaoNaoEncontradaException("Transação não encontrada"));
    }

    private void validarTransacaoEstorno(Transacao transacao) {
        if (transacao.getDescricao().getStatus().equals(StatusTransacao.CANCELADO)) {
            throw new TransacaoCanceladaException("Essa transação já se encontra cancelada.", transacao.getId().toString());
        }
    }

    public List<Transacao> listar() {
        return repository.findAll();
    }

    public void deletar(UUID id) {
        repository.deleteById(id);
    }

}
