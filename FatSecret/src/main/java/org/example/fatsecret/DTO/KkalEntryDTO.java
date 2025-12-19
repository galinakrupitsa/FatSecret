package org.example.fatsecret.DTO;

import lombok.Data;
import org.example.fatsecret.Entity.User;

import java.time.LocalDateTime;
@Data
@lombok.Setter
@lombok.Getter
@lombok.NoArgsConstructor
public class KkalEntryDTO {
    private Double kkal;
    private LocalDateTime dt;
    private User user;
}
