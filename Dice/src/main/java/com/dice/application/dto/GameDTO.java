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
	private List<DiceDTO> listDice = new ArrayList<DiceDTO>(); //DTO!
	
	//@Expose
	//private String diceResults;
	@Expose
	private List<Integer> listResult = new ArrayList<Integer>();	
	
	public GameDTO() {
		
	}
	
	public GameDTO(Game game) throws InvalidParamException {
		if(game == null)
			throw new InvalidParamException();
		
		this.id = game.getId();
		this.hasWon = game.hasWon();
		this.listDice = convertToDTO(game.getListDice());
		this.listResult = game.getListResult();
		//this.diceResults = game.getListResult().toString();
	}
	
	private List<DiceDTO> convertToDTO(List<Dice> dice) throws InvalidParamException{
		List<DiceDTO> result = new ArrayList<>();
		for (Dice d : dice) {
			result.add(new DiceDTO(d));
		}
		return result;
	}

	public Integer getId() {
		return id;
	}

	public boolean hasWon() {
		return hasWon;
	}

	public List<DiceDTO> getListDice() {
		return listDice;
	}

	public List<Integer> getListResult() {
		return listResult;
	}

//	public String getDiceResults() {
//		return diceResults;
//	}
	

}
