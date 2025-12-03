package org.example.fatsecret.Service;

import org.example.fatsecret.DTO;
import org.example.fatsecret.DailyRecomendation;
import org.example.fatsecret.Entity.User;
import org.example.fatsecret.MonthRecomendation;
import org.springframework.stereotype.Service;

@Service
public class KkalService {

    private final UserService userService;

    public KkalService(UserService userService) {
        this.userService = userService;
    }

    private Double calculateImplementation(int age, int weight, int height, Double activity){
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
        Double current = calculateImplementation(user.getAge(), user.getWeight(), user.getHeight(), user.getActivity());
        for (int i = 0; i < dto.getMonth(); i++){
            current*=0.9;
        }

        return new MonthRecomendation();
    }


}

