package com.mypong.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.mypong.game.gameobjects.Ball;
import com.mypong.game.gameobjects.Bar;
import java.util.LinkedList;

public class GameWorld {
    private int screenWidth;
    private int screenHeight;

    private LinkedList<Bar> bars;
    private Ball ball;

    private ScrollHandler handler;

    public GameWorld() {
        this.bars = new LinkedList<Bar>();
        this.handler = new ScrollHandler();

        this.screenHeight = Gdx.graphics.getHeight();
        this.screenWidth = Gdx.graphics.getWidth();

        int barHeight = this.screenHeight / 10;
        int barWidth =  barHeight / 10;

        int halfHeight = (this.screenHeight / 2) - (barHeight / 2);
        int halfWidth = this.screenWidth / 2;

        int ballWidth = this.screenWidth / 50;

        int velocity = this.screenWidth / 4;


        bars.add(new Bar(barWidth, barHeight, velocity, bars));
        bars.add(new Bar(barWidth, barHeight, velocity, bars));

        ball = new Ball(halfWidth, halfHeight, ballWidth);
    }

    public void update(float delta) {
        this.ball.update(delta);

        for(Bar bar : bars){
            bar.update(delta);
        }

        for(int x=0; x < bars.size(); x++){
            for(int y=x+1; y < bars.size(); y++){
                handler.collidesBar(bars.get(x), bars.get(y), delta);
            }
        }
    }

    public LinkedList<Bar> getBars(){
        return this.bars;
    }

    public Ball getBall() { return this.ball; }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}
