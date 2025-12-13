package org.example.fatsecret.DTO;

import lombok.Data;
import lombok.NonNull;

@lombok.Getter
@lombok.Setter
@Data
public class DTO {
    private Long id;
    private String username;
    private Integer age;
    private Integer weight;
//    @NonNull
    private Double height;
    private double activity;
    private Integer month;
    private Integer desiredweight;

}
