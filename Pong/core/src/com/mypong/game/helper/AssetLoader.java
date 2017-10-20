package com.mypong.game.helper;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class AssetLoader {
    private static int screenWidth;
    private static int screenHeight;

    public static BitmapFont font, shadow;

    public static void load(){
        screenHeight = Gdx.graphics.getHeight();
        screenWidth = Gdx.graphics.getWidth();

        font = new BitmapFont();
        font.getData().setScale(1, 1);
    }

    public static TextButton obtainButton(String text, float x, float y){
        TextButton newGameButton = new TextButton(text, createBasicSkin()); // Use the initialized skin
        newGameButton.setPosition(x, y);

        return newGameButton;
    }

    private static Skin createBasicSkin(){
        //Create a font
        BitmapFont font = new BitmapFont();
        Skin skin = new Skin();
        skin.add("default", font);

        //Create a texture
        Pixmap pixmap = new Pixmap(screenWidth/10,screenHeight/10, Pixmap.Format.RGB888);
        pixmap.setColor(Color.CYAN);
        pixmap.fill();
        skin.add("background", new Texture(pixmap));

        //Create a button style
        TextButton.TextButtonStyle textButtonStyle = new TextButton.TextButtonStyle();
        textButtonStyle.up = skin.newDrawable("background", Color.GRAY);
        textButtonStyle.down = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.checked = skin.newDrawable("background", Color.DARK_GRAY);
        textButtonStyle.over = skin.newDrawable("background", Color.LIGHT_GRAY);
        textButtonStyle.font = skin.getFont("default");
        skin.add("default", textButtonStyle);

        return skin;
    }

    public static void dispose() {
        font.dispose();
    }
}