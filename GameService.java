package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.*; //to access Iterator interface

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	/*
	 * Holds the next Player identifier
	 */
	private static long nextPlayerId = 1;

	/*
	 * Holds the next Team identifier
	 */
	private static long nextTeamId = 1;

	/**The following singleton pattern ensures that there can only be one instance of
	the GameService class.*/

	//Private variable to track instances of GameService
	private static GameService service = null;

	//Private constructor prevents any attempts to instantiate another instance of GameService
	private GameService(){}

	/**
	* Check for existing instances of GameService.
	* @return the GameService instance (new or existing)
	*/
	public static GameService getInstance(){

		//Check if GameService exists
		if (service == null){
			//If none exist, create new and notify user
			service = new GameService();
			System.out.println("New Game Service created.");
		}
		else {
			//Notify user that GameService already exists
			System.out.println("Game Service already exists.");
		}
		//Return new instance, or existing
		return service;
	}


	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		/**Instantiate the iterator which grants access to Game members without sharing
		encapsulated data */
		Iterator<Game> gameIterator = games.iterator();

		//Iterate through the games list with the Boolean .hasNext()
		while (gameIterator.hasNext()){

			//Assign the next iteration element to the local Game variable
			Game gameInstance = gameIterator.next();

			//Check if game already exists (not case-sensitive)
			if (gameInstance.getName().equalsIgnoreCase(name)){
				//If game already exists, return the instance
				return gameInstance;
			}

		}

		// If game not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// Return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}

	/**
	 * Returns the game instance with the specified id.
	 *
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		/* Instantiate the iterator granting access to Game members without sharing
		 * encapsulated data.
		 */
		Iterator<Game> gameIterator= games.iterator();

		//Iterate through Games list using Boolean .hasNext()
		while (gameIterator.hasNext()){

			//Assign the next iteration element to the local Game variable
			Game gameInstance = gameIterator.next();

			//Check if the game already exists with the same id
			if (gameInstance.getId() == id ){
				//If the game id does exist, return the instance
				return gameInstance;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		/* Instantiate the iterator granting access to Game members without sharing
		 * encapsulated data.
		 */
		Iterator<Game> gameIterator = games.iterator();

		//Iterate through the list of games using Boolean .hasNext()
		while (gameIterator.hasNext()){

			//Assign the next iteration element to the local Game variable
			Game gameInstance = gameIterator.next();

			//Check if game already exists with the same name (not case-sensitive)
			if (gameInstance.getName().equalsIgnoreCase(name)){
				//If game name already exists, return instance
				game = gameInstance;
			}

		}

		return game;
	}



	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}

	/**
	 * Method to return the next player in the list, or the next players turn
	 * @return the next player to make a play
	 */
	public long getNextPlayerID() {
		return nextPlayerId++;
	}

	/**
	 * Method to return the next Team in the list, or the next Team to make a play
	 * @return the next Team to make a play
	 */
	public long getNextTeamId() {
		return nextTeamId++;
	}
}
