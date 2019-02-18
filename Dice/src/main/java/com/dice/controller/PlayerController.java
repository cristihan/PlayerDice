package com.dice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dice.application.dto.PlayerDTO;
import com.dice.domain.Game;
import com.dice.domain.Player;
import com.dice.persistence.PlayerRepository;
import com.dice.utilities.InvalidParamException;
import com.dice.utilities.NameRequiredException;
import com.dice.utilities.NotFoundException;

@Controller
public class PlayerController {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	/*
	 * players : crea un jugador
	 */
	public PlayerDTO createPlayer(PlayerDTO playerDTO) throws NameRequiredException, InvalidParamException {
		Player player = new Player(playerDTO);
		playerRepository.savePlayer(player);		
		return new PlayerDTO(player);		
	}

	
	/*
	 * players : modifica el nom del jugador
	 */	
	public PlayerDTO updatePlayer(int playerId, PlayerDTO editplayer) throws NotFoundException, InvalidParamException {
		Player player = playerRepository.getPlayerById(playerId);
		player.setName(editplayer.getName());
		playerRepository.savePlayer(player);
		return new PlayerDTO(player);
		
	}
	
	
	/*
	 * players/{id} elimina el jugador. 
	 */
	public void deletePlayer(int playerId) throws NotFoundException {
		playerRepository.deletePlayer(playerId);
	}
	
	/*
	 * players/: retorna el llistat de tots els jugadors del 
	 * sistema amb el seu percentatge mig d’èxits 
	 */
	public List<PlayerDTO> getAllPlayers() throws NotFoundException, InvalidParamException{
		List<PlayerDTO> playerDTOList = new ArrayList<>();
		List<Player> playerList = playerRepository.getAllPlayer();
		if(playerList.isEmpty())//la lista no deberia estar vacia
			throw new NotFoundException();
		for (Player player : playerList) {
			playerDTOList.add(new PlayerDTO(player));
		}
		return playerDTOList;
	}
	
	/*
	 * /players/ranking: retorna el ranking mig de tots els jugadors
	 *  del sistema. És a dir, el percentatge mig d’èxits. 
	 */
	public double getSuccessRateAllPlayer() throws NotFoundException {
		double successRate = 0;
		List<Player> playerList = playerRepository.getAllPlayer();
		if(playerList.isEmpty())//la lista no deberia estar vacia
			throw new NotFoundException();
		for (Player player : playerList) {
			successRate = successRate + player.successRate();
		}
		return successRate/playerRepository.getAllPlayer().size();
	}
	
	/*
	 * players/ranking/loser: retorna el jugador amb pitjor percentatge d’èxit.
	 */
	public PlayerDTO getWorstPlayerSuccessRate() throws NotFoundException, InvalidParamException {
		Player player = null;
		List<Player> playerList = playerRepository.getAllPlayer();
		if (playerList.isEmpty())
			throw new NotFoundException();
		for (Player p : playerList) {
			if (player == null || player.successRate() > p.successRate())
				player = p;
		}
		return new PlayerDTO(player);
	}
	
	/*
	 * /players/ranking/winner: retorna el jugador amb mitjor percentatge d’èxit.
	 */
	public PlayerDTO getBestPlayerSuccessRate() throws NotFoundException, InvalidParamException {
		Player player = null;
		List<Player> playerList = playerRepository.getAllPlayer();
		if(playerList.isEmpty())
			throw new NotFoundException();
		for (Player p : playerList) {
			if(player == null || player.successRate() < p.successRate())
				player = p;
		}		
		return new PlayerDTO(player);
	}
	
	
	Player getPlayerId(int playerId) throws NotFoundException, InvalidParamException {
		Player player = playerRepository.getPlayerById(playerId);
		return player;
	}
	

}
