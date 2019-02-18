package com.dice.domain;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	private Integer id;
	private boolean wins = true;
	private List<Dice> listDice = new ArrayList<Dice>();
	private List<Integer> listResult = new ArrayList<Integer>();
	private int winner = 0;
	
	public Game() {
		
	}
	
	public Game(Integer value) {
		for (int i = 0; i < value; i++) {
			listDice.add(new Dice());
		}
		
		for (Dice dice : listDice) {
			listResult.add(dice.getResult());
		}
		
	}
	
	public void addDiceValue(Integer value) {
        if (winner == 0 && (value == 5 || value == 6)) 
        	winner = value;
        else 
        	wins = wins && (value == winner);

        listResult.add(value);
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

	public List<Dice> getListDice() {
		return listDice;
	}

	public void setListtDice(List<Dice> resultDice) {
		this.listDice = resultDice;
	}
	
	public List<Integer> getListResult() {
		return listResult;
	}

	public void setListResult(List<Integer> listResult) {
		this.listResult = listResult;
	}
		
	
	

}
