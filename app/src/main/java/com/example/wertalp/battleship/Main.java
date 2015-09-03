package com.example.wertalp.battleship;


import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.zip.Inflater;


public class Main extends ActionBarActivity {

    private TextView    txt1,txt2,txt3;
    private ProgressBar progb1, progb2, progb3;
    private ShipSelectedListView listofShips ;
    Context      ctx          ;
    Button       buttonSet    ;
    EditText     edit1        ;
    Button       liste        ;
    Button buttonShoot        ;
    CellButton[] allcells     ;
    RelativeLayout layout     ;

    com.example.wertalp.battleship.ChessBoard chessboard  ;
    Player current_player     ;
    ArrayList <Ship> ships    ;
    PopupWindow pw            ;
    GridLayout  board         ;
    CellButton  CurrButton    ;
    static int i=0            ;
    LayoutInflater inflater   ;
    Ship cur_Ship             ;
    ShipListAdapter shipListAdapter;
    List<String> shipnames  = Arrays.asList("Titanic", "Prinz Homburg", "Prinz Eugene",
                                            "Graf Spaeh","Freedom of Seas","Norwegian Dream");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.wertalp.battleship.R.layout.activity_main);
        ctx            = this.getBaseContext();
        current_player = new Player("TESTSPIELER");
        //update ships  = new ArrayList<Ship>();
        current_player.setShips(new ArrayList<Ship>());

        chessboard = new ChessBoard(Main.this)      ;
        chessboard.create()          ;
        chessboard.getallcells()     ;
        setButtonsEvents(chessboard.getallcells())  ;

        Display display = getWindowManager().getDefaultDisplay();
        int width       = display.getWidth()  ;
        int height      = display.getHeight() ;
        this.getAllControls();

              // buttonSet             = (Button)   findViewById(com.example.wertalp.battleship.R.id.button23) ;
              // edit1                 = (EditText) findViewById(com.example.wertalp.battleship.R.id.editText) ;
              // Button buttonShoot    = (Button)   findViewById(com.example.wertalp.battleship.R.id.button2)  ;
              // Button liste          = (Button)   findViewById(R.id.button3)  ;
              //final  RelativeLayout layout = (RelativeLayout) findViewById(R.id.rel);




 liste.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         //current_player.
         listofShips = new ShipSelectedListView(Main.this, current_player.getShips());
         listofShips.addHeaderView(genereateHeader());
         listofShips.addFooterView(generateFooter());

         //listofShips.setAdapter(shipListAdapter);
         layout.addView(listofShips);


     }
 });



        buttonShoot.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent shootIntent = new Intent(Main.this, ShooterActivity.class);
                Main.this.startActivity(shootIntent);
            }
        });

        buttonSet.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                  chessboard = new ChessBoard(Main.this) ;
                   //chessboard.create();
                   setButtonsEvents(chessboard.getallcells());
                                         }
                                     }

        );

    }

    private void setButtonsEvents(CellButton[] cells) {
        for (CellButton cell : cells) {
          cell.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  CellButton b = (CellButton) v;
                  CurrButton = b;
                //  Toast.makeText(Main.this, "" + b.getPositionText(), Toast.LENGTH_SHORT).show();
                  b.setBackgroundResource(R.drawable.ring);
                  show_popup();
              }
          });

    }

}

    private void getAllControls(){
        buttonSet    = (Button)   findViewById(com.example.wertalp.battleship.R.id.button23) ;
        edit1        = (EditText) findViewById(com.example.wertalp.battleship.R.id.editText) ;
        buttonShoot  = (Button)   findViewById(com.example.wertalp.battleship.R.id.button2)  ;
        liste        = (Button)   findViewById(R.id.button3)  ;
        layout = (RelativeLayout) findViewById(R.id.rel);

    }

    private  void show_popup() {

        inflater = (LayoutInflater) LayoutInflater.from(getApplicationContext());
        pw = new PopupWindow(inflater.inflate(R.layout.shipper_4,null),1200,1800,true );


        View viewPopup =(View) pw.getContentView();
        pw.showAtLocation(Main.this.findViewById(R.id.rel), Gravity.CENTER, 0, 0);


        add_listener((ViewGroup) viewPopup);

        ImageButton imgB1 = (ImageButton) viewPopup.findViewById(com.example.wertalp.battleship.R.id.imgBShip1a);
        ImageButton imgB2 = (ImageButton) viewPopup.findViewById(com.example.wertalp.battleship.R.id.imgBShip1b);
        ImageButton imgB3 = (ImageButton) viewPopup.findViewById(com.example.wertalp.battleship.R.id.imgBShip1c);
        ImageButton imgB4 = (ImageButton) viewPopup.findViewById(com.example.wertalp.battleship.R.id.imgBShip1d);
        ImageButton imgB5 = (ImageButton) viewPopup.findViewById(com.example.wertalp.battleship.R.id.imgBShip1e);


    }

    private void add_listener(ViewGroup viewPopup) {

        ViewGroup v1 = (ViewGroup) viewPopup.findViewById(com.example.wertalp.battleship.R.id.linView);
        for(int i=0; i < v1.getChildCount(); i++)
        {
            View v = v1.getChildAt(i);
            if (v instanceof ImageButton) {

                ImageButton b = (ImageButton) v;

                b.setOnClickListener(myClickListener);
            }
        }

    }


    private View.OnClickListener myClickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Point point = new Point();
              point.x = CurrButton.getxField();
              point.y = CurrButton.getxField();

            Drawable shippicture = v.getBackground();
            cur_Ship = new Ship(CurrButton,point);
            cur_Ship.add_ship_to_view(CurrButton, shippicture);
            cur_Ship.setShipId(i);
            cur_Ship.setName("Schiff  NR " + i);
            cur_Ship.setPicture(shippicture);
            //cur_Ship.setPositi,on(point) ;

            //updateships.add(cur_Ship);
            current_player.add_ship(cur_Ship);


            pw.dismiss();
           // Toast.makeText(Main.this.getBaseContext(),"ff"+ships.get(i).getName(),Toast.LENGTH_LONG).show();
            Toast.makeText(Main.this.getBaseContext(), "" + "ID:"+cur_Ship.getShipId()+" "+ cur_Ship.getName()+" pos "+cur_Ship.getPosition().x , Toast.LENGTH_SHORT).show();
            i++;
        }

        ;

    };

    // class listof
    private View genereateHeader() {
    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View vheader =inflater.inflate(R.layout.listitem1,null);

    return vheader;


}
    private View generateFooter(){

    LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    final View vheader =inflater.inflate(R.layout.listfooter,null);

    return vheader;
};

}
