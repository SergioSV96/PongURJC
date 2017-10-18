package com.mypong.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.mypong.game.gameobjects.Ball;
import com.mypong.game.gameobjects.Bar;

public class ScrollHandler {
    private int screenWidth;

    public ScrollHandler() {
        this.screenWidth = Gdx.graphics.getWidth();
    }

    public boolean collides(Bar barLeft, Bar barRight, Ball ball) {
        if(ball.getX() > this.screenWidth / 2){
            if(ball.getX() <= barRight.getX())
                return Intersector.overlaps(ball.getCircle(), barRight.getRectangle());
        } else {
            if(ball.getX() >= barLeft.getX())
                return Intersector.overlaps(ball.getCircle(), barLeft.getRectangle());
        }
        return false;
    }

    public boolean ballOutScreen(Ball ball){
        if(ball.getX() < 0 || ball.getX() > this.screenWidth) {
            return true;
        } else {
            return false;
        }
    }
}
