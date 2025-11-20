package org.example.fatsecret.Service;

import org.example.fatsecret.Repositories.FatRepository;
import org.example.fatsecret.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final FatRepository repo;

    public UserService(FatRepository repo) {
        this.repo = repo;
    }
    public User createUser(User user) {
        return repo.save(user);
    }

    public User getUserById(Long id) {
        User user = repo.findById(id).orElse(null);
        if (user == null) {
            throw new RuntimeException("User with id " + id + " not found");
        }

        return user;
    }
}
