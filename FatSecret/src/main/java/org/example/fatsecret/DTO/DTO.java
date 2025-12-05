package org.example.fatsecret.DTO;

import lombok.Data;

@lombok.Getter
@lombok.Setter
@Data
public class DTO {
    private Long id;
    private String username;
    private int age;
    private int weight;
    private int height;
    private double activity;
    private int month;
    private int desiredweight;

}
