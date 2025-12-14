package org.example.fatsecret.Service.userTest;

import org.example.fatsecret.Entity.User;
import org.example.fatsecret.Repositories.FatRepository;
import org.example.fatsecret.Service.UserService;
import org.example.fatsecret.WeightedUsers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class UserTest {
    @InjectMocks
    private UserService service;
    @Mock
    private FatRepository repo;

    @Test
    public void shouldFindByWeight(){
        Mockito.when(repo.findByWeightGreaterThan(70))
                .thenReturn(List.of());

        List<WeightedUsers> result = service.findByWeight(70);
        assertNotNull(result);
        assertEquals(0, result.size());
        Mockito.verify(repo).findByWeightGreaterThan(70);
    }

}
