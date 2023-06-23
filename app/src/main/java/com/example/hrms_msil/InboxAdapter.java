package com.example.hrms_msil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.ViewHolder> {
    private ArrayList<InboxPojo.data> inboxDataList;

    public InboxAdapter(ArrayList<InboxPojo.data> inboxDataList) {
        this.inboxDataList = inboxDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        // Inflate your item layout and create a ViewHolder

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_data, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InboxPojo.data inboxData = inboxDataList.get(position);

        holder.title.setText(inboxData.getTitle());
        holder.message.setText(inboxData.getMessage());
        holder.date.setText(inboxData.getDate());
        holder.priority.setText(inboxData.getPriority());
        holder.url.setText(inboxData.getUrl());

    }

    @Override
    public int getItemCount() {
        return inboxDataList .size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,message,date,priority,url;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title);
            message=itemView.findViewById(R.id.message);
            date=itemView.findViewById(R.id.date);
            priority=itemView.findViewById(R.id.priority);
            url=itemView.findViewById(R.id.url);
        }
    }
}
