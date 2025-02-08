package com.pay.tools_challange.assembler;

import com.pay.tools_challange.dto.DescricaoDTO;
import com.pay.tools_challange.dto.FormaPagamentoDTO;
import com.pay.tools_challange.dto.PagamentoDTO;
import com.pay.tools_challange.dto.TransacaoDTO;
import com.pay.tools_challange.model.Descricao;
import com.pay.tools_challange.model.FormaPagamento;
import com.pay.tools_challange.model.Transacao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransacaoAssembler {

    public PagamentoDTO toDTO(Transacao transacao) {
        TransacaoDTO transacaoDTO = new TransacaoDTO(
                transacao.getCartao(),
                transacao.getId().toString(),
                toDescricaoDTO(transacao),
                toFormaPagamentoDTO(transacao)
        );

        return new PagamentoDTO(transacaoDTO);
    }

    public Transacao toEntity(TransacaoDTO transacaoDTO) {
        Transacao transacao = new Transacao();

        Descricao descricao = new Descricao();
        descricao.setValor(transacaoDTO.descricao().valor());
        descricao.setEstabelecimento(transacaoDTO.descricao().estabelecimento());
        descricao.setDataHora(transacaoDTO.descricao().dataHora());

        FormaPagamento formaPagamento = new FormaPagamento();
        formaPagamento.setTipo(transacaoDTO.formaPagamento().tipo());
        formaPagamento.setParcelas(transacaoDTO.formaPagamento().parcelas());

        transacao.setCartao(transacaoDTO.cartao());
        transacao.setDescricao(descricao);
        transacao.setFormaPagamento(formaPagamento);

        return transacao;
    }

    public List<PagamentoDTO> toCollectionModel(List<Transacao> transacoes) {
        return transacoes.stream().map(this::toDTO).toList();
    }

    private FormaPagamentoDTO toFormaPagamentoDTO(Transacao transacao) {
        return new FormaPagamentoDTO(
                transacao.getFormaPagamento().getTipo(),
                transacao.getFormaPagamento().getParcelas()
        );
    }

    private DescricaoDTO toDescricaoDTO(Transacao transacao) {
        return new DescricaoDTO(
                transacao.getDescricao().getValor(),
                transacao.getDescricao().getDataHora(),
                transacao.getDescricao().getEstabelecimento(),
                transacao.getDescricao().getNsu(),
                transacao.getDescricao().getCodigoAutorizacao(),
                transacao.getDescricao().getStatus()
        );
    }

}
