package users.service.users.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import users.service.users.dto.UserRequest;
import users.service.users.dto.UserResponse;
import users.service.users.model.UserModel;
import users.service.users.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse save(UserRequest userRequest) {
        UserModel userModel = new UserModel();
        userModel.setName(userRequest.name());
        userModel.setEmail(userRequest.email());

        UserModel saved = userRepository.save(userModel);

        return toResponse(saved);
    }

    public List<UserResponse> findAll() {
        return userRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public UserResponse findById(Long id) {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return toResponse(user);
    }

    public void delete(Long id) {
        if (!userRepository.existsById(id)) new RuntimeException("User not found");
        userRepository.deleteById(id);
    }

    public UserResponse toResponse(UserModel userModel) {
        return new UserResponse(
                userModel.getId(),
                userModel.getName(),
                userModel.getEmail()
        );
    }

}
