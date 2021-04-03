package com.example.assigmemntcloud2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.Date;
import java.util.UUID;

public class DetailsProducateActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textViewname;
    TextView textViewdes;
    TextView textViewprice ;
    long time1 ;
    long time2;
    long timeResult;
    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_producate);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);
        imageView=findViewById(R.id.imageViewd);
        textViewname = findViewById(R.id.named);
        textViewdes = findViewById(R.id.desd);
        textViewprice = findViewById(R.id.priced);
        textViewname.setText(getIntent().getStringExtra("name"));
        textViewprice.setText(getIntent().getStringExtra("price"));
        textViewdes.setText(getIntent().getStringExtra("des"));
        imageView.setImageResource(getIntent().getIntExtra("image",0));

        time1 = System.currentTimeMillis();

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
        mFirebaseAnalytics.logEvent("time", params);
        Log.e("time" ," Time Resulte : " +timeResult );
        Log.e("time" ," Time 1 : " +t1 );
        Log.e("time" ," Time 2 : " +t2 );
    }

    @Override
    protected void onResume() {
        super.onResume();
        trackScreen(" producat Details screen");
    }

    public  void trackScreen(String screenname){
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME,screenname );
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "DetailsProducateActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
    }

}