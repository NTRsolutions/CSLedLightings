package com.example.admin.csledlightings;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation scale,alpha,alphadtob,alphabtod;
    ActionBar actionBar;
    TextView tvcsled,tvdes;
    ImageView ivlogo,ivlogobright;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        actionBar=getSupportActionBar();
        actionBar.hide();

        Window window=getWindow();
        window.setStatusBarColor(Color.parseColor(String.valueOf("#000000")));

        tvcsled=(TextView)findViewById(R.id.tvcsled);
        ivlogo=(ImageView)findViewById(R.id.ivlogo);
        tvdes=(TextView)findViewById(R.id.tvdes);
        ivlogobright=(ImageView)findViewById(R.id.ivlogobright);

        ivlogobright.setAlpha(0.0f);

        scale=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale);
        ivlogo.setAnimation(scale);

        alphadtob=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alphadtob);
        alphabtod=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alphabtod);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ivlogobright.setAlpha(1.0f);
                ivlogo.setAnimation(alphabtod);
                ivlogobright.setAnimation(alphadtob);
            }
        },1000);


        alpha=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.alpha);
        tvcsled.setAnimation(alpha);
        tvdes.setAnimation(alpha);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent=new Intent(getApplicationContext(),Main2Activity.class);
                startActivity(intent);
                finish();
            }
        },2500);

    }
}
