package org.example.fatsecret.Service.userTest;

import org.example.fatsecret.DTO.DT0month;
import org.example.fatsecret.DTO.DTO;
import org.example.fatsecret.DailyRecomendation;
import org.example.fatsecret.Entity.User;
import org.example.fatsecret.MonthRecomendation;
import org.example.fatsecret.Service.KkalService;
import org.example.fatsecret.Service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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

    @Test
    void calculateCalendaryGoalTest() {
        Long userId = 1L;
        User user = new User();
        user.setAge(25);
        user.setWeight(70);
        user.setHeight(175.0);
        user.setActivity(1.2);
        DT0month dto = new DT0month(1L, 3,75);
        dto.setMonth(3);
        dto.setDesiredweight(75);
        when(userService.getUserById(userId)).thenReturn(user);
        // when
        MonthRecomendation result =
                kkalService.calculateCalendaryGoal(userId, dto);
        assertNotNull(result);
        assertEquals(0.0, result.getTotal(), 0.01);
        assertEquals(1810.5, result.getMonthlyCallory().get(0), 0.01);
        assertEquals(1991.55, result.getMonthlyCallory().get(1), 0.01);
        assertEquals(2190.705, result.getMonthlyCallory().get(2), 0.01);



    }
}