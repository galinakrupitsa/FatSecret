package org.example.fatsecret.Repositories;

import org.example.fatsecret.Entity.User;
import org.example.fatsecret.WeightedUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FatRepository extends JpaRepository<User, Long> {
    List<WeightedUsers> findByWeightGreaterThan(Integer weight);
}