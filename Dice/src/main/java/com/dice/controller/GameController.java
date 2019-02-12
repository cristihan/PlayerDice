package com.dice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dice.application.dto.GameDTO;
import com.dice.domain.Game;
import com.dice.domain.Player;
import com.dice.persistence.PlayerRepository;
import com.dice.utilities.InvalidParamException;
import com.dice.utilities.NotFoundException;

@Controller
public class GameController {

	@Autowired
	private PlayerRepository playerRepository;
	@Autowired
	private PlayerController playerController;

	/*
	 * Creo el juego con la id del jugador en el momento en que el jugador realiza
	 * la tirada un jugador específic realitza una tirada dels daus.
	 */
	public GameDTO createGame(int playerId, int numberDice) throws NotFoundException, InvalidParamException {
		Player player = playerRepository.getPlayerById(playerId);
		// Player player1 = playerController.getPlayer(playerId);
		Game game = new Game(numberDice);
		playerRepository.createGame(game);

		playerRepository.createPlayer(player);

		return new GameDTO(game);

	}

}
