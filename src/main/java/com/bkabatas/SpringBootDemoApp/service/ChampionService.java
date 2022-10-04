package com.bkabatas.SpringBootDemoApp.service;

import com.bkabatas.SpringBootDemoApp.model.Champion;

import java.util.List;

public interface ChampionService {
    List<Champion> getAllChampion();
    Champion createChampion(Champion champion);


    Champion updateChampion(Long id, Champion champion);

    String deleteChampionById(Long id);

    Champion getChampionById(Long id);
}
