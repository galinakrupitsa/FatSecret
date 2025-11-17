package org.example.fatsecret;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
public class FatController {
    private final FatService service;

    public FatController(FatService service) {
        this.service = service;
    }

    @PostMapping("/{id}")
    public User create(@RequestBody User body) {
        return service.createUser(body);
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return service.getUserById(id);

    }
}
