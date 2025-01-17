package com.mypong.game;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.mypong.game.R;

import java.util.Timer;
import java.util.TimerTask;

public class Inicio extends Activity {
    Animation anim1;
    Animation anim2;

    ImageView logo;
    ImageView arcade;
    private static final long SPLASH_SCREEN_DELAY = 3000; //Tiempo de espera para pasar al menu
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        logo = (ImageView) findViewById(R.id.logo);
        anim1 = AnimationUtils.loadAnimation(this, R.anim.anim);
        logo.startAnimation(anim1);
        arcade = (ImageView) findViewById(R.id.arcade);
        anim2 = AnimationUtils.loadAnimation(this, R.anim.bolita);
        arcade.startAnimation(anim2);

        //Creamos un TimerTask para pasar al menu en un tiempo determinado
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                // Start the next activity
                entrar();
                // Close the activity so the user won't able to go back this
                // activity pressing Back button
                finish();
            }
        };

        // Ponemos el tiempo que va a tardar en cambiar de una activity a otra
        Timer timer = new Timer();
        timer.schedule(task, SPLASH_SCREEN_DELAY);
    }

    public void entrar(){
        Intent i = new Intent(this, Menu.class);
        startActivity(i);
    }//entrar


}
