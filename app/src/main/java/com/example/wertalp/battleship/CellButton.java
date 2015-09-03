package com.example.wertalp.battleship;

/**
 * Created by wertalp on 31.08.15.
 */
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by wertalp on 28.08.15.
 */
public class CellButton extends Button implements View.OnClickListener{
    int xField ;
    int yField ;
    Context ctx;

    public CellButton(Context context) {
        super(context);
        this.ctx = context;
    }

    public int getxField() {
        return xField;
    }

    public void setxField(int xField) {
        this.xField = xField;
    }

    public int getyField() {
        return yField;
    }

    public void setyField(int yField) {
        this.yField = yField;
    }

    public String getPositionText(){
        return "Position X/Y"+getxField()+":"+getyField();

    };


    @Override
    public void onClick(View v) {


    }
}
