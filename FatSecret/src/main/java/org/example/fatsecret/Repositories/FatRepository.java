package org.example.fatsecret.Repositories;

import org.example.fatsecret.Entity.Product;
import org.example.fatsecret.Entity.User;
import org.example.fatsecret.WeightedUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface FatRepository extends JpaRepository<User, Long> {
    List<WeightedUsers> findByWeightGreaterThan(Integer weight);
    List<WeightedUsers> findByWeightGreaterThanOrderByWeightDesc(Integer weight);

//    List<Product> findToday(LocalDateTime localDateTime, LocalDateTime localDateTime1);
}
