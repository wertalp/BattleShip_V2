package com.example.wertalp.battleship;


import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.TextView;


public class Main extends ActionBarActivity implements SensorEventListener{

    private TextView txt1,txt2,txt3;
    private ProgressBar progb1, progb2, progb3;
    private ListView listview;
    LayoutInflater   inflater;
    Context    ctx        ;
    Button     buttonSet  ;
    EditText   edit1      ;

    com.example.wertalp.battleship.ChessBoard chessboard  ;
    Ship[]      ships       ;
    PopupWindow pw;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.wertalp.battleship.R.layout.activity_main);
        ctx = this.getBaseContext();


        chessboard = new ChessBoard(Main.this) ;
        chessboard.create();


        Display display = getWindowManager().getDefaultDisplay();
        int width = display.getWidth();
        int height =display.getHeight();
        //Toast.makeText(getBaseContext(), "WIDTH HEIGHT: " + width+" : "+height, Toast.LENGTH_LONG).show();

        buttonSet = (Button)   findViewById(com.example.wertalp.battleship.R.id.button23);
        edit1     = (EditText) findViewById(com.example.wertalp.battleship.R.id.editText);
        Button buttonShoot = (Button) findViewById(com.example.wertalp.battleship.R.id.button2) ;

        buttonShoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent shootIntent = new Intent(Main.this,ShooterActivity.class);

                Main.this.startActivity(shootIntent);


            }
        });

        buttonSet.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {

                                             chessboard = new ChessBoard(Main.this) ;
                                             chessboard.create();
                                         }
                                     }

        );

        // inflater = LayoutInflater.from(ctx);
        //createBoard();

    }







    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
