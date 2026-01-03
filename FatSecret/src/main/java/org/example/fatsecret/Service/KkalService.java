package org.example.fatsecret.Service;

import org.example.fatsecret.DTO.DT0month;
import org.example.fatsecret.DTO.DTO;
import org.example.fatsecret.DTO.DTODairyRecord;
import org.example.fatsecret.DailyRecomendation;
import org.example.fatsecret.DayCalloryReport;
import org.example.fatsecret.Entity.User;
import org.example.fatsecret.Entity.UsersKkal;
import org.example.fatsecret.MonthRecomendation;
import org.example.fatsecret.Repositories.KkalEntryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class KkalService {

    private final UserService userService;
    private final KkalEntryRepository kkalRepo;

    public KkalService(UserService userService, KkalEntryRepository kkalRepo) {
        this.userService = userService;
        this.kkalRepo = kkalRepo;
    }

    private Double calculateImplementation(int age, int weight, Double height, Double activity){
        return (10 * weight + 6.25 * height - 5 * age -160) * activity;
    }

    public DailyRecomendation calculate(DTO dto){
         double kkal = calculateImplementation(dto.getAge(), dto.getWeight(), dto.getHeight(), dto.getActivity() );
         return new DailyRecomendation(kkal);
    }

    public DailyRecomendation calculateMembers (Long id){
        User user = userService.getUserById(id);
        double kkal = calculateImplementation(user.getAge(), user.getWeight(), user.getHeight(), user.getActivity());
        return new DailyRecomendation(kkal);
    }

    public MonthRecomendation calculateCalendary (Long id, DTO dto){
        User user = userService.getUserById(id);
        List<Double> monthlyCallory = new ArrayList<>();
        Double total = 0.0;
        Double current = calculateImplementation(user.getAge(), user.getWeight(), user.getHeight(), user.getActivity());
        for (int i = 0; i < dto.getMonth(); i++){
            monthlyCallory.add(current);
            total = total + 30 * (current);
            current*=0.9;
        }
        return new MonthRecomendation(monthlyCallory, total);
    }

    public MonthRecomendation calculateCalendaryGoal (Long id, DT0month dto){
        User user = userService.getUserById(id);
        List<Double> monthlyCallory = new ArrayList<>();
        Double total =0.0;
        Double current = calculateImplementation(user.getAge(), user.getWeight(), user.getHeight(), user.getActivity());
        for (int i = 0; i < dto.getMonth(); i++){
            monthlyCallory.add(current);
            if (dto.getDesiredweight()>user.getWeight()){
                current*=1.1;
            } else
                if (dto.getDesiredweight()<user.getWeight()){
                    current*=0.9;
                } else  {
                    current*=1;
                }
        }
        return new MonthRecomendation(monthlyCallory, total );
    }

    public Double calculateIMTImplementation (Integer weight, Double height){
        height = height/100;
        return (weight/Math.pow((height),2));
    }
    public Double calculateMembersIMT(Long id){
        User user = userService.getUserById(id);
        return calculateIMTImplementation(user.getWeight(), user.getHeight());
    }
    public Double calculateIMT (DTO dto){
        return calculateIMTImplementation(dto.getWeight(), dto.getHeight());
    }
    public DayCalloryReport getDayTotal(Long userId){
        LocalDate today = LocalDate.now();
        LocalDateTime start = today.atStartOfDay();
        LocalDateTime end = today.plusDays(1).atStartOfDay();

        DayCalloryReport dayCalloryReport = new DayCalloryReport();

        dayCalloryReport.setDayRecomendation(calculateMembers(userId).getKkal());
        List<UsersKkal> d = kkalRepo.findAllByUserIdAndDtBetween(userId, start, end);
        double total = 0.0;
        for (UsersKkal usersKkal : d) {
             total += usersKkal.getKkal();
        }
        dayCalloryReport.setDayCurrent(total);

        dayCalloryReport.dayTotal = dayCalloryReport.getDayRecomendation()-dayCalloryReport.dayCurrent;
        return dayCalloryReport;

    }

    public double getOvereating(Long userId, LocalDateTime since, LocalDateTime until){
        long days = ChronoUnit.DAYS.between(
                since.toLocalDate(),
                until.toLocalDate()
        );

        double recom = (calculateMembers(userId).getKkal())*days;

        List<DTODairyRecord> d  = userService.getDiaryInterval(userId, since, until).getRecords();
        double totalFact = 0.0;
        for (DTODairyRecord record : d) {
            totalFact += record.getKkal();
        }

        double overeating = recom - totalFact;
        return overeating;
    }
}

