package com.dice.controller;

import java.util.ArrayList;
import java.util.List;

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
		Game game = new Game(numberDice);
		player.addGame(game);
		playerRepository.savePlayer(player);

		return new GameDTO(game);
	}

	/*
	 * /players/{id}/games: elimina les tirades del jugador.
	 */
	public void deleteGamesPlayer(int playerId) throws NotFoundException, InvalidParamException {
		Player player = playerController.getPlayerId(playerId);
		player.deleteGame();	
		player.successRate();

		playerRepository.savePlayer(player);

	}

	/*
	 * players/{id}/games:retorna el llistat de jugades per un jugador.
	 */
	public List<GameDTO> getAllGamesByPlayer(int playerId) throws NotFoundException, InvalidParamException {
		List<GameDTO> gameDTOList = new ArrayList<>();
		Player player = playerRepository.getPlayerById(playerId);
		for (Game game : player.getListPlayGame()) {
			// GameDTO gameDTO = new GameDTO(game);
			// gameDTOList.add(gameDTO);
			gameDTOList.add(new GameDTO(game));
		}
		return gameDTOList;

	}

}
