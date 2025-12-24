package org.example.fatsecret.Service;

import org.example.fatsecret.DTO.DTODairyRecord;
import org.example.fatsecret.Dairy;
import org.example.fatsecret.Entity.UsersKkal;
import org.example.fatsecret.Repositories.KkalEntryRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private KkalEntryRepository kkalRepo;

    @InjectMocks
    private UserService service;

    @Test
    void getDiaryIntervalDay() {
        Long userId = 9L;
        LocalDateTime since = LocalDateTime.of(2025, 12, 12, 0, 0);
        LocalDateTime until = LocalDateTime.of(2025, 12, 13, 23, 59);
        // День 2023-10-25: 500 + 300 = 800
        UsersKkal record1 = new UsersKkal();
        record1.setKkal(500);
        record1.setDt(LocalDateTime.of(2025, 12, 12, 10, 0));
        UsersKkal record2 = new UsersKkal();
        record2.setKkal(300);
        record2.setDt(LocalDateTime.of(2025, 12, 12, 12, 30));
        // День 2023-10-26: 200 + 100 = 300
        UsersKkal record3 = new UsersKkal();
        record3.setKkal(200);
        record3.setDt(LocalDateTime.of(2025, 12, 13, 20, 0));
        UsersKkal record4 = new UsersKkal();
        record4.setKkal(400);
        record4.setDt(LocalDateTime.of(2025, 12, 13, 20, 30));
        List<UsersKkal> repoResult = new ArrayList<>();
        repoResult.add(record1);
        repoResult.add(record2);
        repoResult.add(record3);
        repoResult.add(record4);
        when(kkalRepo.findAllByUserIdAndDtBetween(userId, since, until)).thenReturn(repoResult);
        Dairy dairy = service.getDiaryIntervalDay(userId, since, until);
        assertNotNull(dairy);
        List<DTODairyRecord> records = dairy.getRecords();
        assertNotNull(records);
        assertEquals(records.size(), 2);
        assertEquals(records.get(0).getKkal(), 600);

    }
}