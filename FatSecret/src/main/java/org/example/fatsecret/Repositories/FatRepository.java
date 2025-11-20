package org.example.fatsecret.Repositories;

import org.example.fatsecret.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FatRepository extends JpaRepository<User, Long> {
}