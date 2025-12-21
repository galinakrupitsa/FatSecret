package org.example.fatsecret.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
@Entity
@Data
@Getter
@Setter

public class UsersKkal {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double kkal;
    private LocalDateTime dt;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
