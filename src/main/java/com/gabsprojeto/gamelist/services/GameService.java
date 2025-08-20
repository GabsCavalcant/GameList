package com.gabsprojeto.gamelist.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabsprojeto.gamelist.dto.GameMinDto;
import com.gabsprojeto.gamelist.entities.Game;
import com.gabsprojeto.gamelist.repositories.GameRepository;


//registrando como um componente do sistema
@Service
public class GameService {
	
	@Autowired //injetar/ o propio spring resolve 
	private GameRepository gameRepository;
	

	public List<GameMinDto> findAll(){
		List<Game> resultado = gameRepository.findAll();
		List<GameMinDto> dto = resultado.stream().map(x -> new GameMinDto(x)).toList();

		return dto;
}
}