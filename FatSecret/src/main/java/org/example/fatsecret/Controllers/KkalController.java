package org.example.fatsecret.Controllers;

import org.example.fatsecret.DTO.DT0month;
import org.example.fatsecret.DTO.DTO;
import org.example.fatsecret.DailyRecomendation;
import org.example.fatsecret.Entity.User;
import org.example.fatsecret.MonthRecomendation;
import org.example.fatsecret.Service.KkalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
         return  kkalService.calculate(dto);
    }

    @GetMapping ("/members/dayllycallory/{id}")
    public DailyRecomendation kkalCalculateMembers (@PathVariable Long id){
        return  kkalService.calculateMembers(id);
    }

    @PostMapping ("/month/{id}")
    public MonthRecomendation kkalCalculateMonth (@PathVariable Long id,
                                                  @RequestBody DTO dto){
        return kkalService.calculateCalendary(id, dto);
    }

    @PostMapping ("/month/goal/{id}")
    public MonthRecomendation kkalCalculateGoal (@PathVariable Long id,
                                                  @RequestBody DT0month dto){
        return kkalService.calculateCalendaryGoal(id, dto);
    }

    @GetMapping ("/members/imt/{id}")
    public Double ImtCalculateMembers (@PathVariable Long id){
        return  kkalService.calculateMembersIMT(id);
    }

    @PostMapping ("/imt")
    public Double ImtCalculate (@RequestBody DTO dto){
        return  kkalService.calculateIMT(dto);
    }


}
