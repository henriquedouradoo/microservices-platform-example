package service.atendimento.atendimento.dto;

import service.atendimento.atendimento.model.enums.Status;

public record AtendimentoRequest(
        Long idCliente,
        String channel
) {
}
