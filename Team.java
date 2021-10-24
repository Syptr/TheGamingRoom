package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {

	/** Create an active list of players */
	private static List<Player> players = new ArrayList<Player>();

	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		//Calls to parent class Entity for assignment of id and name
		super(id, name);
	}

	/**
	 * Construct a new player instance if player does not already exist
	 * @param name the unique name of the player
	 * @return the player name instance (new or existing
	 */
	public Player addPlayer(String name){

		//a local player instance
		Player player = null;

		/**Instantiate the iterator granting access to the Team members without sharing encapsulated data */
		Iterator<Player> playerIterator = players.iterator();

		//Iterate through the player list with Boolean .hasNext()
		while (playerIterator.hasNext()) {

			//Assign the next player iteration element with the local Player variable
			Player playerInstance = playerIterator.next();

			//Check if player already exists (not case-sensitive)
			if (playerInstance.getName().equalsIgnoreCase(name)) {
				//If player already exists, return the player instance
				return playerInstance;
			}

		}
			//If player does not exist, add it to the list
			player = new Player(GameService.getInstance().getNextPlayerId(), name);
			players.add(player);

		return player;
	}

	@Override
	public String toString() {
		return "Team [id= " + super.getId() + ", name= " + super.getName() + "]";
	}
}
