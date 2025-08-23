package com.gabsprojeto.gamelist.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabsprojeto.gamelist.dto.GameListDto;
import com.gabsprojeto.gamelist.dto.GameMinDto;
import com.gabsprojeto.gamelist.entities.GameList;
import com.gabsprojeto.gamelist.repositories.GameListRepository2;


//registrando como um componente do sistema
@Service
public class GameListService {
	
	@Autowired //injetar/ o propio spring resolve 
	private GameListRepository2 gameListRepository;
	
	
	@Transactional(readOnly = true)
	public List<GameListDto> findAll() {
		List<GameList> result = gameListRepository.findAll();
		
		return result.stream().map(x -> new GameListDto(x)).toList();
		
	}

}