package com.example.wertalp.battleship;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by wertalp on 02.09.15.
 */
public class ShipSelectedListView extends ListView implements AdapterView.OnItemClickListener {
     Context         context ;
     List<Ship>      ships   ;
     ShipListAdapter shipListAdapter;

    public ShipSelectedListView(Context context,List<Ship> ships) {

        super(context);
        this.context    = context;
        this.ships      = ships;
        shipListAdapter = new ShipListAdapter(context.getApplicationContext(),ships);
        super.setOnItemClickListener(this);
        super.setAdapter(shipListAdapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


       //shipListAdapter.deleteItem(position);

    }
}
