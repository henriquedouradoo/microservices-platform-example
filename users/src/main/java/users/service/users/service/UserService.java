package users.service.users.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import users.service.users.dto.UserRequest;
import users.service.users.dto.UserResponse;
import users.service.users.model.UserModel;
import users.service.users.repository.UserRepository;
import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponse save(UserRequest userRequest) {
        log.info("Started process of user save");
        UserModel userModel = new UserModel();
        userModel.setName(userRequest.name());
        userModel.setEmail(userRequest.email());

        UserModel saved = userRepository.save(userModel);

        log.debug("Data of User: {}", saved);
        log.info("User save process completed successfully!");

        return toResponse(saved);
    }

    public List<UserResponse> findAll() {

        return userRepository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public UserResponse findById(Long id) {
        log.info("Started process of the list user by id");
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        log.debug("Found user: {}", user);
        return toResponse(user);
    }

    public UserResponse updateById(Long id, UserRequest userRequest) {

        log.info("Started process of user update per id");

        UserModel user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(userRequest.name());
        user.setEmail(userRequest.email());
        UserModel updated = userRepository.save(user);
        log.debug("User data updated: {}", updated);
        return toResponse(updated);
    }

    public void delete(Long id) {
        log.info("Started process of user delete");
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
