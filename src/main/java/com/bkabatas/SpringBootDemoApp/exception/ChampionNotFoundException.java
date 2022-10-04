package com.bkabatas.SpringBootDemoApp.exception;

public class ChampionNotFoundException  extends RuntimeException{
    public ChampionNotFoundException(Long id){
        super("Could not found the champion with id "+id);
    }
}
