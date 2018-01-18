package com.example.admin.csledlightings;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    Button btnleft,btnright,btnbuy;
    ImageView ivphotos;
    TextView tvname,tvrs,tvdetails;
    ActionBar bar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        bar=getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setTitle("");
        btnleft=findViewById(R.id.btnleft);
        btnright=findViewById(R.id.btnright);
        btnbuy=findViewById(R.id.btnbuy);

        ivphotos=findViewById(R.id.ivphotos);
        tvname=findViewById(R.id.tvname);
        tvrs=findViewById(R.id.tvrs);
        tvdetails=findViewById(R.id.tvdetails);

        String totalimages=getIntent().getExtras().getString("totalimages");
        String title=getIntent().getExtras().getString("text");
        String price=getIntent().getExtras().getString("price");
        String desc=getIntent().getExtras().getString("desc");
        tvname.setText(title);
        tvrs.setText(price);
        tvdetails.setText(desc);

        if(totalimages.equals("1")){
            btnleft.setVisibility(View.GONE);
            btnright.setVisibility(View.GONE);

            int image=getIntent().getExtras().getInt("image");
            ivphotos.setImageResource(image);

        }else if (totalimages.equals("2")) {
            btnleft.setVisibility(View.GONE);

            final int image1 = getIntent().getExtras().getInt("image1");
            final int image2 = getIntent().getExtras().getInt("image2");

            ivphotos.setImageResource(image1);

            btnright.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ivphotos.setImageResource(image2);
                    btnright.setVisibility(View.GONE);
                    btnleft.setVisibility(View.VISIBLE);
                }
            });

            btnleft.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ivphotos.setImageResource(image1);
                    btnleft.setVisibility(View.GONE);
                    btnright.setVisibility(View.VISIBLE);
                }
            });
        }

        btnbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),FullscreenActivity.class);
                intent.putExtra("weburl","https://paywith.indiamart.com/invoice/#/mdc/11588651");
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
