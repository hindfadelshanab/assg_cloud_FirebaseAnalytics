package com.example.assigmemntcloud2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class FoodActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    List<producate> producatesFood;
    private producatAdapter producatAdapter;
    private FirebaseAnalytics mFirebaseAnalytics;
    long time1 ;
    long time2;
    long timeResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        producatesFood =new ArrayList<>();
        producatesFood.add(new producate("a1","pizaa","The best food photography pictures of Pexels. dlkldlkBrowse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.food1));
        producatesFood.add(new producate("a2","shawarma","The best food photography pictures of Pexels. Browse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","62$",R.drawable.food2));
        producatesFood.add(new producate("a3","pasta","The best food photography pictures of Pexels. Browse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","30$",R.drawable.food3));
        producatesFood.add(new producate("a4","burger","The best food photography pictures of Pexels. uality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.food4));
        producatesFood.add(new producate("a5","salad",". Browse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.food5));
        producatesFood.add(new producate("a6","sandwitch","The best food photography pictures of Pexels. Browse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.food6));
        producatesFood.add(new producate("a7","pizaa","The best food photography pictures of Pexels. Browse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.food7));
        producatesFood.add(new producate("a8","pasta","The best food photography pictures uality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.food4));
        producatesFood.add(new producate("a9","bshh","The best food photography pictures of Pexels. Browse through high quality and royalty free stock photos of cakes, salads, beautifully decorated ","12$",R.drawable.food5));

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        producatAdapter = new producatAdapter(producatesFood,this);
        recyclerView = findViewById(R.id.recyclerView);
       recyclerView.setAdapter(producatAdapter);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));

        time1 = System.currentTimeMillis();

    }

    @Override
    protected void onResume() {
        super.onResume();
        trackScreen("food screen");
    }

    public  void trackScreen(String screenname){
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.SCREEN_NAME,screenname );
        bundle.putString(FirebaseAnalytics.Param.SCREEN_CLASS, "FoodActivity");
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
        mFirebaseAnalytics.logEvent("timeFoodScreen", params);
        Log.e("time" ," Time Resulte food : " +timeResult );
        Log.e("time" ," Time 1  food: " +t1 );
        Log.e("time" ," Time 2  food: " +t2 );

    }
}