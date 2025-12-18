package org.example.fatsecret.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Entity
@Data

public class UsersKkal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double kkal;
    private LocalDateTime dt;
}
