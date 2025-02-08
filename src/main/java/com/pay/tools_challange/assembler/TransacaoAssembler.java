package com.pay.tools_challange.assembler;

import com.pay.tools_challange.dto.PagamentoDTO;
import com.pay.tools_challange.dto.TransacaoDTO;
import com.pay.tools_challange.model.Transacao;

import java.util.List;

public interface TransacaoAssembler {
    PagamentoDTO toDTO(Transacao transacao);
    Transacao toEntity(TransacaoDTO transacaoDTO);
    List<PagamentoDTO> toCollectionModel(List<Transacao> transacoes);
}
