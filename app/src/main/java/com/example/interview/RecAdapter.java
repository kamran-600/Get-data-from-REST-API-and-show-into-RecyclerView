package com.example.interview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.Viewholder> {

    Context context;
    ArrayList<DataModal> list;

    public RecAdapter(Context context, ArrayList<DataModal> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_row,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecAdapter.Viewholder holder, int position) {
        holder.imageView.setImageResource(list.get(position).Subdata.getImage());
        holder.name.setText(list.get(position).Subdata.getCountryName());
        holder.code.setText(list.get(position).getCountryCode());

        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, position +"element is clicked", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public static class Viewholder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView name,code;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.countryName);
            code = itemView.findViewById(R.id.countryCode);

        }
    }

}
