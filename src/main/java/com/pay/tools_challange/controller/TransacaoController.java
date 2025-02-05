package com.pay.tools_challange.controller;

import com.pay.tools_challange.dto.TransacaoDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller("/api/v1/payment")
public class TransacaoController {

    @PostMapping
    public void solicitarPagamento(@RequestBody @Valid TransacaoDTO transacaoDTO) {
        // TODO
    }

}
