package com.example.wertalp.battleship;

import java.util.List;

/**
 * Created by wertalp on 02.09.15.
 */
public class Player {
    Integer PlayerId;
    String  name   ;
    Integer punkte ;
    Integer highscore;
    List<Ship> ships;




    public Player(String name) {
        this.name = name;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }


    public Integer getPlayerId() {
        return PlayerId;
    }

    public void setPlayerId(Integer playerId) {
        PlayerId = playerId;
    }

    public Integer getPunkte() {
        return punkte;
    }

    public void setPunkte(Integer punkte) {
        this.punkte = punkte;
    }

    public Integer getHighscore() {
        return highscore;
    }

    public void setHighscore(Integer highscore) {
        this.highscore = highscore;
    }


    public void add_ship(Ship ship) {
        this.getShips().add(ship);

    }

    public void remove_ship(Ship ship) {
        this.getShips().remove(ship);

    }


}
