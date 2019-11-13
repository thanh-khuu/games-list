package com.thanhkhuu.gameslist.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GamePlatform {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=1, message = "Name must not be empty.")
    private String name;

    @OneToMany
    @JoinColumn(name = "platform_id")
    private List<Game> games = new ArrayList<>();

    public GamePlatform() {}

    public GamePlatform(String name) {this.name = name;}

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Game> getGames() {
        return games;
    }

}
