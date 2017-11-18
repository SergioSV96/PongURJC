package com.mypong.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.mypong.game.gameobjects.Ball;
import com.mypong.game.gameobjects.Bar;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWorld {
    private int screenWidth;
    private int screenHeight;

    private Bar bar;
    private Ball ball;

    private int barHeight;
    private int barWidth;
    private int velocity;

    private ScrollHandler handler;

    private boolean gameOver;

    private ScheduledExecutorService timer;

    public GameWorld() {
        newGame();
    }

    public void update(float delta) {
        this.ball.update(delta);
    }

    public Bar getBar() {
        return this.bar;
    }

    public Ball getBall() { return this.ball; }

    public boolean isGameOver() {
        return gameOver;
    }

    public void newGame(){
        this.handler = new ScrollHandler();

        this.screenHeight = Gdx.graphics.getHeight();
        this.screenWidth = Gdx.graphics.getWidth();

        this.barHeight = this.screenHeight / 10;
        this.barWidth =  barHeight / 10;

        int halfHeight = this.screenHeight / 2;
        int halfWidth = this.screenWidth / 2;

        int ballWidth = this.screenWidth / 100;

        this.velocity = this.screenWidth / 4;

        this.gameOver = false;

        this.ball = new Ball(halfWidth, halfHeight, ballWidth, velocity);
        this.bar = new Bar(halfWidth, halfHeight, barWidth, barHeight, velocity);
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}
