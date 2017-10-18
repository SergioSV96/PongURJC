package com.mypong.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.mypong.game.gameobjects.Ball;
import com.mypong.game.gameobjects.Bar;

public class GameWorld {
    private int screenWidth;
    private int screenHeight;

    private Bar barLeft;
    private Bar barRight;
    private Ball ball;

    private ScrollHandler handler;

    public GameWorld() {
        this.handler = new ScrollHandler();

        this.screenHeight = Gdx.graphics.getHeight();
        this.screenWidth = Gdx.graphics.getWidth();

        int barHeight = this.screenHeight / 4;
        int barWidth =  barHeight / 7;

        int halfHeight = (this.screenHeight / 2) - (barHeight / 2);
        int halfWidth = this.screenWidth / 2;

        int wallSeparationRight = (this.screenWidth - barWidth) - 10;
        int wallSeparationLeft = 10;

        int ballWidth = this.screenWidth / 50;

        barLeft = new Bar(wallSeparationLeft, halfHeight, barWidth, barHeight);
        barRight = new Bar(wallSeparationRight, halfHeight, barWidth, barHeight);
        ball = new Ball(halfWidth, halfHeight, ballWidth);
    }

    public void update(float delta) {
        this.barLeft.update(delta);
        this.barRight.update(delta);
        this.ball.update(delta);

        if (handler.collides(this.barLeft, this.barRight, this.ball)){
            this.ball.collision();
        }

        if(handler.ballOutScreen(this.ball)){
            this.ball.outScreen();
        }
    }

    public Bar getBarLeft() {
        return this.barLeft;
    }

    public Bar getBarRight() {
        return this.barRight;
    }

    public Ball getBall() { return this.ball; }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }
}
