package service.atendimento.atendimento.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.atendimento.atendimento.dto.AtendimentoRequest;
import service.atendimento.atendimento.dto.AtendimentoResponse;
import service.atendimento.atendimento.model.AtendimentoModel;
import service.atendimento.atendimento.service.AtendimentoService;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
@AllArgsConstructor
public class AtendimentoController {

    private final AtendimentoService service;

    @PostMapping
    public ResponseEntity<AtendimentoResponse> create(@RequestBody AtendimentoRequest atendimentoRequest) {

        AtendimentoResponse atendimentoResponse = service.save(
                atendimentoRequest.idCliente(), atendimentoRequest.channel());

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(atendimentoResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AtendimentoResponse> listById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<AtendimentoResponse>> listAll() {
        return ResponseEntity.status(HttpStatus.OK).body(service.findAll());
    }

}
