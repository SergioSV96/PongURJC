package com.mypong.game.gameobjects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Bar {
    private Vector2 position;
    private Vector2 velocity;

    private int width;
    private int height;
    private int screenHeight;
    private int screenWidth;
    private int velocityBar = 150;

    public Bar(int width, int height) {
        this.screenHeight = Gdx.graphics.getHeight();
        this.screenWidth = Gdx.graphics.getWidth();

        this.position = new Vector2(0, 0);
        this.velocity = new Vector2(0, 0);
        this.width = width;
        this.height = height;

        this.velocity.y = velocityBar;
        this.velocity.x = velocityBar;
        randomPosition();
    }

    public void update(float delta) {

        if(this.position.x <= 0 || this.position.x + this.getWidth() >= this.screenWidth){
            this.velocity.x = - this.velocity.x;
        }

        if(this.position.y <= 0 || this.position.y + this.getHeight() >= this.screenHeight){
            this.velocity.y = - this.velocity.y;
        }

        position.add(velocity.cpy().scl(delta));
    }

    public void collisionX(){
        this.velocity.x = - this.velocity.x;
    }

    public void collisionY(){
        this.velocity.y = - this.velocity.y;
    }

    public void randomPosition(){
        this.position.y = randomNumber((int)this.getHeight(), this.screenHeight);
        this.position.x = randomNumber((int)this.getWidth(), this.screenWidth);
    }

    public float getX() {
        return position.x;
    }

    public float getY() {return position.y; }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Rectangle getRectangle(){ return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight()); }

    public static int randomNumber(int min,int max) {return (int)Math.floor(Math.random()*(max-min+1)); }

}
