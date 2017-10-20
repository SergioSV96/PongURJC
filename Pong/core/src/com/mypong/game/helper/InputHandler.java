package com.mypong.game.helper;

import com.badlogic.gdx.InputProcessor;
import com.mypong.game.gameobjects.Ball;
import com.mypong.game.gameworld.GameWorld;

public class InputHandler implements InputProcessor {

    private Ball ball;
    private GameWorld myWorld;
    private int screenWidth;
    private int screenHeight;

    public InputHandler(GameWorld myWorld) {
        this.screenHeight = myWorld.getScreenHeight();
        this.screenWidth = myWorld.getScreenWidth();

        this.myWorld = myWorld;
        this.ball = myWorld.getBall();
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
        if(!this.myWorld.isGameOver()) {
            if (screenX > (this.screenWidth / 2)) {
                this.ball.onClick(screenY > (this.screenHeight / 2));
            } else {
                this.ball.onClick(screenY > (this.screenHeight / 2));
            }

            return true;
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if(!this.myWorld.isGameOver()) {
            this.ball.onRelease();

            return true;
        }

        return false;
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
