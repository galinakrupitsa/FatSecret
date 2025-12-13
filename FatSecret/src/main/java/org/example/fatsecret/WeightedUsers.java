package org.example.fatsecret;

import lombok.Data;

@Data
public class WeightedUsers {
    private Long id;
    private Integer weight;
    private WeightedUsers(Long id, Integer weight) {
        this.id = id;
        this.weight = weight;
    }
}
