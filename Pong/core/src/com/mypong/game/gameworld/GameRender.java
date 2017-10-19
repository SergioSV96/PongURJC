package com.mypong.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mypong.game.gameobjects.Ball;
import com.mypong.game.gameobjects.Bar;

import java.util.LinkedList;

public class GameRender {
    private int screenWidth;
    private int screenHeight;

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    public GameRender(GameWorld world) {
        this.screenHeight = Gdx.graphics.getHeight();
        this.screenWidth = Gdx.graphics.getWidth();

        myWorld = world;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, this.screenWidth, this.screenHeight);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render(){
        LinkedList<Bar> bars = this.myWorld.getBars();
        Ball ball = this.myWorld.getBall();

        //Carga color de fondo negro
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);

        for(Bar bar : bars){
            shapeRenderer.rect(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight());
        }

        shapeRenderer.end();
    }

}
