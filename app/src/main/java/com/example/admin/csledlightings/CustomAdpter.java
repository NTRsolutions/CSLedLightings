package com.example.admin.csledlightings;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Admin on 12/25/2017.
 */

public class CustomAdpter extends BaseAdapter {

    Context c;
    ArrayList<Integer> image;
    ArrayList<String> title;
    ArrayList<String> price;
    public LayoutInflater inflater;
    CustomAdpter(Context context, ArrayList<Integer> image, ArrayList<String> title, ArrayList<String> price){
        c=context;
        this.image=image;
        this.title=title;
        this.price=price;
        inflater = (LayoutInflater)c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }
    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class Holder{
        TextView tvtitle;
        ImageView ivimage;
        TextView tvprice;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View grid;
        Holder holder=new Holder();

        grid = inflater.inflate(R.layout.gridview, null);
        holder.tvtitle = (TextView)grid.findViewById(R.id.tvtitle);
        holder.ivimage= (ImageView)grid.findViewById(R.id.ivimage);
        holder.tvprice=(TextView)grid.findViewById(R.id.tvprice);

        holder.tvtitle.setText(title.get(i));
        holder.ivimage.setImageResource(image.get(i));
        holder.tvprice.setText(price.get(i));

        return grid;
    }
}
