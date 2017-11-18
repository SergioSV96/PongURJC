package com.mypong.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public class Bar {
    private Vector2 position;
    private Vector2 velocity;

    private int width;
    private int height;
    private int screenHeight;
    private int screenWidth;

    public Bar(int x, int y, int width, int height, int velocityBar) {
        this.screenHeight = Gdx.graphics.getHeight();
        this.screenWidth = Gdx.graphics.getWidth();

        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);

        this.width = width;
        this.height = height;

        this.velocity.y = 0;
        this.velocity.x = 0;
    }

    public void onRelease(){
        this.velocity.y = 0;
        this.velocity.x = 0;
    }

    public void setPosition(Vector2 position) {
        this.position = position;
    }

    public void setX(int x) {
        this.position.x = x;
    }

    public void setY(int y) {
        this.position.y = y;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {return position.y; }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Rectangle getRectangle(){ return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight()); }

    public static int randomNumber(int min,int max) {return (int)Math.floor(Math.random()*(max-min+1)); }

}
