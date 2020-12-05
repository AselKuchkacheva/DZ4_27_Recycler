package com.example.dz4_27_recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    public RecyclerClick recyclerClick;
    public List<String> list;
    private Context context;


    public MainAdapter(List<String> list, Context context, RecyclerClick recyclerClick) {
        this.list = list;
        this.context = context;
        this.recyclerClick = recyclerClick;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);
        return new MainViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        holder.textView.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void saveChangedItem(int position, String text) {
        list.set(position,text);
        notifyItemChanged(position);
    }

    class MainViewHolder extends RecyclerView.ViewHolder{
    TextView textView;
    public MainViewHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.textViewItem);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerClick.onRecyclerClick(getAdapterPosition());
            }
        });
    }
}
}