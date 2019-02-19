package com.dice.domain;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.dice.application.dto.PlayerDTO;
import com.dice.utilities.NameRequiredException;

@Entity(name ="Player")
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="playerId")
	private Integer id;
	@Column(name="name")
	private String name;
	@Column(name="hasWon")
	private double hasWon;
	
	@OneToMany(targetEntity = Game.class)
	@JoinColumn(name = "game_id")
	private List<Game> listPlayGame = new ArrayList<Game>();// variable para guardar el resultado de las tiradas
	
	
	//private Calendar dataIn;

	public Player() {

	}

	public Player(PlayerDTO player) throws NameRequiredException {
		if (player == null || player.getName() == null)
			throw new NameRequiredException();
		
			this.name = player.getName();
			this.hasWon = 0;
		//	this.dataIn = Calendar.getInstance();
		
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
		return hasWon;
	}

	/*
	 * Metodo para ver el porcentaje de exito
	 */
	public double successRate() {
		double success = 0;
		for (Game game : listPlayGame) {
			if (game.hasWon())
			++success;				
		}
		if (listPlayGame.size() > 0)
			return (success*100) / listPlayGame.size();
			//return (wins / (double) listPlayGame.size()) * 100;
		else
			return 0.00;
	}

	/*
	 * metodo para añadir una tirada del juego
	 */
	public void addGame(Game playGame) {
		if (playGame.isWins())
			hasWon++;
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
		return null;//dataIn;
	}

}
