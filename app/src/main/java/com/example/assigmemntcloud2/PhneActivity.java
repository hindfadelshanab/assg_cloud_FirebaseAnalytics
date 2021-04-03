package com.example.assigmemntcloud2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.UUID;

public class PhneActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private FirebaseAnalytics mFirebaseAnalytics;
    private long time2;
    private long time1;
    private long timeResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phne);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        ArrayList<producate> producatesphone = new ArrayList<>();
        producatesphone.add(new producate("p1","s4","The best food photography pictures of Pexels. dlkldlkBrowse through fjjjjjjjjjjjj djfjdhigh quality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.phone));
        producatesphone.add(new producate("p2","s9","The best food photography pictures of Pexels. Browse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","62$",R.drawable.phone2));
        producatesphone.add(new producate("p3","s5","The high quality and royalty free stock photos of cakes, salads, beautifully decorated ","30$",R.drawable.phone3));
        producatesphone.add(new producate("p4","s8","The best food photography pictures of Pexels. uality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.phone4));
        producatesphone.add(new producate("p5","s1",". Browse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.phone5));
        producatesphone.add(new producate("p6","s83","The best food photography pictures cakes, salads, beautifully decorated ","12$",R.drawable.phone5));
        producatesphone.add(new producate("p7","s3","The best food photography pictures of Pexels. Browse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.phone6));
        producatesphone.add(new producate("p8","s10","The best food photography","12$",R.drawable.phone7));
        producatesphone.add(new producate("p9","s7","The best food photography pictures of Pexels. Browse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.phone8));

        recyclerView = findViewById(R.id.recyclerView_phone);
        producatAdapter producatAdapter = new producatAdapter(producatesphone,this);
        recyclerView.setAdapter(producatAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        time1 = System.currentTimeMillis();

    }
    @Override
    protected void onResume() {
        super.onResume();
        trackScreen("phone screen");
    }

    public  void trackScreen(String screenname){
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME,screenname );
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "PhneActivity");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SCREEN_VIEW, bundle);
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
        mFirebaseAnalytics.logEvent("timePhoneScreen", params);

    }
}