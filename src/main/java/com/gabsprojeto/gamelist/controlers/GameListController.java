package com.gabsprojeto.gamelist.controlers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabsprojeto.gamelist.dto.GameListDto;
import com.gabsprojeto.gamelist.dto.GameMinDto;
import com.gabsprojeto.gamelist.entities.Game;
import com.gabsprojeto.gamelist.services.GameListService;
import com.gabsprojeto.gamelist.services.GameService;

@RestController
@RequestMapping(value ="/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	
	@GetMapping
	public List<GameListDto> findAll(){
		List<GameListDto> resultado = gameListService.findAll();

		return resultado;
		
	}
	@GetMapping(value = "/{listId}/games")
	public List<GameMinDto> findByList(@PathVariable Long listId){
		List<GameMinDto> dto = gameService.findByList(listId);
		return dto;
	}
}
