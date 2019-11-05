package com.thanhkhuu.gameslist.models;

public enum GamePlatform {

    PlayStation_4 ("PlayStation 4"),
    Xbox_One ("Xbox One"),
    Nintendo_Switch ("Nintendo Switch");

    private final String name;

    GamePlatform(String name) {
        this.name=name;
    }

    public String getName() {
        return name;
    }

}
