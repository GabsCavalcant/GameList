package com.gabsprojeto.gamelist.dto;

import com.gabsprojeto.gamelist.entities.GameList;

public class GameListDto {
	private long id;
	private String name;
		
		public GameListDto() {
			
		}

		public GameListDto(GameList list) {
			id = list.getId();
			name = list.getName();
		}

		public long getId() {
			return id;
		}

		public String getName() {
			return name;
		}
		
		
}
