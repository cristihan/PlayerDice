package com.dice.api;

import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dice.application.dto.PlayerDTO;
import com.dice.controller.PlayerController;
import com.dice.utilities.InvalidParamException;
import com.dice.utilities.NotFoundException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@CrossOrigin
public class PlayerRestController {
	
	@Autowired
	private PlayerController controller;
	
	private String toJson(Object object) {
		Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
		return gson.toJson(object);
				
	}
	
	//POST: /players : crea un jugador
	 @PostMapping(value = "/players", produces = "application/json;charset=UTF-8")
	 public String createPlayer(@RequestBody String jPlayer) throws Exception {
		 PlayerDTO newPlayer = new Gson().fromJson(jPlayer, PlayerDTO.class);
		 PlayerDTO player = controller.createPlayer(newPlayer);
		 return toJson(player);
	 }
	 
	 //PUT /players : modifica el nom del jugador
	 @PutMapping(value = "/players/{playerId}", produces = "application/json;charset=UTF-8")
	 public String UpdatePlayer(@PathVariable int playerId, @RequestBody String jPlayer) throws NotFoundException, InvalidParamException {
		 PlayerDTO playerToUpdate = new Gson().fromJson(jPlayer, PlayerDTO.class);
		 PlayerDTO player = controller.updatePlayer(playerId, playerToUpdate);
		return toJson(player);
		 
	 }
	 
	 //DELETE /players/{id} elimina el jugador. 
	 @DeleteMapping(value = "/players/{playerId}", produces = "application/json;charset=UTF-8")
	 public void removePlayer(@PathVariable int playerId) throws NotFoundException {
		 controller.deletePlayer(playerId);
		 
	 }
	 
	 //GET /players/: retorna el llistat de tots els jugadors del sistema amb el seu percentatge mig d’èxits 
	 @GetMapping(value = "/players", produces = "application/json;charset=UTF-8")
	 public String getPlayerWithSuccessRate() throws NotFoundException, InvalidParamException {
		 List<PlayerDTO> players = controller.getAllPlayers();
		 return toJson(players);
	 }
	 
	 // GET /players/ranking: retorna el ranking mig de tots els jugadors del sistema. És a dir, el percentatge mig d’èxits. 
	 @GetMapping(value = "/players/ranking", produces = "application/json;charset=UTF-8")
	 public String getRanking() throws NotFoundException, JSONException {
		 double ranking = controller.getSuccessRateAllPlayer();
		 JSONObject json= new JSONObject();
		 json.put("ranking", ranking);
		
		 return json.toString();
	 }
	 
	 //GET /players/ranking/loser: retorna el jugador amb pitjor percentatge d’èxit.
	 @GetMapping(value = "/players/ranking/loser", produces = "application/json;charset=UTF-8")
	 public String getrankingLoser() throws NotFoundException, InvalidParamException, JSONException {
		 PlayerDTO player = controller.getWorstPlayerSuccessRate();
		 return toJson(player);

	 }
	 
	 //GET /players/ranking/winner: retorna el jugador amb pitjor percentatge d’èxit.
	 @GetMapping(value = "/players/ranking/winner", produces = "application/json;charset=UTF-8")
	    public String getRankingWinner() throws NotFoundException, InvalidParamException, JSONException {
		 PlayerDTO player = controller.getBestPlayerSuccessRate();
		 return toJson(player);
	 }
	

}
