package com.dice.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.dice.application.dto.PlayerDTO;
import com.dice.utilities.NameRequiredException;

public class Player {

	private Integer id;
	private String name;
	private int wins = 0;
	private List<Game> resultGame = new ArrayList<Game>();// variable para guardar el resultado de las tiradas
	//private static final String ANONYMOUS = "Anonimo";
	
	private Calendar dataIn;

	public Player() {

	}

	public Player(PlayerDTO player) throws NameRequiredException {
		if (player == null || player.getName() == null)
			throw new NameRequiredException();
		
			this.name = player.getName();
			this.dataIn = Calendar.getInstance();
		
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	/*
	 * Metodo para ver el porcentaje de exito
	 */
	public double successRate() {
		if (resultGame.size() > 0)
			return (wins / (double) resultGame.size()) * 100;
		else
			return 0;
	}

	/*
	 * 
	 */
	public void addResultGame(Game resultGame) {
		if (resultGame.isWins())
			wins++;
		this.resultGame.add(resultGame);
	}

	/*
	 * metodo para
	 */
	public List<Game> getResultPlay() {
		return new ArrayList<>(resultGame);
	}

	public void setResultGame(List<Game> resultGame) {
		this.resultGame = resultGame;
	}

	/*
	 * metodo para eliminar el listado de Tiradas
	 */
	public void deleteGame() {
		this.resultGame = new ArrayList<Game>();
		// estevlinia permite limpiar o eliminar la lista de tiradas
		//this.resultGame.clear();
		
	}
	
	public Calendar getDateIn() {
		return dataIn;
	}

}
