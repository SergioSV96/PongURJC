package com.mypong.game.gameobjects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Ball {
    private int screenHeight;

    private Vector2 position;
    private Vector2 velocity;
    private Color colorBall;
    private int velocityBall = 150;

    private int radio;

    private int collisionsBall;

    public Ball(int x, int y, int radio) {
        this.screenHeight = Gdx.graphics.getHeight();

        this.position = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.radio = radio;
        this.colorBall = Color.WHITE;

        this.collisionsBall = 0;
    }

    public void update(float delta) {
        if(this.getY() - this.radio >= 0){
            if(this.velocity.y < 0){
                position.add(velocity.cpy().scl(delta));
            }
        }

        if(this.getY() <= this.screenHeight - this.radio){
            if(this.velocity.y > 0){
                position.add(velocity.cpy().scl(delta));
            }
        }
    }

    public void collision(){
        this.collisionsBall++;
    }

    public void onClick(boolean up) {
        if(up){
            velocity.y = velocityBall;
        } else {
            velocity.y = -velocityBall;
        }
    }

    public void onRelease(){ velocity.y = 0; }

    public int getCollisionsBall() {
        return collisionsBall;
    }

    public int getRadio() {
        return radio;
    }

    public float getX() {
        return position.x;
    }

    public float getY() {
        return position.y;
    }

    public Color getColorBall() {
        return colorBall;
    }

    public Circle getCircle(){ return new Circle(this.getX(), this.getY(), this.getRadio()); }

    public void setColorBall(Color colorBall) {
        this.colorBall = colorBall;
    }
}
