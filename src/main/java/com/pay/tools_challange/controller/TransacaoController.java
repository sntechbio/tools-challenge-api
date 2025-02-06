package com.pay.tools_challange.controller;

import com.pay.tools_challange.assembler.TransacaoAssembler;
import com.pay.tools_challange.dto.TransacaoDTO;
import com.pay.tools_challange.model.Transacao;
import com.pay.tools_challange.service.TransacaoService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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
    public void solicitarPagamento(@RequestBody @Valid TransacaoDTO transacaoDTO) {
        Transacao transacao = transacaoAssembler.toEntity(transacaoDTO);
    }

    @GetMapping("hello")
    public String hello() {
        return "Hello World!";
    }

}
