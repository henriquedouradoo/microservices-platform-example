package users.service.users.events;

import java.time.LocalDateTime;

public record UserCreatedEvent(Long id,
                               String name,
                               String email) {
}
