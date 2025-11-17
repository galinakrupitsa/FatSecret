package org.example.fatsecret;

import org.springframework.stereotype.Service;

@Service
public class FatService {
    private final FatRepository repo;

    public FatService(FatRepository repo) {
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
