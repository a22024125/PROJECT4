package com.example.project4;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
    public Context context;
    private List<String> mListString;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTxt;
        public ImageView mimage;



        public ViewHolder(View itemView) {
            super(itemView);
            mTxt = (TextView) itemView.findViewById(R.id.txt);
            mimage = (ImageView) itemView.findViewById(R.id.image);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),mListString.get(getAdapterPosition()),Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public ViewAdapter(Context context, List<String> listString) {
        this.context = context;
        mListString = listString;
        Log.d("qq", "mListString is " + String.valueOf(mListString));
    }

    @NonNull
    @Override
    public ViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewAdapter.ViewHolder viewHolder, int i) {

        /*Glide.with(context)
                .load("https://i2.kknews.cc/SIG=2srln3q/174s80001n227snr9n00r.jpg")
                .placeholder(android.R.drawable.star_on)
                .error(R.color.white)
                .fitCenter()
                .into(viewHolder.mimage);*/

        Picasso.with(context)
                .load("https://i2.kknews.cc/SIG=2srln3q/174s80001n227snr9n00r.jpg")
                .centerCrop()
                .resize(320, 320)
                .into(viewHolder.mimage);

        viewHolder.mTxt.setText(mListString.get(i));

    }

    @Override
    public int getItemCount() {
        return mListString.size();
    }
}
