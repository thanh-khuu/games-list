package com.thanhkhuu.gameslist.models.forms;

import com.thanhkhuu.gameslist.models.Game;
import com.thanhkhuu.gameslist.models.Genre;

import javax.validation.constraints.NotNull;

public class AddGenreTitleForm {

    @NotNull
    private int genreId;

    @NotNull
    private int gameId;

    private Genre genre;

    private Iterable<Game> games;

    public AddGenreTitleForm() {}

    public AddGenreTitleForm(Iterable<Game> games, Genre genre) {
        this.games = games;
        this.genre = genre;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public Genre getGenre() {
        return genre;
    }

    public Iterable<Game> getGames() {
        return games;
    }
}
