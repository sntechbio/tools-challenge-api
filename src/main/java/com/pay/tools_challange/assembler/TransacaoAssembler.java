package com.pay.tools_challange.assembler;

import com.pay.tools_challange.dto.DescricaoDTO;
import com.pay.tools_challange.dto.FormaPagamentoDTO;
import com.pay.tools_challange.dto.TransacaoDTO;
import com.pay.tools_challange.model.Descricao;
import com.pay.tools_challange.model.FormaPagamento;
import com.pay.tools_challange.model.Transacao;
import org.springframework.stereotype.Component;

@Component
public class TransacaoAssembler {

    public TransacaoDTO toDTO(Transacao transacao) {
        return new TransacaoDTO(
                transacao.getCartao(),
                new DescricaoDTO(
                        transacao.getDescricao().getValor(),
                        transacao.getDescricao().getDataHora(),
                        transacao.getDescricao().getEstabelecimento()
                ),
                new FormaPagamentoDTO(
                        transacao.getFormaPagamento().getTipo(),
                        transacao.getFormaPagamento().getParcelas()
                )
        );
    }

    public Transacao toEntity(TransacaoDTO transacaoDTO) {
        Transacao transacao = new Transacao();

        Descricao descricao = new Descricao();
        descricao.setValor(transacaoDTO.descricaoDTO().valor());
        descricao.setEstabelecimento(transacaoDTO.descricaoDTO().estabelecimento());
        descricao.setDataHora(transacaoDTO.descricaoDTO().dataHora());

        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setTipo(transacaoDTO.formaPagamentoDTO().tipoPagamento());
        formaPagamento.setParcelas(transacaoDTO.formaPagamentoDTO().parcelas());

        transacao.setCartao(transacaoDTO.cartao());
        transacao.setDescricao(descricao);
        transacao.setFormaPagamento(formaPagamento);

        return transacao;
    }

}
