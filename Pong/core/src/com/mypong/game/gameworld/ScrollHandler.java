package com.mypong.game.gameworld;

import com.badlogic.gdx.math.Intersector;
import com.mypong.game.gameobjects.Bar;

public class ScrollHandler {
    public void collidesBar(Bar bar1, Bar bar2, float delta) {
        if(Intersector.overlaps(bar1.getRectangle(), bar2.getRectangle())){
            if(Intersector.overlaps(bar1.newPositionCollisionX(delta), bar2.newPositionCollisionX(delta))) {
                bar1.collisionY();
                bar2.collisionY();
            } else {
                bar1.collisionX();
                bar2.collisionX();
            }
        }
    }
}
