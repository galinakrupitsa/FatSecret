package org.example.fatsecret.Service;

import org.example.fatsecret.DailyRecomendation;
import org.springframework.stereotype.Service;

@Service
public class KkalService {

    public DailyRecomendation calculate(int age, int weight, int height, Double activity){
         double kkal = (10 * weight + 6.25 * height - 5 * age -160) * activity;
         return new DailyRecomendation(kkal);
    }
}

