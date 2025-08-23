package com.gabsprojeto.gamelist.controlers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gabsprojeto.gamelist.dto.GameDto;
import com.gabsprojeto.gamelist.dto.GameMinDto;
import com.gabsprojeto.gamelist.services.GameService;

@RestController
@RequestMapping(value ="/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping(value = "/{id}") 
	public GameDto findById(@PathVariable Long id){
		GameDto result =  gameService.findById(id);
		return result;
		
	}
	
	
	
	@GetMapping
	public List<GameMinDto> findAll(){
		List<GameMinDto> resultado = gameService.findAll();

		return resultado;
		
	}

}
