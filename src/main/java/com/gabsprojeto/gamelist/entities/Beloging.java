package com.gabsprojeto.gamelist.entities;

import java.util.Objects;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_belonging")
public class Beloging {


		@EmbeddedId
		private BelogingPk id = new BelogingPk();
		
		private Integer position;
		
		public Beloging() {
			
		}

		public Beloging(Game game,GameList gameList, Integer position) {
			
			id.setGame(game);
			id.setGameList(gameList);
			this.position = position;
		}

		public BelogingPk getId() {
			return id;
		}

		public void setId(BelogingPk id) {
			this.id = id;
		}

		public Integer getPosition() {
			return position;
		}

		public void setPosition(Integer position) {
			this.position = position;
		}

		@Override
		public int hashCode() {
			return Objects.hash(id, position);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Beloging other = (Beloging) obj;
			return Objects.equals(id, other.id) && Objects.equals(position, other.position);
		}
		
		
}
