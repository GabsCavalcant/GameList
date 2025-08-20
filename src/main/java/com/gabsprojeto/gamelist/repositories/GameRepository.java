package com.gabsprojeto.gamelist.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.gabsprojeto.gamelist.entities.Game;


//Operações Basicas com o framework JpaRepository
public interface GameRepository extends JpaRepository<Game, Long>{
	
	

}	
