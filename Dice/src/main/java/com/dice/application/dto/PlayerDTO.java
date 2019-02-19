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
	private List<Game> resultGame = new ArrayList<Game>();
	
	private Calendar dataIn;
	
	public PlayerDTO() {
		
	}
	
	public PlayerDTO(Player player) throws InvalidParamException {
		if(player == null)
			throw new InvalidParamException();
		
		this.id = player.getId();
		this.name = player.getName();
		this.succesRate = player.successRate();
		this.resultGame = player.getListPlayGame();
		this.dataIn = player.getDateIn();
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

	public List<Game> getResultGame() {
		return resultGame;
	}

	public Calendar getDataIn() {
		return dataIn;
	}
	
	
	

}
