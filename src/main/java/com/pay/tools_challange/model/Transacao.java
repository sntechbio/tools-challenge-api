package com.pay.tools_challange.model;

import com.pay.tools_challange.enums.FormaPagamento;
import com.pay.tools_challange.enums.StatusTransacao;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank
    private FormaPagamento formaPagamento;

    @NotNull
    private BigDecimal valor;

    @CreationTimestamp
    private LocalDateTime dataHora;

    @NotBlank
    private StatusTransacao status;

}
