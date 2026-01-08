package service.atendimento.atendimento.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import service.atendimento.atendimento.dto.AtendimentoResponse;
import service.atendimento.atendimento.model.AtendimentoModel;
import service.atendimento.atendimento.model.enums.Status;
import service.atendimento.atendimento.repository.AtendimentoRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class AtendimentoService {

    private final AtendimentoRepository repository;

    public AtendimentoResponse save(Long idChannel, String channel) {

        AtendimentoModel atendimentoModel = new AtendimentoModel();
        atendimentoModel.setIdCliente(idChannel);
        atendimentoModel.setChannel(channel);
        atendimentoModel.setStatus(Status.OPEN);
        atendimentoModel.setCreatedAt(LocalDateTime.now());

        AtendimentoModel saved = repository.save(atendimentoModel);

        log.info("Atendimento created | atendimentoId={} | clienteId={} | channel={}",
                saved.getId(), saved.getIdCliente(), saved.getChannel());

        return toResponse(saved);
    }

    public AtendimentoResponse findById(Long idCliente) {

        AtendimentoModel atendimentoModel = repository.findById(idCliente).orElseThrow(() ->
                new RuntimeException("Atendimento not found"));

        return toResponse(atendimentoModel);
    }

    public List<AtendimentoResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public AtendimentoResponse toResponse(AtendimentoModel atendimentoModel) {

        return new AtendimentoResponse(
                atendimentoModel.getId(),
                atendimentoModel.getIdCliente(),
                atendimentoModel.getStatus(),
                atendimentoModel.getChannel(),
                atendimentoModel.getCreatedAt()
        );

    }

}
