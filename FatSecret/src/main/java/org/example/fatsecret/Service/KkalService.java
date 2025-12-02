package org.example.fatsecret.Service;

import org.example.fatsecret.DailyRecomendation;
import org.example.fatsecret.Entity.User;
import org.springframework.stereotype.Service;

@Service
public class KkalService {

    private final UserService userService;
    int d;
    int b =0;

    public KkalService(UserService userService) {
        this.userService = userService;
    }


    public DailyRecomendation calculate(int age, int weight, int height, Double activity){

         double kkal = (10 * weight + 6.25 * height - 5 * age -160) * activity;
         return new DailyRecomendation(kkal);
    }

    public DailyRecomendation calculateMembers (Long id){
        User user = userService.getUserById(id);
        double kkal = (10 * user.getWeight() + 6.25 * user.getHeight() - 5 * user.getAge() -160) * user.getActivity();
        return new DailyRecomendation(kkal);
    }

    public void incrementb() {

        for (int i = 0; i < 5; i++) {
            b++;
        }
        System.out.println(b);
    }

}

