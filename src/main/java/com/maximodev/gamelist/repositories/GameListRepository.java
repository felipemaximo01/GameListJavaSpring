package com.maximodev.gamelist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.maximodev.gamelist.entities.GameList;

@Repository
public interface GameListRepository extends JpaRepository<GameList,Long>{

    
}