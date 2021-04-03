package com.example.assigmemntcloud2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.UUID;

public class LaptopActivity extends AppCompatActivity {

    long time1 ;
    long time2;
    long timeResult;
    private RecyclerView recyclerView;
    private FirebaseAnalytics mFirebaseAnalytics;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        ArrayList<producate> producates = new ArrayList<>();
        producates.add(new producate("l1","hp1","lap lap lap lap lap lap alpppp The best food photography pictures of Pexels. dlkldlkBrowse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.laptop1));
        producates.add(new producate("l2","hp2","The best food photography pictures of Pexels.of cakes, salads, beautifully decorated ","62$",R.drawable.laptop2));
        producates.add(new producate("l3","laptop hp3","The best food photography pictures of Pexels. Browse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","30$",R.drawable.laptop3));
        producates.add(new producate("l4","laptop hp4","The best food photography pictures of Pexels. uality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.laptop4));
        producates.add(new producate("l5","laptop hp5",".  of cakes, salads, beautifully decorated ","12$",R.drawable.laptop5));
        producates.add(new producate("l6","laptop hp6","The best food photography pictures of Pexels. Browse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.laptop6));
        producates.add(new producate("l7","laptop hp7","The best food photography pictures ofBrowse through high quality and royalty free stock photos Pexels. Browse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.laptop8));
        producates.add(new producate("l8","laptop hp8","The best food photography pictures uality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.laptop2));
        producates.add(new producate("l9","laptop hp9","The best food photography pictures of Pexels. Browse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.laptop7));

        recyclerView = findViewById(R.id.recyclerView_laptop);
        producatAdapter producatAdapter = new producatAdapter(producates,this);
        recyclerView.setAdapter(producatAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
        mFirebaseAnalytics.logEvent("timeLaptopScreen", params);
        Log.e("time" ," Time Resulte  lap : " +timeResult );
        Log.e("time" ," Time 1 lap : " +t1 );
        Log.e("time" ," Time 2  lap : " +t2 );

    }

    @Override
    protected void onResume() {
        super.onResume();
        trackScreen("laptop screen");
    }

    public  void trackScreen(String screenname){
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME,screenname );
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "LaptopActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);


    }

}