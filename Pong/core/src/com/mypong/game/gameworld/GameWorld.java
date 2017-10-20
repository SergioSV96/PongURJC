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

    private LinkedList<Bar> bars;
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

        for(Bar bar : bars){
            bar.update(delta);
        }

        for(int x=0; x < bars.size(); x++){
            handler.collidesBall(bars.get(x), ball, delta);

            for(int y=x+1; y < bars.size(); y++){
                handler.collidesBar(bars.get(x), bars.get(y), delta);
            }
        }

        if(ball.getCollisionsBall() == 3){
            this.gameOver = true;
            this.timer.shutdown();
            ball.onRelease();

            for (Bar bar : bars){
                bar.onRelease();
            }
        }
    }

    public LinkedList<Bar> getBars(){
        return this.bars;
    }

    public Ball getBall() { return this.ball; }

    public boolean isGameOver() {
        return gameOver;
    }

    public void newGame(){
        this.bars = new LinkedList<Bar>();
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

        this.bars.add(new Bar(barWidth, barHeight, velocity, bars));
        this.bars.add(new Bar(barWidth, barHeight, velocity, bars));

        this.ball = new Ball(halfWidth, halfHeight, ballWidth);

        final Runnable tarea = new Runnable() {
            public void run() {
                bars.add(new Bar(barWidth, barHeight, velocity, bars));
            }
        };

        this.timer = Executors.newSingleThreadScheduledExecutor();
        this.timer.scheduleAtFixedRate(tarea, 10, 10, TimeUnit.SECONDS);
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}
