package com.bkabatas.SpringBootDemoApp.service;

import com.bkabatas.SpringBootDemoApp.exception.ChampionNotFoundException;
import com.bkabatas.SpringBootDemoApp.model.Champion;
import com.bkabatas.SpringBootDemoApp.repository.ChampionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChampionServiceImpl implements ChampionService {

    @Autowired
    private ChampionRepository championRepository;


    @Override
    public List<Champion> getAllChampion() {
        return championRepository.findAll();
    }

    @Override
    public Champion createChampion(Champion champion) {
        return championRepository.save(champion);
    }

    @Override
    public Champion updateChampion(Long id, Champion champion) {
        Optional<Champion> update = championRepository.findById(id);
        if (update.isPresent()){
            Champion getChampion = update.get();
            getChampion.setQuantity(champion.getQuantity());
            return championRepository.save(getChampion);
        }else {
            return null;
        }
    }


    @Override
    public String deleteChampionById(Long id) {
        if(!championRepository.existsById(id)){
            throw new ChampionNotFoundException(id);
        }
        championRepository.deleteById(id);
        return "Champion with id " + id + " has been deleted success.";
    }

    @Override
    public Champion getChampionById(Long id) {
        return  championRepository.findById(id).orElseThrow(()->new ChampionNotFoundException(id));
    }
}
