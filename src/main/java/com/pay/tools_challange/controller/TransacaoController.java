package com.pay.tools_challange.controller;

import com.pay.tools_challange.assembler.TransacaoAssembler;
import com.pay.tools_challange.dto.PagamentoDTO;
import com.pay.tools_challange.model.Transacao;
import com.pay.tools_challange.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pagamento")
public class TransacaoController {

    private final TransacaoService transacaoService;

    private final TransacaoAssembler transacaoAssembler;

    public TransacaoController(TransacaoService transacaoService, TransacaoAssembler transacaoAssembler) {
        this.transacaoService = transacaoService;
        this.transacaoAssembler = transacaoAssembler;
    }

    @PostMapping
    public ResponseEntity<PagamentoDTO> solicitarPagamento(@RequestBody @Valid PagamentoDTO pagamento) {
        Transacao transacao = transacaoAssembler.toEntity(pagamento.transacao());
        transacao = transacaoService.autorizar(transacao);
        Transacao transacaoSalva = transacaoService.salvar(transacao);
        return ResponseEntity.ok().body(transacaoAssembler.toDTO(transacaoSalva));
    }

    @PostMapping("/{id}/estorno")
    public ResponseEntity<PagamentoDTO> estornarPagamento(@PathVariable String id) {
        Transacao transacao = transacaoService.buscarTransacao(UUID.fromString(id));
        return ResponseEntity.ok().body(transacaoAssembler.toDTO(transacaoService.estornar(transacao)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PagamentoDTO> buscarPagamentoPorId(@PathVariable String id) {
        Transacao transacao = transacaoService.buscarTransacao(UUID.fromString(id));
        return ResponseEntity.ok().body(transacaoAssembler.toDTO(transacao));
    }

    @GetMapping("/estorno/{id}")
    public ResponseEntity<PagamentoDTO> buscarEstornoPorId(@PathVariable String id) {
        Transacao transacao = transacaoService.buscarEstorno(id);
        return ResponseEntity.ok().body(transacaoAssembler.toDTO(transacao));
    }

    @GetMapping("/listar")
    public List<PagamentoDTO> listar() {
        return transacaoAssembler.toCollectionModel(transacaoService.listar());
    }

}
