package service.atendimento.atendimento.events;

public record UserCreatedEvent(
        Long id,
        String name,
        String email
) {
}
