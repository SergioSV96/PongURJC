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
    private int velocityBar = 500;

    public Bar(int x, int y, int width, int height) {
        this.screenHeight = Gdx.graphics.getHeight();

        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.width = width;
        this.height = height;
    }

    public void update(float delta) {
        if(this.getY() >= 0){
            if(this.velocity.y < 0){
                position.add(velocity.cpy().scl(delta));
            }
        }

        if(this.getY() <= this.getScreenHeight() - this.height){
            if(this.velocity.y > 0){
                position.add(velocity.cpy().scl(delta));
            }
        }
    }

    public void onClick(boolean up) {
        if(up){
            velocity.y = velocityBar;
        } else {
            velocity.y = -velocityBar;
        }
    }

    public void onRelease(){ velocity.y = 0; }

    public int getScreenHeight() {
        return screenHeight;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {return position.y;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public Rectangle getRectangle(){ return new Rectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight()); }

}
