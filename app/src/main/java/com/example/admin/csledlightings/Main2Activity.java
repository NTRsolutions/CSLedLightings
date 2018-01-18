package com.example.admin.csledlightings;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ActionBar bar;
    Window window;
    ViewPager viewPager;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        toolbar.setTitle("CS Led Lightings");

        viewPager=(ViewPager)findViewById(R.id.viewpager);
        Adapter adapter=new Adapter(getApplicationContext(),getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout=(TabLayout)findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if(viewPager.getCurrentItem()!=0){
            viewPager.setCurrentItem(0);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.bulbs) {
            viewPager.setCurrentItem(1);
        } else if (id == R.id.tube) {
            viewPager.setCurrentItem(2);
        } else if (id == R.id.panel) {
            viewPager.setCurrentItem(3);
        } else if (id == R.id.down) {
            viewPager.setCurrentItem(4);
        } else if (id == R.id.cob) {
            viewPager.setCurrentItem(5);
        } else if (id == R.id.surface) {
            viewPager.setCurrentItem(6);
        } else if (id == R.id.concealed) {
            viewPager.setCurrentItem(7);
        }else if (id == R.id.trail) {
            viewPager.setCurrentItem(8);
        }else if (id == R.id.flood) {
            viewPager.setCurrentItem(9);
        }else if (id == R.id.street) {
            viewPager.setCurrentItem(10);
        }else if (id == R.id.nav_brochure) {
            Intent intent=new Intent(getApplicationContext(),FullscreenActivity.class);
            intent.putExtra("weburl","https://drive.google.com/file/d/1iLr25ol_wKyCiYWFmYPP6j2AUIhr_K5d/view?usp=drivesdk");
            startActivity(intent);
        }else if (id == R.id.nav_about) {
            Intent intent=new Intent(getApplicationContext(),FullscreenActivity.class);
            intent.putExtra("weburl","https://www.indiamart.com/company/11588651/aboutus.html");
            startActivity(intent);
        }else if (id == R.id.nav_contact) {
            Intent intent=new Intent(getApplicationContext(),Main3Activity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
