package com.mypong.game.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.mypong.game.gameobjects.Ball;
import com.mypong.game.gameobjects.Bar;
public class ScrollHandler {
    public void rightShot(Bar bar, Ball ball, float delta){
        if(Intersector.overlaps(ball.getCircle(), bar.getRectangle())){
            ball.collision();
        }
    }
}
