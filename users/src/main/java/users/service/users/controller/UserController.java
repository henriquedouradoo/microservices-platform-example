package users.service.users.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.service.users.dto.UserRequest;
import users.service.users.dto.UserResponse;
import users.service.users.model.UserModel;
import users.service.users.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> insertUser(@RequestBody @Valid UserRequest userRequest) {
        userService.save(userRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("User created with success!");
    }

    @GetMapping
    public List<UserModel> findAll() {
        return userService.findAll();
    }
}
