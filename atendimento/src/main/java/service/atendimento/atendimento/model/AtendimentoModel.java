package service.atendimento.atendimento.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import service.atendimento.atendimento.model.enums.Status;

import java.time.LocalDateTime;

@Entity
@Table(name = "atendimentos_tb")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AtendimentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idCliente;
    private Status status;
    private String channel;
    private LocalDateTime createdAt;

}
