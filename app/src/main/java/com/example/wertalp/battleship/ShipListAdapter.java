package com.example.wertalp.battleship;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by wertalp on 02.09.15.
 */
public class ShipListAdapter extends BaseAdapter{
    Context         ctx        ;
    LayoutInflater  mInflater  ;
    List <Ship>     ships      ;


    public ShipListAdapter(Context context, List <Ship> ships) {
        this.ctx       = context;
        this.mInflater = LayoutInflater.from(getCtx());
        this.ships     = ships;

    }

    @Override
    public int getCount() {
        return ships.size();
    }

    @Override
    public Object getItem(int position) {
        return this.ships.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View       rowview  ;
        ViewHolder holder   ;


        final Context context = parent.getContext();
        if (convertView == null) {
            rowview = mInflater.inflate(R.layout.listitem, parent, false);
            holder = new ViewHolder();
            holder.avatar =   (ImageView)rowview.findViewById(R.id.avatar1);
            holder.txtNr    = (TextView) rowview.findViewById(R.id.txtNr);
            holder.name     = (TextView) rowview.findViewById(R.id.name);
            holder.position = (TextView) rowview.findViewById(R.id.position);
            holder.checkBox = (CheckBox) rowview.findViewById(R.id.checkBox);
            holder.cross    = (ImageView)rowview.findViewById(R.id.avatar);


            rowview.setTag(holder);
        } else {
            rowview = convertView;
            holder = (ViewHolder) rowview.getTag();
        }

        Ship ship = ships.get(position);
        System.out.println("BOOT" + ship.getName() + ship.getPosition() + ship.getPosition().x);

        holder.avatar.setImageDrawable(ship.getPicture());
        holder.txtNr.setText(" "+ship.getShipId());
        //holder.txtNr.setText("1");
        holder.position.setText(ship.getName());
        holder.name.setText("Position X: "+ship.getPosition().x +"und Y: "+ship.getPosition().y );
        holder.cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                deleteItem(position);
                notifyDataSetChanged();
            }
        });



        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    Toast.makeText(getCtx(),
                            "Delete this Move ", Toast.LENGTH_LONG).show();

                } else {
                   // deleteItem(position);
                   // notifyDataSetChanged();
                    Toast.makeText(getCtx(),
                            "DELETE this Move", Toast.LENGTH_LONG).show();
                }

            }
        });


        return rowview;
    }


    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    };



    public void deleteItem(int position){
        ships.remove(position);
        notifyDataSetChanged();


    }
    private class ViewHolder {
        public ImageView avatar  ;
        public TextView name, position;
        public CheckBox checkBox ;
        public TextView txtNr    ;
        public ImageView cross   ;

    }
}

