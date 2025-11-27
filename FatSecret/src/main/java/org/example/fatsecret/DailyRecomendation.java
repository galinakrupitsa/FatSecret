package org.example.fatsecret;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class DailyRecomendation {
    private Double kkal;
    public DailyRecomendation(Double kkal) {
        this.kkal = kkal;
    }
}
