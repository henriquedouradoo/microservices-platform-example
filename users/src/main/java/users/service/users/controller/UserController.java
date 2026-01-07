package users.service.users.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import users.service.users.dto.UserRequest;
import users.service.users.dto.UserResponse;
import users.service.users.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@Slf4j
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> insertUser(@RequestBody @Valid UserRequest userRequest) {

        log.info("Request received: POST /users");

        UserResponse userResponse = userService.save(userRequest);
        log.debug("Data of request: {}", userRequest);
        log.info("Endpoint with return - 201 CREATED");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userResponse);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll() {
        log.info("Request received: GET /users");
        log.info("Started process of the list all users");
        log.info("Endpoint with return - 200 OK");
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id) {

        log.info("Request received: GET /users/{}", id);
        UserResponse userResponse = userService.findById(id);
        log.info("Endpoint with return - 200 OK ");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(userResponse);
    }

    @PutMapping("{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody UserRequest userRequest) {

        log.info("Request received: PUT /users/{}", id);
        userService.updateById(id, userRequest);
        log.debug("Data of request: id - {}, {}", id, userRequest);
        log.info("Endpoint with return - 200 OK");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User was updated with success!");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id) {
        log.info("Request received: DELETE /users/{}", id);
        userService.delete(id);
        log.info("Endpoint with return - 200 OK");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("User was delete with success!");
    }
}
