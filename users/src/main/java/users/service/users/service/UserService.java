package users.service.users.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import users.service.users.dto.UserRequest;
import users.service.users.dto.UserResponse;
import users.service.users.model.UserModel;
import users.service.users.repository.UserRepository;

import java.beans.BeanProperty;
import java.util.ArrayList;
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

        return new UserResponse(
                saved.getId(),
                saved.getName(),
                saved.getEmail()
        );
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

}
