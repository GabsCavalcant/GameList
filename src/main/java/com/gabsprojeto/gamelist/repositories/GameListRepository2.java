package com.gabsprojeto.gamelist.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gabsprojeto.gamelist.entities.Game;
import com.gabsprojeto.gamelist.entities.GameList;


//Operações Basicas com o framework JpaRepository
public interface GameListRepository2 extends JpaRepository<GameList, Long>{
	
	

}	
