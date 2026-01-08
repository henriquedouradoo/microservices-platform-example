package service.atendimento.atendimento.dto;

import service.atendimento.atendimento.model.enums.Status;

import java.time.LocalDateTime;

public record AtendimentoResponse(
        Long id,
        Long idCliente,
        Status status,
        String channel,
        LocalDateTime createdAt
) {
}
