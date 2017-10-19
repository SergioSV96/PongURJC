package com.mypong.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Intersector;
import com.mypong.game.gameobjects.Bar;

public class ScrollHandler {
    public void collidesBar(Bar bar1, Bar bar2) {
        if(Intersector.overlaps(bar1.getRectangle(), bar2.getRectangle())){
            bar1.collisionY();
            bar2.collisionY();
        }
    }
}
