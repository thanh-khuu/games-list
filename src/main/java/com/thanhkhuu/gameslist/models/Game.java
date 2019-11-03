package com.thanhkhuu.gameslist.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Game {

    @NotNull
    @Size(min=3, message = "Name must not be empty.")
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty.")
    private String description;


    private int gameId;
    private static int nextId = 1;

    public Game(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }

    public Game() {
        gameId = nextId;
        nextId++;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
