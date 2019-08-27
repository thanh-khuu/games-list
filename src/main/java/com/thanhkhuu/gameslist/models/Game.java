package com.thanhkhuu.gameslist.models;

public class Game {
    private String name;
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
