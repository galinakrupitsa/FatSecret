package org.example.fatsecret.DTO;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class DTODiaryProducts {
    private Long productId;
    private Double productWeight;
    private LocalDateTime dt;

}
