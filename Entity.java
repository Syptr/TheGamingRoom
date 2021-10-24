package com.gamingroom;

/**Super/Parent class that extends attributes and methods to the Game, Team, and Player classes */

public class Entity {

    //Private attributes
    private long id;
    private String name;

    //Private default constructor
    private Entity(){}

    //Custom constructor for id and name parameters
    public Entity(long id, String name) {
        this(); //Calls the default constructor
        this.id = id;
        this.name = name;
    }

    //Accessor
    public long getId(){
        return id;
    }

    //Accessor
    public String getName() {
        return name;
    }

    //String to print information to user
    public String toString() {
        return "Entity [id = " + id + "name = " + name + "]";
    }

}
