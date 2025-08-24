package com.gabsprojeto.gamelist.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gabsprojeto.gamelist.dto.GameListDto;
import com.gabsprojeto.gamelist.entities.GameList;
import com.gabsprojeto.gamelist.projection.GameMinProjection;
import com.gabsprojeto.gamelist.repositories.GameListRepository2;
import com.gabsprojeto.gamelist.repositories.GameRepository;


//registrando como um componente do sistema
@Service
public class GameListService {
	
	@Autowired //injetar/ o propio spring resolve 
	private GameListRepository2 gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDto> findAll() {
		List<GameList> result = gameListRepository.findAll();
		
		return result.stream().map(x -> new GameListDto(x)).toList();
		
	}
	@Transactional
	public void move(Long listId, int sourceIndex, int destination) {
		
		List<GameMinProjection> list = gameRepository.searchByList(listId);
		
		GameMinProjection obj = list.remove(sourceIndex);
		list.add(destination, obj);
		
		int min = sourceIndex < destination ? sourceIndex : destination;
		int max = sourceIndex < destination ? destination : sourceIndex;
		
		for( int i = min; i <= max; i++) {
			
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
			
		}

	}
}