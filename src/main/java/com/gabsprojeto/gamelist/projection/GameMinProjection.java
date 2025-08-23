package com.gabsprojeto.gamelist.projection;

public interface GameMinProjection {
	
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShort_description();
	Integer getPosition();

}
