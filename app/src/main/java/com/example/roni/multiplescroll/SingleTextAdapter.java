package com.example.roni.multiplescroll;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by roni on 26/02/18.
 */

public class SingleTextAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<String> nameList;

    public SingleTextAdapter(Context context, ArrayList<String> nameList) {
        this.nameList = nameList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viewToBeCreated;
        viewToBeCreated = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_name, parent, false);
        return new NameViewHolder(viewToBeCreated);
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public void updateArray(ArrayList<String> arrayList){
        nameList.clear();
        nameList.addAll(arrayList);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        NameViewHolder viewHolder = (NameViewHolder) holder;
        final String name = nameList.get(position);
        viewHolder.name.setText(name);
    }

    public class NameViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_name)
        TextView name;

        public NameViewHolder(final View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
