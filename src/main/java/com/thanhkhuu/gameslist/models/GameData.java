package com.thanhkhuu.gameslist.models;

import java.util.ArrayList;

public class GameData {

    //stores list of "Game" objects in array list called "gamesList"
    static ArrayList<Game> gamesList = new ArrayList<>();

    // getAll
    public static ArrayList<Game> getAll() {
        return gamesList;
    }

    // add
    public static void add(Game newGame) {
        gamesList.add(newGame);
    }

    // remove
    public static void remove(int id) {
        Game gameToRemove = getById(id);
        gamesList.remove(gameToRemove);
    }

    // getById
    public static Game getById(int id) {

        Game theGame = null;

        for (Game candidateGame : gamesList) {
            if (candidateGame.getGameId() == id) {
                theGame = candidateGame;
            }
        }

        return theGame;
    }
}
