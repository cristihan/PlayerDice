package com.dice.application.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.dice.domain.Game;
import com.dice.domain.Player;
import com.dice.utilities.InvalidParamException;
import com.google.gson.annotations.Expose;

public class PlayerDTO {
	
	@Expose
	private int id;
	@Expose
	private String name;
	@Expose
	private double succesRate;
	@Expose
	private List<GameDTO> resultGame = new ArrayList<GameDTO>();
	@Expose
	private Calendar dataIn;
	
	public PlayerDTO() {
		
	}
	
	public PlayerDTO(Player player) throws InvalidParamException {
		if(player == null)
			throw new InvalidParamException();
		
		this.id = player.getId();
		this.name = player.getName();
		this.succesRate = player.successRate();
		this.resultGame = convertToDTO(player.getListPlayGame());
		this.dataIn = player.getDateIn();
	}
	
	private List<GameDTO> convertToDTO(List<Game> resultGame) throws InvalidParamException{
		List<GameDTO> result = new ArrayList<>();
		for (Game game : resultGame) {
			result.add(new GameDTO(game));
		}
		return result;
	}
	
	
	public int getId() {
		return id;
	}

	public String getName() {
		if(name == null || name.equals(""))
			return "Anonimo";
		return name;
	}	

	public double getWins() {
		return succesRate;
	}

	public List<GameDTO> getResultGame() {
		return resultGame;
	}

	public Calendar getDataIn() {
		return dataIn;
	}
	
	
	

}
