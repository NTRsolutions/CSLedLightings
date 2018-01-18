package com.example.admin.csledlightings;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by Admin on 12/23/2017.
 */

public class Adapter extends FragmentPagerAdapter {
    Context mcontext;
    public Adapter(Context context,FragmentManager fm) {
        super(fm);
        mcontext=context;
    }

    @Override
    public Fragment getItem(int position) {
        if(position==0){
            return new Categories();
        }else if (position==1){
            return new Lights();
        }else if (position==2){
            return new TubeLight();
        }else if (position==3){
            return new PanelLight();
        }else if (position==4){
            return new DownLight();
        }else if (position==5){
            return new CobLight();
        }else if (position==6){
            return new SurfaceLight();
        }else if (position==7){
            return new ConcealedLight();
        }else if (position==8){
            return new TrailLight();
        }else if (position==9){
            return new FloodLight();
        }else {
            return new StreetLight();
        }
    }

    @Override
    public int getCount() {
        return 11;
    }

    public  CharSequence getPageTitle(int position){
        switch (position){
            case 0: return "Categories";
            case 1: return "Bulbs";
            case 2: return "Tube Lights";
            case 3:return "Panel Lights";
            case 4: return "Down Lights";
            case 5: return "COB Lights";
            case 6: return "Surface Lights";
            case 7: return "Concealed Lights";
            case 8: return "Trail Lights";
            case 9: return "Flood Lights";
            case 10: return "Street Lights";
            default:return null;
        }
    }
}
