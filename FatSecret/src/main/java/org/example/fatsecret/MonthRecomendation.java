package org.example.fatsecret;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Data
public class MonthRecomendation {
    private List<Double> monthlyCallory = new ArrayList<>();
}
