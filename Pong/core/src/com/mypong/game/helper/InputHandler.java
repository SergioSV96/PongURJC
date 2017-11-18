package com.mypong.game.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.mypong.game.gameobjects.Ball;
import com.mypong.game.gameobjects.Bar;
import com.mypong.game.gameworld.GameWorld;

public class InputHandler implements InputProcessor, GestureDetector.GestureListener {

    private Ball ball;
    private Bar bar;
    private GameWorld myWorld;
    private int screenWidth;
    private int screenHeight;
    private int shoot;

    public InputHandler(GameWorld myWorld) {
        this.screenHeight = myWorld.getScreenHeight();
        this.screenWidth = myWorld.getScreenWidth();

        this.myWorld = myWorld;
        this.ball = myWorld.getBall();
        this.bar = myWorld.getBar();
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
        shoot++;

        if(shoot == 2) {
            shoot = 0;
            this.myWorld.addShoot(new Bar((int) this.bar.getX(), (int) this.bar.getY(), this.bar.getWidth(), (this.bar.getHeight() / 5), 0, -(screenWidth / 4)));
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        int x = screenX;
        int y = screenY;
        shoot = 0;

        if(x > screenWidth){
            x = (x - screenWidth);
        } else if(x == 0){
            x = screenWidth - (bar.getWidth() + 5);
        }

        if((y + bar.getHeight()) > screenHeight){
            y = 10;
        } else if(y == 0){
            y = screenHeight - (bar.getHeight() + 5);
        }

        bar.setX(x);
        bar.setY(y);
        return true;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }


    @Override
    public boolean touchDown(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean tap(float x, float y, int count, int button) {
        return false;
    }

    @Override
    public boolean longPress(float x, float y) {
        return false;
    }

    @Override
    public boolean fling(float velocityX, float velocityY, int button) {
        return false;
    }

    @Override
    public boolean pan(float x, float y, float deltaX, float deltaY) {
        return false;
    }

    @Override
    public boolean panStop(float x, float y, int pointer, int button) {
        return false;
    }

    @Override
    public boolean zoom(float initialDistance, float distance) {
        return false;
    }

    @Override
    public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
        return false;
    }

    @Override
    public void pinchStop() {

    }
}
