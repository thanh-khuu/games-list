package com.thanhkhuu.gameslist.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

//Entity is a flag that tells SpringBoot I want to store this class in a Database
@Entity
public class Game {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, message = "Name must not be empty.")
    private String name;

    @NotNull
    @Size(min=1, message = "Description must not be empty.")
    private String description;

    @ManyToOne
    private GamePlatform platform;

    public Game(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Game() { }

    public int getId() {
        return id;
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

    public GamePlatform getPlatform() {
        return platform;
    }

    public void setPlatform(GamePlatform platform) {
        this.platform = platform;
    }
}
