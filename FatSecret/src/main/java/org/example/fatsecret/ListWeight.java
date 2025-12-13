package org.example.fatsecret;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class ListWeight {
    private List<WeightedUsers> items = new ArrayList<>();
    public ListWeight(List<WeightedUsers> items) {
        this.items = (ArrayList<WeightedUsers>) items;
    }
}
