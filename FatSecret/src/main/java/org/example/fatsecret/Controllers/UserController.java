package org.example.fatsecret.Controllers;

import org.example.fatsecret.DTO.KkalEntryDTO;
import org.example.fatsecret.Dairy;
import org.example.fatsecret.Entity.UsersKkal;
import org.example.fatsecret.Exceptions.NameEmptyException;
import org.example.fatsecret.ListWeight;
import org.example.fatsecret.Service.UserService;
import org.example.fatsecret.Entity.User;
import org.example.fatsecret.WeightedUsers;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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

    @GetMapping("/weight/{weight}")
    public List<WeightedUsers> getUsersByExactWeight(@PathVariable Integer weight) {
        return service.findByWeight(weight);
    }
    @GetMapping("/weight/sorted")
    public List<WeightedUsers> findByWeightGreaterThanOrderByWeightDesc(){
        return service.findByWeightGreaterThanOrderByWeightDesc();
    }

    @PostMapping("/dairy/{id}")
    public UsersKkal createDairy(@PathVariable Long id, @RequestBody KkalEntryDTO dto) {
        return service.addKkal(id, dto);
    }

    @GetMapping("/diary/user/{userId}")
    public Dairy getDiary(
            @PathVariable Long userId,
            @RequestParam LocalDateTime since,
            @RequestParam LocalDateTime until)
     {
        return service.getDiaryInterval(userId, since, until);
    }
}
