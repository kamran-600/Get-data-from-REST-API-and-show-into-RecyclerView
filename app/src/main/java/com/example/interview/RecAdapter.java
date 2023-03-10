package com.example.interview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.Collection;

public class RecAdapter extends RecyclerView.Adapter<RecAdapter.Viewholder> implements Filterable {

    Context context;
    ArrayList<DataModal.Subdata> list;
    ArrayList<DataModal.Subdata> backup;

    public RecAdapter(Context context, ArrayList<DataModal.Subdata> list) {
        this.context = context;
        this.list = list;
        backup = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public RecAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.single_row,parent,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecAdapter.Viewholder holder, int position) {
        Glide.with(context).load(list.get(position).getFlag()).into(holder.imageView);
        holder.name.setText(list.get(position).getCountries_name());
        holder.code.setText(list.get(position).getCountry_code());

        holder.itemView.setOnClickListener(v -> {

            Toast.makeText(context, position + 1 +" element is clicked", Toast.LENGTH_SHORT).show();
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter = new Filter() {
        // run on Background thread
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<DataModal.Subdata> filteredlist = new ArrayList<>();
            if(constraint.toString().isEmpty()){
                filteredlist.addAll(backup);
            }
            else {
                for(DataModal.Subdata obj : backup){
                    if(obj.getCountries_name().toLowerCase().contains(constraint.toString().toLowerCase())){
                        filteredlist.add(obj);
                    }
                }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredlist;
            return filterResults;
        }

        // run on main UI thread
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
                list.clear();
                list.addAll((Collection<? extends DataModal.Subdata>) results.values);
                notifyDataSetChanged();
        }
    };

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
