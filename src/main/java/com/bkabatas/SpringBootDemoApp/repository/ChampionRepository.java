package com.bkabatas.SpringBootDemoApp.repository;

import com.bkabatas.SpringBootDemoApp.model.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChampionRepository extends JpaRepository<Champion,Long> {
    List<Champion> findAllByOrderByIdAsc();
}
