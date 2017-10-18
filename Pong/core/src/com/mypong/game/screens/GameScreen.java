package com.mypong.game.screens;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.Gdx;
import com.mypong.game.gameworld.GameRender;
import com.mypong.game.gameworld.GameWorld;
import com.mypong.game.helper.InputHandler;

public class GameScreen implements Screen{

    private GameWorld world;
    private GameRender renderer;

    public GameScreen() {
        world = new GameWorld();
        renderer = new GameRender(world);
        Gdx.input.setInputProcessor(new InputHandler(world));
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        world.update(delta);
        renderer.render();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
