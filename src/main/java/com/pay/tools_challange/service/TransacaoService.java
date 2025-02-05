package com.pay.tools_challange.service;

import com.pay.tools_challange.exception.TransacaoNaoEncontradaException;
import com.pay.tools_challange.model.Transacao;
import com.pay.tools_challange.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

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

    public Transacao buscarPorId(UUID id) {
        return repository.findById(id).orElseThrow(() -> new TransacaoNaoEncontradaException("Transação não encontrada"));
    }

    public List<Transacao> listarTodas() {
        return repository.findAll();
    }

    public void deletar(UUID id) {
        repository.deleteById(id);
    }

}
