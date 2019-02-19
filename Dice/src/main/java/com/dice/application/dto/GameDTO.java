package com.dice.application.dto;

import java.util.ArrayList;
import java.util.List;

import com.dice.domain.Dice;
import com.dice.domain.Game;
import com.dice.utilities.InvalidParamException;
import com.google.gson.annotations.Expose;

public class GameDTO {
	
	@Expose
	private Integer id;
	@Expose
	private boolean hasWon;
	private List<Dice> listDice = new ArrayList<Dice>();
	@Expose
	private List<Integer> listResult = new ArrayList<Integer>();	
	
	public GameDTO() {
		
	}
	
	public GameDTO(Game game) throws InvalidParamException {
		if(game == null)
			throw new InvalidParamException();
		
		this.id = game.getId();
		this.hasWon = game.hasWon();
		this.listDice = game.getListDice();
		this.listResult = game.getListResult();
	}

	public Integer getId() {
		return id;
	}

	public boolean hasWon() {
		return hasWon;
	}

	public List<Dice> getListDice() {
		return listDice;
	}

	public List<Integer> getListResult() {
		return listResult;
	}
	
	

}
