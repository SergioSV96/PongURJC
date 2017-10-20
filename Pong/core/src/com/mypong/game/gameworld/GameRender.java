package com.mypong.game.gameworld;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mypong.game.gameobjects.Ball;
import com.mypong.game.gameobjects.Bar;
import com.mypong.game.helper.AssetLoader;
import com.mypong.game.helper.InputHandler;
import java.util.LinkedList;

public class GameRender {
    private int screenWidth;
    private int screenHeight;

    private GameWorld myWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    private SpriteBatch batcher;

    public GameRender(GameWorld world) {
        this.screenHeight = Gdx.graphics.getHeight();
        this.screenWidth = Gdx.graphics.getWidth();

        myWorld = world;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, this.screenWidth, this.screenHeight);

        batcher = new SpriteBatch();

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

        shapeRenderer.setColor(ball.getColorBall());
        shapeRenderer.circle(ball.getX(), ball.getY(), ball.getRadio());

        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);
        for(Bar bar : bars){
            shapeRenderer.rect(bar.getX(), bar.getY(), bar.getWidth(), bar.getHeight());
        }

        shapeRenderer.end();

        if(this.myWorld.isGameOver()) {
            batcher.begin();
            String playAgain = "¿Volver a jugar?";
            String gameOver = "Has perdido";

            AssetLoader.font.setColor(Color.CYAN);
            AssetLoader.font.draw(batcher, gameOver, (this.screenWidth / 2) - gameOver.length() * 3, (this.screenHeight / 2) + 15);
            AssetLoader.font.draw(batcher, playAgain, (this.screenWidth / 2) - playAgain.length() * 3, this.screenHeight / 2);
            batcher.end();

            Stage stage = new Stage();
            Gdx.input.setInputProcessor(stage);

            TextButton buttonYes = AssetLoader.obtainButton("Si", (this.screenWidth / 2) - 50, (this.screenHeight / 2) - 50);
            TextButton buttonNo = AssetLoader.obtainButton("No", (this.screenWidth / 2) + 10, (this.screenHeight / 2) - 50);

            buttonYes.addListener(new ClickListener(){
                @Override
                public void clicked(InputEvent event, float x, float y){
                    myWorld.newGame();
                    Gdx.input.setInputProcessor(new InputHandler(myWorld));
                }});

            stage.addActor(buttonYes);
            stage.addActor(buttonNo);

            stage.act();
            stage.draw();
        }
    }

}
