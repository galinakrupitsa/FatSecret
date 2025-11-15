package org.example.fatsecret;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FatRepository extends JpaRepository<User, Long> {
}