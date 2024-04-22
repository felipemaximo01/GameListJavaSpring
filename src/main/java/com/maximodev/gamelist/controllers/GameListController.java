package com.maximodev.gamelist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maximodev.gamelist.dto.GameListDTO;
import com.maximodev.gamelist.dto.GameMinDTO;
import com.maximodev.gamelist.dto.ReplacementDTO;
import com.maximodev.gamelist.services.GameListService;
import com.maximodev.gamelist.services.GameService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void move(@PathVariable Long listId,@RequestBody ReplacementDTO body) {
        gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
    
    
}
