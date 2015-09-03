package com.example.wertalp.battleship;

/**
 * Created by wertalp on 31.08.15.
 */
import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.shapes.Shape;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageButton;

/**
 * Created by wertalp on 26.08.15.
 */
public class Ship {
    Integer shipId ;
    Context ctx;
    Button button;
    String name;
    Point position;
    Shape  shape;
    Integer hSpan = 1;
    Integer vSpan = 1;
    GridLayout board ;
    Drawable picture ;

    public Ship(Button button, String name, Point position, Shape shape,Integer id) {
        this.button   = button   ;
        this.name     = name     ;
        this.position = position ;
        this.shipId   = id       ;
        //this.shape    = shape;
    }

    public Ship(Button button,  Point position) {
        this.button    = button   ;
        this.position  = position ;

    }


    public Ship() {

    }
    public Ship(GridLayout board)
    {
        this.board = board;
    }

    public void add_ship_to_view(Button but,Drawable shippicture){

        but.setBackground(shippicture);
    }


    public Point getPosition() {
        return position;
    }

    public void setPosition(Point position) {
        this.position = position;
    }

    public Integer getShipId() {
        return shipId;
    }

    public void setShipId(Integer shipId) {
        this.shipId = shipId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Drawable getPicture() {
        return picture;
    }

    public void setPicture(Drawable picture) {
        this.picture = picture;
    }
}
// new Ship.