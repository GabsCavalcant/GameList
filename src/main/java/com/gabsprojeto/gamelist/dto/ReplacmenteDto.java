package com.gabsprojeto.gamelist.dto;

public class ReplacmenteDto {
	private Integer sourceIndex;
	private Integer destination;
	
	
	
	public ReplacmenteDto(Integer sourceIndex, Integer destination) {
		
		this.sourceIndex = sourceIndex;
		this.destination = destination;
	}
	public Integer getSourceIndex()
	{
		return sourceIndex;
	}
	public void setSourceIndex(Integer sourceIndex) {
		this.sourceIndex = sourceIndex;
	}
	public Integer getDestination() {
		return destination;
	}
	public void setDestination(Integer destination) {
		this.destination = destination;
	}
	
	

}
