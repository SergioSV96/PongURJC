package com.mypong.game.gameobjects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Ball {
    private int screenHeight;

    private Vector2 initialPosition;
    private Vector2 position;
    private Vector2 velocity;

    private int radio;

    public Ball(int x, int y, int radio) {
        this.screenHeight = Gdx.graphics.getHeight();

        this.position = new Vector2(x, y);
        this.initialPosition = new Vector2(x, y);
        this.velocity = new Vector2(0, 0);
        this.radio = radio;

        randomVelocity();
    }

    public void update(float delta) {
        if((this.position.y - this.radio) <= 0 || (this.position.y + this.radio) >= this.screenHeight){
            this.velocity.y = - this.velocity.y;
        }

        position.add(velocity.cpy().scl(delta));
    }

    public void collision() { this.velocity.x = -this.velocity.x; }

    public void outScreen() {
        this.position = new Vector2(this.initialPosition.x, this.initialPosition.y);
        randomVelocity();
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

    public Circle getCircle(){ return new Circle(this.getX(), this.getY(), this.getRadio()); }

    public void randomVelocity(){
        this.velocity.y = randomNumber(-200, 200);
        this.velocity.x = randomNumber(-200, 200);
    }

    public static int randomNumber(int min,int max) {return (int)Math.floor(Math.random()*(max-min+1)); }

}
