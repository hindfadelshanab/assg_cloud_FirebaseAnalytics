package com.example.assigmemntcloud2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
ImageView imageViewFood;
ImageView imageViewLaptop;
ImageView imageViewPhone;

    long time1 ;
    long time2;
    long timeResult;
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewFood = findViewById(R.id.image_food);
        imageViewLaptop =findViewById(R.id.image_laptop);
        imageViewPhone =findViewById(R.id.image_phone);
        imageViewFood.setOnClickListener(this);
        imageViewLaptop.setOnClickListener(this);
        imageViewPhone.setOnClickListener(this);
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);


        time1= System.currentTimeMillis();



    }



    public  void trackScreen(String screenname){
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME,screenname );
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "MainActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
    }
    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case  R.id.image_food:
                Intent i =new Intent(getApplicationContext() , FoodActivity.class);
                startActivity(i);
                break;
            case R.id.image_laptop:
                Intent i2 =new Intent(getApplicationContext() , LaptopActivity.class);
                startActivity(i2);
                break;
            case R.id.image_phone :
                Intent i3 =new Intent(getApplicationContext() , PhneActivity.class);
                startActivity(i3);
                break;
        }

    }
    @Override
    protected void onResume() {
        super.onResume();
        trackScreen("main screen");

    }


    @Override
    protected void onDestroy() {
        time2 = System.currentTimeMillis();
        timeEvent(time1 , time2);
        super.onDestroy();
        //   time2 = System.currentTimeMillis();
    }
    public  void  timeEvent(long t1 , long t2){
        timeResult = (t2 - t1);
        Bundle params = new Bundle();
        params.putString("userid", UUID.randomUUID().toString());
        params.putLong("time_spend", timeResult);
        mFirebaseAnalytics.logEvent("timeMainScreen", params);

    }
}