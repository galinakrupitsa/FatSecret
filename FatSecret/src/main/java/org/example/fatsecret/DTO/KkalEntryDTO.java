package org.example.fatsecret.DTO;

import java.time.LocalDateTime;
@lombok
@lombok.Setter
@lombok.Getter
@lombok.NoArgsConstructor
public class KkalEntryDTO {
    private Double kkal;
    private LocalDateTime dt;
}
