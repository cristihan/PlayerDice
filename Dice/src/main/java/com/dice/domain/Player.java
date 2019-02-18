package com.dice.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.dice.application.dto.PlayerDTO;
import com.dice.utilities.NameRequiredException;

public class Player {

	private Integer id;
	private String name;
	private double wins;
	private List<Game> listPlayGame = new ArrayList<Game>();// variable para guardar el resultado de las tiradas
	//private static final String ANONYMOUS = "Anonimo";
	
	private Calendar dataIn;

	public Player() {

	}

	public Player(PlayerDTO player) throws NameRequiredException {
		if (player == null || player.getName() == null)
			throw new NameRequiredException();
		
			this.name = player.getName();
			this.wins = 0;
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

	public double getWins() {
		return wins;
	}

	/*
	 * Metodo para ver el porcentaje de exito
	 */
	public double successRate() {
		if (listPlayGame.size() > 0)
			return (wins / (double) listPlayGame.size()) * 100;
		else
			return 0.00;
	}

	/*
	 * metodo para añadir una tirada al juego
	 */
	public void addGame(Game playGame) {
		if (playGame.isWins())
			wins++;
		this.listPlayGame.add(playGame);
	}

	/*
	 * muestra la lista de tiradas por el jugador
	 */
	public List<Game> getListPlayGame() {
		return new ArrayList<>(listPlayGame);
	}

	public void setListPlayGame(List<Game> listPlayGame) {
		this.listPlayGame = listPlayGame;
	}

	/*
	 * metodo para eliminar el listado de Tiradas
	 */
	public void deleteGame() {
		this.listPlayGame = new ArrayList<Game>();
		// esta linia permite limpiar o eliminar la lista de tiradas
		//this.resultGame.clear();
		
	}
	
	public Calendar getDateIn() {
		return dataIn;
	}

}
