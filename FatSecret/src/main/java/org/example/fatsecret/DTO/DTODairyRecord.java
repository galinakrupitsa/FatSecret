package org.example.fatsecret.DTO;

import lombok.Data;

import java.time.LocalDateTime;
@Data
@lombok.Setter
@lombok.Getter
@lombok.NoArgsConstructor
@lombok.AllArgsConstructor
public class DTODairyRecord {
    private Double kkal;
    private LocalDateTime dt;
}
