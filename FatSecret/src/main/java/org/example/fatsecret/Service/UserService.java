package org.example.fatsecret.Service;

import org.example.fatsecret.DTO.DTODairyRecord;
import org.example.fatsecret.Dairy;
import org.example.fatsecret.Entity.UsersKkal;
import org.example.fatsecret.Exceptions.UserNotFoundException;
import org.example.fatsecret.Repositories.FatRepository;
import org.example.fatsecret.Entity.User;
import org.example.fatsecret.Repositories.KkalEntryRepository;
import org.example.fatsecret.WeightedUsers;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final FatRepository repo;
    private final KkalEntryRepository kkalRepo;

    public UserService(FatRepository repo, KkalEntryRepository kkalRepo) {
        this.repo = repo;
        this.kkalRepo = kkalRepo;
    }

    public User createUser(User user) {
        return repo.save(user);
    }


    public User getUserById(Long id) {
            return repo.findById(id)
                    .orElseThrow(() -> new UserNotFoundException(id));
            }
    public List<WeightedUsers> findByWeight(Integer weight) {
        return repo.findByWeightGreaterThan(weight);
        }

    public List<WeightedUsers> findByWeightGreaterThanOrderByWeightDesc(){
        return repo.findByWeightGreaterThanOrderByWeightDesc(90);
    }

    public UsersKkal addKkal(Long userId, DTODairyRecord dto) {
        User user = getUserById(userId);

        UsersKkal usersKkal = new UsersKkal();
        usersKkal.setKkal(dto.getKkal());
        usersKkal.setDt(dto.getDt());
        usersKkal.setUser(user);

        return kkalRepo.save(usersKkal);
    }

    public Dairy getDiaryInterval(Long userId,
                                  LocalDateTime since,
                                  LocalDateTime until) {
        List<UsersKkal> dairyRecords =
                kkalRepo.findAllByUserIdAndDtBetween(userId, since, until);
        List<DTODairyRecord> records = new ArrayList<>();
        for (UsersKkal usersKkal : dairyRecords) {
            records.add(new DTODairyRecord(usersKkal.getKkal(), usersKkal.getDt()));
        }

        return new Dairy(records);
    }

    public Dairy getDiaryIntervalDay(Long userId,
                                  LocalDateTime since,
                                  LocalDateTime until) {
        Map<LocalDate, Double> dataMap = new HashMap<>();
        List<UsersKkal> dairyRecords =
                kkalRepo.findAllByUserIdAndDtBetween(userId, since, until);

        for (UsersKkal usersKkal : dairyRecords) {
            LocalDate date = usersKkal.getDt().toLocalDate();
            Double kkal = usersKkal.getKkal();

            if (dataMap.containsKey(date)) {
                Double currentSum = dataMap.get(date);
                dataMap.put(date, currentSum + kkal);
            }
            else {
                dataMap.put(date, kkal);
            }
        }
        List<DTODairyRecord> records = new ArrayList<>();
        for (Map.Entry<LocalDate, Double> entry : dataMap.entrySet()) {
            records.add(
                    new DTODairyRecord(
                            entry.getValue(), // суммарные калории за день
                            entry.getKey().atStartOfDay()   // дата
                    )
            );
        }
        return new Dairy(records);
    }
}


