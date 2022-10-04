package com.bkabatas.SpringBootDemoApp.controller;

import com.bkabatas.SpringBootDemoApp.model.Champion;
import com.bkabatas.SpringBootDemoApp.service.ChampionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/champion")
@CrossOrigin
public class ChampionController {

    @Autowired
    private ChampionService championService;

    @PostMapping("/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Champion createChampion(@RequestBody Champion champion){
        return championService.createChampion(champion);
    }

    @GetMapping("/getAll")
    public List<Champion> getAllChampion(){
        return  championService.getAllChampion();
    }

    @GetMapping("/{id}")
    public Champion getChampionById(@PathVariable("id") Long id){
        return championService.getChampionById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteChampionById(@PathVariable("id") Long id){
        return  championService.deleteChampionById(id);
    }

    @PutMapping("/{id}")
    public Champion updateChampion(@PathVariable("id") Long id ,@RequestBody Champion champion){
        return championService.updateChampion(id, champion);
    }



}
