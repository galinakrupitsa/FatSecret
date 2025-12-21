package org.example.fatsecret;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.fatsecret.DTO.DTODairyRecord;

import java.util.List;
@Data
@Getter
@Setter
@AllArgsConstructor
public class Dairy {
    private List<DTODairyRecord> records;
}
