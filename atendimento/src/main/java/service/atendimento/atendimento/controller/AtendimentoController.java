package service.atendimento.atendimento.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.atendimento.atendimento.dto.AtendimentoRequest;
import service.atendimento.atendimento.dto.AtendimentoResponse;
import service.atendimento.atendimento.model.AtendimentoModel;
import service.atendimento.atendimento.model.enums.Status;
import service.atendimento.atendimento.service.AtendimentoService;

import java.util.List;

@RestController
@RequestMapping("/atendimentos")
@AllArgsConstructor
public class AtendimentoController {

    private final AtendimentoService service;

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

    @PutMapping("/{id}")
    public ResponseEntity<AtendimentoModel> updateStatus(@PathVariable Long id, @RequestBody Status status) {
        AtendimentoModel atendimentoModel = service.updateStatus(id, status);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(atendimentoModel);
    }

}
