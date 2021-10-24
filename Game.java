package com.gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {

	/** Creates a list of active teams */
	private static List<Team> teams = new ArrayList<Team>();

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		//Calls to the parent class Entity for assignment of id and name
		super(id, name);
	}

	/**
	 * Construct a new team if team does not already exist
	 * @param name
	 * @return Team instance
	 */
	public Team addTeam(String name) {

		//a local Team instance
		Team team = null;

		/**Instantiate the iterator pattern to access Team members without sharing encapsulated data */
		Iterator<Team> teamIterator = teams.iterator();

		//Iterate through the Teams list using Boolean .hasNext()
		while (teamIterator.hasNext()) {

			//Assign next iteration element to the local Team variable
			Team teamInstance = teamIterator.next();

			//Check if team name already exists
			if (teamInstance.getName().equalsIgnoreCase(name)) {
				//If team name already exists , return instance
				return teamInstance;
			}
		}
		//If team does not exist add it to the list
		team = new Team(GameService.getInstance().getNextPlayerId(),name);
		teams.add(team);

		return team;
	}

	@Override
	public String toString() {
		return "Game [id= " + super.getId() + ", name= " + super.getName() + "]";
	}

}
