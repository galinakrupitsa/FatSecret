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

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
}


