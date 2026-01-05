package users.service.users.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import users.service.users.dto.UserRequest;
import users.service.users.dto.UserResponse;
import users.service.users.model.UserModel;
import users.service.users.repository.UserRepository;
import java.util.List;

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

    public UserResponse toResponse(UserModel userModel) {
        return new UserResponse(
                userModel.getId(),
                userModel.getName(),
                userModel.getEmail()
        );
    }

}
