package com.pay.tools_challange.repository;

import com.pay.tools_challange.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface TransacaoRepository extends JpaRepository<Transacao, UUID> {

    @Query("select t from Transacao t where t.id = :idTransacao and t.descricao.status = :status")
    Optional<Transacao> findByIdAndStatus(UUID idTransacao, String status);

}
