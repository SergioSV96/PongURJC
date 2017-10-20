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
    private LinkedList<Bar> bars;
    private int velocityBar;

    public Bar(int width, int height, int velocityBar, LinkedList<Bar> bars) {
        this.screenHeight = Gdx.graphics.getHeight();
        this.screenWidth = Gdx.graphics.getWidth();

        this.bars = bars;

        this.position = new Vector2(0, 0);
        this.velocity = new Vector2(0, 0);
        this.velocityBar = velocityBar;

        if(randomNumber(0, 1) == 0){
            this.width = width;
            this.height = height;
        } else {
            this.width = height;
            this.height = width;
        }

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

    public Rectangle newPositionCollisionX(float delta){
        Vector2 newPosition = new Vector2(position.x, position.y);
        Vector2 newVelocity = new Vector2(-velocity.x, velocity.y);

        newPosition.add(newVelocity.cpy().scl(delta));
        return new Rectangle(newPosition.x, newPosition.y, this.getWidth(), this.getHeight());
    }

    public void randomPosition(){
        boolean collision = false;

        while(!collision) {
            int y = randomNumber((int) this.getHeight(), this.screenHeight);
            int x = randomNumber((int) this.getWidth(), this.screenWidth);

            for (int j = 0; j < bars.size() && !collision; j++) {
                if (Intersector.overlaps(bars.get(j).getRectangle(), new Rectangle(x, y, this.getWidth(), this.getHeight()))) {
                    collision = true;
                }
            }

            if (!collision) {
                this.position.x = x;
                this.position.y = y;

                collision = true;
            }
        }
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
