package org.example.fatsecret.Service;

import org.example.fatsecret.DTO.DTO;
import org.example.fatsecret.DailyRecomendation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class KkalServiceTest {

    @Mock
    UserService userService; // 🔹 МОК

    @InjectMocks
    KkalService kkalService; // 🔹 сюда автоматически подставится mock UserService

    @Test
    void calculateTest() {

        DTO dto = new DTO();
        dto.setAge(25);
        dto.setWeight(70);
        dto.setHeight(175.0);
        dto.setActivity(1.2);

        DailyRecomendation result = kkalService.calculate(dto);
// then
        assertNotNull(result);
        assertEquals(1810.5, result.getKkal(), 0.01);
    }
}