package com.dice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dice.application.dto.PlayerDTO;
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
		playerRepository.createPlayer(player);		
		return new PlayerDTO(player);		
	}
	
	
	/*
	 * players : modifica el nom del jugador
	 */	
	public PlayerDTO updatePlayer(int playerId, PlayerDTO editplayer) throws NotFoundException, InvalidParamException {
		Player player = playerRepository.getPlayerById(playerId);
		player.setName(editplayer.getName());
		playerRepository.createPlayer(player);
		return new PlayerDTO(player);
		
	}
	
	/*
	 * players/{id}/games/ : un jugador específic realitza una tirada dels daus.
	 */
	
	
	
	
	PlayerDTO getPlayer(int playerId) throws NotFoundException, InvalidParamException {
		Player player = playerRepository.getPlayerById(playerId);
		return new PlayerDTO(player);
	}
	

}
