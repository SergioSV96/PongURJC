package com.mypong.game.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.mypong.game.gameobjects.Ball;
import com.mypong.game.gameobjects.Bar;
public class ScrollHandler {
    public boolean rightShot(Bar bar, Ball ball){
        if(ball.getOutScreen()%2 == 0){
            if(Intersector.overlaps(ball.getCircle(), bar.getRectangle())){
                return true;
            }
        } else {
            if(Intersector.overlaps(ball.getRectangle(), bar.getRectangle())){
                return true;
            }
        }

        return false;
    }
}
