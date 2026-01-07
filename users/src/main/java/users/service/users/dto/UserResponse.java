package users.service.users.dto;

public record UserResponse(Long id, String name, String email) {

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
