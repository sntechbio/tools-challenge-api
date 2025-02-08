package com.pay.tools_challange.controller;

import com.pay.tools_challange.assembler.TransacaoAssembler;
import com.pay.tools_challange.dto.PagamentoDTO;
import com.pay.tools_challange.dto.TransacaoDTO;
import com.pay.tools_challange.model.Transacao;
import com.pay.tools_challange.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/payment")
public class TransacaoController {

    private final TransacaoService transacaoService;

    private final TransacaoAssembler transacaoAssembler;

    public TransacaoController(TransacaoService transacaoService, TransacaoAssembler transacaoAssembler) {
        this.transacaoService = transacaoService;
        this.transacaoAssembler = transacaoAssembler;
    }

    @PostMapping
    public ResponseEntity<TransacaoDTO> solicitarPagamento(@RequestBody @Valid PagamentoDTO pagamento) {
        Transacao transacao = transacaoAssembler.toEntity(pagamento.transacao());
        transacao = transacaoService.autorizar(transacao);
        Transacao transacaoSalva = transacaoService.salvar(transacao);
        return ResponseEntity.ok().body(transacaoAssembler.toDTO(transacaoSalva));
    }

    @PostMapping("/estorno/{id}")
    public ResponseEntity<TransacaoDTO> estornarPagamento(@PathVariable String id) {
        Transacao transacao = transacaoService.buscarPorId(UUID.fromString(id));
        return ResponseEntity.ok().body(transacaoAssembler.toDTO(transacaoService.estornar(transacao)));
    }

}
