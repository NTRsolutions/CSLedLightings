package com.example.admin.csledlightings;

import android.content.Context;
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
class ListCustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Integer> image;
    ArrayList<String> title;
    ArrayList<String> price;
    ArrayList<String> desc;
    public LayoutInflater inflater;
    ListCustomAdapter(Context context, ArrayList<Integer> image, ArrayList<String> title, ArrayList<String> price, ArrayList<String> desc){
        c=context;
        this.image=image;
        this.title=title;
        this.price=price;
        this.desc=desc;
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
        TextView tvdesc;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View list;
        Holder holder=new Holder();

        list = inflater.inflate(R.layout.itemview, null);
        holder.tvtitle = (TextView)list.findViewById(R.id.title);
        holder.ivimage= (ImageView)list.findViewById(R.id.image);
        holder.tvprice=(TextView)list.findViewById(R.id.price);
        holder.tvdesc=(TextView)list.findViewById(R.id.description);

        holder.tvtitle.setText(title.get(i));
        holder.ivimage.setImageResource(image.get(i));
        holder.tvprice.setText(price.get(i));
        holder.tvdesc.setText(desc.get(i));

        return list;
    }

    public int getViewTypeCount() {
        if(title.size()==0){
            return 1;
        }
        return title.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}

