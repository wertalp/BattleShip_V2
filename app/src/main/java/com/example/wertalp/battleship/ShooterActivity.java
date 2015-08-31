package com.example.wertalp.battleship;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by wertalp on 31.08.15.
 */
public class ShooterActivity extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.wertalp.battleship.R.layout.activity_shooter);


        ChessBoard chessboard = new ChessBoard(ShooterActivity.this) ;
        chessboard.create();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(com.example.wertalp.battleship.R.menu.menu_shooter, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == com.example.wertalp.battleship.R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}