package com.mypong.game.helper;

import com.badlogic.gdx.InputProcessor;
import com.mypong.game.gameobjects.Bar;
import com.mypong.game.gameworld.GameWorld;

public class InputHandler implements InputProcessor {

    private Bar barLeft;
    private Bar barRight;
    private int screenWidth;
    private int screenHeight;

    public InputHandler(GameWorld myWorld) {
        this.barLeft = myWorld.getBarLeft();
        this.barRight = myWorld.getBarRight();

        this.screenHeight = myWorld.getScreenHeight();
        this.screenWidth = myWorld.getScreenWidth();
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (screenX > (this.screenWidth / 2)) {
            this.barRight.onClick(screenY > (this.screenHeight / 2));
        } else {
            this.barLeft.onClick(screenY > (this.screenHeight / 2));
        }

        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        this.barLeft.onRelease();
        this.barRight.onRelease();
        return true;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
