package com.dice.application.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.dice.domain.Game;
import com.dice.domain.Player;
import com.dice.utilities.InvalidParamException;

public class PlayerDTO {
	
	private int id;
	private String name;
	private double wins;
	private List<Game> resultGame = new ArrayList<Game>();

	private Calendar dataIn;
	
	public PlayerDTO() {
		
	}
	
	public PlayerDTO(Player player) throws InvalidParamException {
		if(player == null)
			throw new InvalidParamException();
		
		this.id = player.getId();
		this.name = player.getName();
		this.wins = player.getWins();
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
		return wins;
	}

	public List<Game> getResultGame() {
		return resultGame;
	}

	public Calendar getDataIn() {
		return dataIn;
	}
	
	
	

}
