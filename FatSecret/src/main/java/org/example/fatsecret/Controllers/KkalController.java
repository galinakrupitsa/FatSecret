package org.example.fatsecret.Controllers;

import org.example.fatsecret.DTO;
import org.example.fatsecret.DailyRecomendation;
import org.example.fatsecret.Entity.User;
import org.example.fatsecret.Service.KkalService;
import org.example.fatsecret.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/calculator")
public class KkalController {
    public final KkalService kkalService;

    @Autowired
    public KkalController(KkalService kkalService) {
        this.kkalService = kkalService;
    }

    @PostMapping ("/dayllycallory")
    public DailyRecomendation kkalCalculate (@RequestBody DTO dto){
         return  kkalService.calculate( dto.getAge(), dto.getHeight(), dto.getWeight(), dto.getActivity());
}

    @GetMapping ("/members/dayllycallory/{id}")
    public DailyRecomendation kkalCalculateMembers (@PathVariable Long id){
        return  kkalService.calculateMembers(id);
    }

    @PostMapping ("/monthlycallary")
    public
}
