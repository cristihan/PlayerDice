package com.dice.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name ="Game")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="game_id")
	private Integer id;
	@Column(name="hasWon")
	private boolean hasWon = true;
	
	@Embedded
	private List<Dice> listDice = new ArrayList<Dice>();



	public Game() {

	}

	public Game(Integer value) {
		for (int i = 0; i < value; i++) {
			listDice.add(new Dice());
		}
	}

	public List<Integer> getListResult() {
		List<Integer> results = new ArrayList<>();
		for (Dice dice : listDice) {
			results.add(dice.getResult());
		}
		return results;
	}

	public void addDice(Integer value) {
		for (int i = 0; i < value; i++) {
			listDice.add(new Dice());
		}
	}

	public Integer getId() {
		return id;
	}
	
	public boolean playGame() {
		for (Dice dice : listDice)
		dice.rollDice();		
		return hasWon();
	}

	public boolean hasWon() {
		return hasAllDiceSameValue(5) || hasAllDiceSameValue(6);
	}

	public boolean hasAllDiceSameValue(int value) {
		for (Dice dice : listDice) {
			if (dice.getResult() != value) {
				return false;
			}
		}
		return true;
	}

	public boolean isWins() {
		return hasWon;
	}

	public List<Dice> getListDice() {
		return listDice;
	}

}
