package org.example.fatsecret.Repositories;

import org.example.fatsecret.Entity.User;
import org.example.fatsecret.Entity.UsersKkal;
import org.springframework.data.domain.Limit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface KkalEntryRepository extends JpaRepository<UsersKkal, Long> {
    List<UsersKkal> findAllByUserIdAndDtBetween(
            Long userId,
            LocalDateTime since,
            LocalDateTime until
    );

}
