package com.mypong.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.mypong.game.gameobjects.Ball;
import com.mypong.game.gameobjects.Bar;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWorld {
    private int screenWidth;
    private int screenHeight;

    private Bar bar;
    private LinkedList<Bar> shoots;
    private Ball ball;

    private int barHeight;
    private int barWidth;

    private int numShoots;

    private ScrollHandler handler;

    private boolean gameWin;
    private boolean gameOver;

    public GameWorld() {
        newGame();
    }

    public void update(float delta) {
        this.ball.update(delta);

        ArrayList<Integer> deleteShoots = new ArrayList<Integer>();
        for(int x=0; x < shoots.size(); x++){
            shoots.get(x).update(delta);

            if(shoots.get(x).getHeight() >= screenHeight || shoots.get(x).getHeight() <= 0 || shoots.get(x).getWidth() >= screenWidth || shoots.get(x).getWidth() <= 0){
                deleteShoots.add(x);
            }
        }

        for(Integer x : deleteShoots){
            shoots.remove(x);
        }

        for(Bar shoot : shoots){
            if(handler.rightShot(shoot, this.ball)){
                gameWin = true;
                ball.onRelease();
                shoot.onRelease();
            }
        }
    }

    public LinkedList<Bar> getShoots() {
        return shoots;
    }

    public Bar getBar() {
        return this.bar;
    }

    public Ball getBall() { return this.ball; }

    public int getNumShoots() {
        return numShoots;
    }

    public void addShoot(Bar shoot){
        if(numShoots < 5) {
            this.shoots.add(shoot);
            numShoots++;

            if(numShoots == 5){
                this.gameOver = true;
                this.ball.onRelease();

                for(Bar s : shoots){
                    s.onRelease();
                }
            }
        }
    }

    public boolean isGameWin() {
        return gameWin;
    }

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

        int ballWidth = this.screenWidth / 70;

        int velocity = this.screenWidth / 4;

        this.gameWin = false;
        this.gameOver = false;

        this.ball = new Ball(halfWidth, halfHeight, ballWidth, velocity);
        this.bar = new Bar(halfWidth, halfHeight, barWidth, barHeight, 0, 0);

        this.shoots = new LinkedList<Bar>();
        this.numShoots = 0;
    }

    public void dispose(){
        shoots.clear();
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}
