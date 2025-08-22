package com.gabsprojeto.gamelist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class BelogingPk {
	
	@ManyToOne
	@JoinColumn(name="game_id")
	Game Game;
	
	@ManyToOne
	@JoinColumn(name="list_id")
	GameList GameList;
	
	public BelogingPk() {
		
	}

	public BelogingPk(com.gabsprojeto.gamelist.entities.Game game,
			com.gabsprojeto.gamelist.entities.GameList gameList) {
		
		Game = game;
		GameList = gameList;
	}

	public Game getGame() {
		return Game;
	}

	public void setGame(Game game) {
		Game = game;
	}

	public GameList getGameList() {
		return GameList;
	}

	public void setGameList(GameList gameList) {
		GameList = gameList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Game, GameList);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelogingPk other = (BelogingPk) obj;
		return Objects.equals(Game, other.Game) && Objects.equals(GameList, other.GameList);
	}
	
}
