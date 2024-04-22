package com.maximodev.gamelist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maximodev.gamelist.dto.GameMinDTO;
import com.maximodev.gamelist.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll(){
        var result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

}
