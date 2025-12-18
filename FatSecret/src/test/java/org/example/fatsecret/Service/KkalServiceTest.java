package org.example.fatsecret.Service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;

class KkalServiceTest {
    @Mock
    UserService userService;
    @InjectMocks
    KkalService service = new KkalService(userService);
    @Test
    void calculateIMTImplementationTest() {
        Integer weight = 75;
        Double height = 180.0;
        Double result = service.calculateIMTImplementation(weight, height);
        assertNotNull(result);
        assertEquals(23.14, result, 0.01);

    }
}