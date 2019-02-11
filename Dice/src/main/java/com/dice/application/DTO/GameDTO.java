package com.dice.application.DTO;

import java.util.ArrayList;
import java.util.List;

import com.dice.domain.Dice;
import com.dice.domain.Game;
import com.dice.utilities.InvalidParamException;

public class GameDTO {
	
	private Integer id;
	private boolean wins = true;
	private List<Dice> listDice = new ArrayList<Dice>();
	private List<Integer> listResult = new ArrayList<Integer>();	
	
	public GameDTO() {
		
	}
	
	public GameDTO(Game game) throws InvalidParamException {
		if(game == null)
			throw new InvalidParamException();
		
		this.id = game.getId();
		this.wins = game.isWins();
		this.listDice = game.getListDice();
		this.listResult = game.getListResult();
	}

	public Integer getId() {
		return id;
	}

	public boolean isWins() {
		return wins;
	}

	public List<Dice> getListDice() {
		return listDice;
	}

	public List<Integer> getListResult() {
		return listResult;
	}
	
	

}
