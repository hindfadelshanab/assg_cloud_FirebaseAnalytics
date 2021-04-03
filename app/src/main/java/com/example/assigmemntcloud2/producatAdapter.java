package com.example.assigmemntcloud2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.analytics.FirebaseAnalytics;

import java.util.List;

public class producatAdapter extends RecyclerView.Adapter<producatAdapter.producateViewHolder> {

    private List<producate> mproducates;


Context context;
    private FirebaseAnalytics mFirebaseAnalytics;


    public producatAdapter(List<producate> producates,Context context) {
        this.mproducates = producates;
        this.context = context;
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    @NonNull
    @Override
    public producateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.producate_item, parent, false);
        return new producateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull producateViewHolder holder, int position) {
        holder.onBind(mproducates.get(position));
    }

    @Override
    public int getItemCount() {
        return mproducates.size();
    }


    public class producateViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName ;
        TextView textViewDescription ;
        TextView textViewPrice;
        ImageView imageView;

        public producateViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.text_name);
            textViewPrice = itemView.findViewById(R.id.text_price);
            textViewDescription = itemView.findViewById(R.id.text_des);
            imageView = itemView.findViewById(R.id.image_prodImage);

        }

        public void onBind(producate item) {
            textViewName.setText(item.getName());
            textViewPrice.setText(item.getPrice());
            textViewDescription.setText(item.getDescritpion());
            imageView.setImageResource(item.getImage());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    item.getId();
                    Log.e("hh2",item.getName());
                    Intent i = new Intent(context,DetailsProducateActivity.class);
                    i.putExtra("name",item.getName());
                    i.putExtra("des",item.getDescritpion());
                    i.putExtra("price",item.getPrice());
                    i.putExtra("id",item.getId());
                    i.putExtra("image",item.getImage());
                    context.startActivity(i);
                    SelectCntentEvent(item.getId(),item.getName());

                }
            });



        }
    }

    public  void  SelectCntentEvent(String id , String name ){
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, id);
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, name);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "producat item");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }
}
