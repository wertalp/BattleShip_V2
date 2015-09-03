package com.example.wertalp.battleship;

/**
 * Created by wertalp on 31.08.15.
 */
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * Created by wertalp on 26.08.15.
 */
public class ChessBoard {

    int            heigth    ;
    int            width     ;
    Activity       activity  ;
    GridLayout     board     ;
    Display        display   ;
    int            laenge    ;
    int            breite    ;
    LayoutInflater inflater  ;
    PopupWindow    pw        ;
    Button         Butty     ;
    CellButton[]   liCellBut ;
    //Ship[] ships = new Ship[50];



    public ChessBoard(Activity activity) {

        this.activity = activity;
        this.display  = activity.getWindowManager().getDefaultDisplay();
        this.heigth   = display.getHeight();
        this.width    = display.getWidth() ;
        this.create();

    }

    public int  getHeigth() {
        return heigth;
    }
    public void setHeigth(int heigth) {
        this.heigth = heigth;
    }
    public int  getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void create() {

        int width = display.getWidth();
        int height =display.getHeight();

        board = (GridLayout) activity.findViewById(com.example.wertalp.battleship.R.id.board);
        board.removeAllViews();
        Button buttonSet = (Button) activity.findViewById(com.example.wertalp.battleship.R.id.button23);
        EditText edit1 = (EditText) activity.findViewById(com.example.wertalp.battleship.R.id.editText);

        //board.setColumnCount(Integer.parseInt(edit1.getText().toString()));
        //board.setRowCount(Integer.parseInt(edit1.getText().toString()));
        board.setColumnCount(10);
        board.setRowCount(10);


        laenge = (int) (this.getWidth()-300)/board.getColumnCount();
        breite = laenge ;


        for (int i = 0; i <= board.getRowCount() - 1; i++) {
            for (int j = 0; j <= board.getColumnCount() - 1; j++) {


                CellButton button = new CellButton(activity);
                button.setBackgroundResource(com.example.wertalp.battleship.R.drawable.rectangle);
                button.setId(i + j);
                button.setyField(j);
                button.setxField(i);
                //button.setText(""+i+j);

                button.setLayoutParams(new LinearLayout.LayoutParams(laenge, breite));
                board.addView(button);
                //anz++;

                if (i == 0) {
                    button.setText("" + j);
                    button.setBackgroundResource(com.example.wertalp.battleship.R.drawable.rectangle_second);

                }
                if (j == 0) {
                    button.setText("" + i);
                    button.setBackgroundResource(com.example.wertalp.battleship.R.drawable.rectangle_second);

                }
                if ((i != 0) &&(j !=0)) {

                    //button.setOnClickListener(new View.OnClickListener() {

                     //   @Override
                     //   public void onClick(View v) {

                        //    CellButton b = (CellButton) v;
                        //    Toast.makeText(getActivity().getBaseContext(), "" + b.getPositionText(), Toast.LENGTH_SHORT).show();
                        //    b.setBackgroundResource(com.example.wertalp.battleship.R.drawable.cross);
                        //    Butty = b;
                        //    Ship cur_Ship = new Ship(board);

                         //   show_popup(b);

                       // }

                    //})

                    ;};

            }
        }     //  create Methode ende

    }  // End Create
    public CellButton[] getallcells(){
        int l = 0;
         liCellBut = new CellButton[board.getChildCount()];
        for (int i =0;i<= board.getChildCount();i++){
            View  tmpView = (View) board.getChildAt(i);
            //Toast.makeText(getActivity(),tmpView.getClass().getName(),Toast.LENGTH_SHORT).show();
            if (tmpView instanceof CellButton){

                //Toast.makeText(getActivity(),"CellButt",Toast.LENGTH_SHORT).show();
                liCellBut[l] = (CellButton) tmpView;
                l++;
            }

        }

        return liCellBut;

    }

//  new Board create
//
//
    public Activity getActivity () {
        return activity;
    }
    public void setActivity (Activity activity){
        this.activity = activity;
    };




}