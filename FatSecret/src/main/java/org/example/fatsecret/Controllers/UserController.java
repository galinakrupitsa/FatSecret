package org.example.fatsecret.Controllers;

import org.example.fatsecret.Exceptions.NameEmptyException;
import org.example.fatsecret.Service.UserService;
import org.example.fatsecret.Entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/{id}")
    public User create(@RequestBody User body) {
        if (body.getUsername().isEmpty()) {
            throw new NameEmptyException();
        }
            return service.createUser(body);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);

    }
}
