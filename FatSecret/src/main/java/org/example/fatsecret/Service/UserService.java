package org.example.fatsecret.Service;

import org.example.fatsecret.Exceptions.UserNotFoundException;
import org.example.fatsecret.ListWeight;
import org.example.fatsecret.Repositories.FatRepository;
import org.example.fatsecret.Entity.User;
import org.example.fatsecret.WeightedUsers;
import org.springframework.stereotype.Service;

import java.util.List;

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
            return repo.findById(id)
                    .orElseThrow(() -> new UserNotFoundException(id));

            }
    public List<WeightedUsers> findByWeight(Integer weight) {
        return repo.findByWeightGreaterThan(weight);
        }

    public List<WeightedUsers> findByWeightGreaterThanOrderByWeightDesc(){
        return repo.findByWeightGreaterThanOrderByWeightDesc(90);
    }
}


