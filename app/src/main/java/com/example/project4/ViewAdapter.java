package com.example.project4;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private List<String> mListString;

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mTxt;

        public ViewHolder(View itemView) {
            super(itemView);
            mTxt = (TextView) itemView.findViewById(R.id.txt);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Toast.makeText(view.getContext(),mListString.get(getAdapterPosition()),Toast.LENGTH_SHORT)
                    .show();
        }
    }

    public ViewAdapter(List<String> listString) {
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
        viewHolder.mTxt.setText(mListString.get(i));
    }

    @Override
    public int getItemCount() {
        return mListString.size();
    }
}
