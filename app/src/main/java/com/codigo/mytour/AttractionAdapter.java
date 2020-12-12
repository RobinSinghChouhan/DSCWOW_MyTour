package com.codigo.mytour;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AttractionAdapter extends RecyclerView.Adapter<AttractionAdapter.MyViewHolder> {
    Activity mContext;
    List<AttractionClass> cards_list;

    public AttractionAdapter(Activity mContext, List<AttractionClass> cards_list) {
        this.mContext = mContext;
        this.cards_list = cards_list;
    }
    @NonNull
    @Override
    public AttractionAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.attraction_card,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AttractionAdapter.MyViewHolder holder, int position) {
        holder.title.setText(cards_list.get(position).getTitle());
        holder.desc.setText(cards_list.get(position).getDescription());
        Glide.with(mContext)
                .load(R.drawable.mainbg)
                .into(holder.img);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mContext.startActivity(new Intent(mContext,DetailedActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return cards_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        CardView card;
        TextView title,desc;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.img);
            title=itemView.findViewById(R.id.title);
            desc=itemView.findViewById(R.id.desc);
            card=itemView.findViewById(R.id.card);
        }
    }
}
