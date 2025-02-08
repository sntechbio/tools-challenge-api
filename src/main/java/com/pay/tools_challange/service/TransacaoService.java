package com.pay.tools_challange.service;

import com.pay.tools_challange.enums.StatusTransacao;
import com.pay.tools_challange.exception.TransacaoCanceladaException;
import com.pay.tools_challange.exception.TransacaoNaoEncontradaException;
import com.pay.tools_challange.model.Transacao;
import com.pay.tools_challange.repository.TransacaoRepository;
import com.pay.tools_challange.utils.IdentifyGenerator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TransacaoService {

    private final TransacaoRepository repository;
    private final TransacaoRepository transacaoRepository;

    public TransacaoService(TransacaoRepository repository, TransacaoRepository transacaoRepository) {
        this.repository = repository;
        this.transacaoRepository = transacaoRepository;
    }

    public Transacao salvar(Transacao transacao) {
        return repository.save(transacao);
    }

    public Transacao autorizar(Transacao transacao) {
        transacao.getDescricao().setNsu(IdentifyGenerator.sequencialCodeGenerator());
        transacao.getDescricao().setCodigoAutorizacao(IdentifyGenerator.sequencialCodeGenerator());
        transacao.getDescricao().setStatus(StatusTransacao.AUTORIZADO);

        return transacao;
    }

    @Transactional
    public Transacao estornar(Transacao transacao) {
        validarTransacaoEstorno(transacao);
        transacao.getDescricao().setStatus(StatusTransacao.CANCELADO);

        return transacao;
    }

    public Transacao buscarTransacao(UUID id) {
        return repository.findById(id).orElseThrow(() -> new TransacaoNaoEncontradaException("Transação não encontrada"));
    }

    public Transacao buscarEstorno(String id) {
        return transacaoRepository.findByIdAndStatus(UUID.fromString(id), StatusTransacao.CANCELADO)
                .orElseThrow( () -> new TransacaoNaoEncontradaException("Estorno não encontrado para o id selecionado", id));
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
