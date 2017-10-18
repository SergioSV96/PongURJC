package com.mypong.game.game;

import com.badlogic.gdx.Game;
import com.mypong.game.screens.GameScreen;


public class Pong extends Game{
    @Override
    public void create() {
        //Creamos la pantalla del juego
        setScreen(new GameScreen());
    }
}
