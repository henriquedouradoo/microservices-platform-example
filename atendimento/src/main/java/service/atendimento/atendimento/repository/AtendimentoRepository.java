package service.atendimento.atendimento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import service.atendimento.atendimento.model.AtendimentoModel;

@Repository
public interface AtendimentoRepository extends JpaRepository<AtendimentoModel, Long> {
}
