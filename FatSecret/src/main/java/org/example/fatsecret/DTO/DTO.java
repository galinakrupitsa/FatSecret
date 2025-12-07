package org.example.fatsecret.DTO;

import lombok.Data;
import lombok.NonNull;

@lombok.Getter
@lombok.Setter
@Data
public class DTO {
    private Long id;
    private String username;
    private int age;
    private int weight;
    @NonNull
    private Integer height;
    private double activity;
    private int month;
    private int desiredweight;

}
