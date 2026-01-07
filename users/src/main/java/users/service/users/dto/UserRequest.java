package users.service.users.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank(message = "name is required!") String name,
        @Email(message = "email invalid")
        @NotBlank(message = "email is required!") String email) {

        @Override
        public String toString() {
                return "{" +
                        "name='" + name + '\'' +
                        ", email='" + email + '\'' +
                        '}';
        }
}
