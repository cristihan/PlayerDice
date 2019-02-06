package com.dice.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private Integer id;
	private boolean wins = true;
	private List<Dice> resultDice = new ArrayList<Dice>();
	
	public Game() {
		
	}
	
	public Game(Integer value) {
		for (int i = 0; i < value; i++) {
			resultDice.add(new Dice());
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isWins() {
		return wins;
	}

	public void setWins(boolean wins) {
		this.wins = wins;
	}

	public List<Dice> getResultDice() {
		return resultDice;
	}

	public void setResultDice(List<Dice> resultDice) {
		this.resultDice = resultDice;
	}
	
	
		
	
	

}
