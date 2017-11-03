package com.mypong.game;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;

public class Menu extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void jugar(View v){
        Intent i = new Intent(this, AndroidLauncher.class);
        startActivity(i);
    }

    /**
     * Muestra un Dialogo de Confirmacion al Usuario antes de salir de la aplicacion
     * Si el usuario acepta el dialogo, llamamos al metodo 'salir()'
     * En caso negativo, nos quedamos en la activity
     * @param view Boton la UI que invoca el metodo
     */
    public void lanzarSalir(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("PONG");
        builder.setMessage("¿Seguro que quieres salir de la aplicacion?");
        builder.setPositiveButton("SALIR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                salir();

            }
        });
        builder.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //no hacemos nada
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    /**
     * Finaliza la activity
     */
    private void salir() {
        this.finish();
    }

    /**
     * Cuendo el finish de la activity llama al onDestroy() hacemos lo sigueinte:
     *  -   Matamos el proceso Android que ejecuta la aplicacion
     *  -   Finalizamos de nuevo la activity
     *  -   Hacemos una salida abrupta del sistema
     */
    @Override
    protected void onDestroy() {
        // closing Entire Application
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
        this.finish();
        System.exit(0);
    }

}
