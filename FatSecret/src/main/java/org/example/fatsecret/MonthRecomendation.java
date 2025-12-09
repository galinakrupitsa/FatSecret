package org.example.fatsecret;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class MonthRecomendation {
    private List<Double> monthlyCallory;
    private Double total;

}
