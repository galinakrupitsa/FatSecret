package org.example.fatsecret;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class MonthRecomendation {
    private Double[] monthlyCallary;

    public MonthRecomendation(int monthCount) {
        monthlyCallary = new Double[monthCount];
    }

}
