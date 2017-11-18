package com.mypong.game.gameobjects;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class Ball {
    private int screenHeight;
    private int screenWidth;

    private Vector2 position;
    private Vector2 velocity;
    private Color colorBall;

    private int radio;
    private int outScreen;

    public Ball(int x, int y, int radio, int velocityBall) {
        this.screenHeight = Gdx.graphics.getHeight();
        this.screenWidth = Gdx.graphics.getWidth();

        this.position = new Vector2(randomNumber(screenWidth, screenHeight), randomNumber(screenWidth, screenHeight));
        this.velocity = new Vector2(randomPositiveNegative(velocityBall), randomPositiveNegative(velocityBall));
        this.radio = radio;

        this.colorBall = Color.WHITE;
        this.outScreen = 0;
    }

    public void update(float delta) {
        if(this.getX() >= this.screenWidth){
            this.setX((int)this.getX() - this.screenWidth);
            change();
        } else if(this.getX() <= 0){
            this.setX((int)this.getX() + this.screenWidth);
            change();
        }

        if(this.getY() >= this.screenHeight){
            this.setY((int)this.getY() - this.screenHeight);
            change();
        } else if(this.getY() <= 0){
            this.setY((int)this.getY() + this.screenHeight);
            change();
        }

        position.add(velocity.cpy().scl(delta));
    }

    public void onRelease(){
        velocity.x = 0;
        velocity.y = 0;
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

    public int getOutScreen() {
        return outScreen;
    }

    public void setX(int x) {
        position.x = x;
    }

    public void setY(int y) {
        position.y = y;
    }

    public Color getColorBall() {
        return colorBall;
    }

    public Circle getCircle(){ return new Circle(this.getX(), this.getY(), this.getRadio()); }

    public Rectangle getRectangle(){ return new Rectangle(this.getX(), this.getY(), this.getRadio() * 2, this.getRadio() * 2); }


    public void change(){
        outScreen++;
        randomColor();
    }

    public void randomColor(){
        boolean repeatColor = false;
        Color colors[] = {Color.BLUE, Color.CORAL, Color.GOLD, Color.GREEN, Color.PINK, Color.RED, Color.YELLOW};

        while(!repeatColor){
            Color newColor = colors[randomNumber(0, colors.length - 1)];

            if(newColor != this.colorBall){
                repeatColor = true;
                this.setColorBall(newColor);
            }
        }
    }

    public void setColorBall(Color colorBall) {
        this.colorBall = colorBall;
    }

    public static int randomPositiveNegative(int num){
        Random rnd = new Random();
        int aleatory = rnd.nextInt();

        if(aleatory >= 0){
            return num;
        } else {
            return -num;
        }
    }

    public static int randomNumber(int min,int max) {return (int)Math.floor(Math.random()*(max-min+1)); }
}
