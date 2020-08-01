package com.example.moapp.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moapp.R;
import com.example.moapp.REST.Model.Apps;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class MoListAdapter extends RecyclerView.Adapter<MoListAdapter.MoRecycleViewAdapterHolder> {
    private List<Apps> userList = new ArrayList<>();
    private Context context;


    public void setData(List<Apps> list, Context context) {
        userList.clear();
        userList.addAll(list);
        this.notifyDataSetChanged();
        this.context = context;
    }


    @SuppressLint("InflateParams")
    @NonNull
    @Override
    public MoRecycleViewAdapterHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View itemView;
        itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_users_layout, null);

        return new MoRecycleViewAdapterHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MoRecycleViewAdapterHolder holder, int position) {
        if (!userList.isEmpty()) {
            Apps model = userList.get(position);

            Animation animation = AnimationUtils.loadAnimation(context, R.anim.animation_from_right);
            holder.itemView.startAnimation(animation);

            holder.itemView.setOnClickListener((v) -> {
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(model.getApplicationUrl()));
                context.startActivity(i);
            });
            holder.initializeViews(model);
        }
    }


    @Override
    public int getItemCount() {
        return userList.size();
    }


    public static class MoRecycleViewAdapterHolder extends RecyclerView.ViewHolder {
        CardView cv;
        ImageView mImageView;
        TextView mTextViewUserName;
        TextView mTextViewUserBio;


        public MoRecycleViewAdapterHolder(View itemView) {
            super(itemView);

            cv = itemView.findViewById(R.id.card_view);
            mImageView = itemView.findViewById(R.id.user_avatar);
            mTextViewUserName = itemView.findViewById(R.id.user_name);
            mTextViewUserBio = itemView.findViewById(R.id.user_bio);
        }


        private void initializeViews(Apps model) {
            Picasso.get()
                    .load(model.getApplicationIcoUrl()).fit().centerInside()
                    .into(mImageView);
            mTextViewUserName.setText(model.getApplicationName());
            mTextViewUserBio.setText(model.getApplicationId());
        }
    }
}