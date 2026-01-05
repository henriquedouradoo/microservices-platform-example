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
    public ResponseEntity<UserResponse> insertUser(@RequestBody @Valid UserRequest userRequest) {
        UserResponse userResponse = userService.save(userRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userResponse);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {
        UserResponse userResponse = userService.findById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        userService.updateById(id, userRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User was updated with success!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        userService.delete(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User was delete with success!");
    }
}
