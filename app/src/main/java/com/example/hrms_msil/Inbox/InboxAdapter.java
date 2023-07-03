package com.example.hrms_msil.Inbox;

import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hrms_msil.Inbox.InboxPojo;
import com.example.hrms_msil.R;

import java.util.ArrayList;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.ViewHolder> {
    private ArrayList<InboxPojo.data> inboxDataList;

    public InboxAdapter(ArrayList<InboxPojo.data> inboxDataList) {
        this.inboxDataList = inboxDataList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_data, parent, false);


        // Inflate your item layout and create a ViewHolder

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.post_data_updated, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        InboxPojo.data inboxData = inboxDataList.get(position);

        holder.title.setText(inboxData.getTitle());
        holder.message.setText(inboxData.getMessage());
        holder.date.setText(inboxData.getDate());
        holder.priority.setText(inboxData.getPriority());
//       holder.url.setText(inboxData.getUrl());


        holder.url.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String url = inboxData.getUrl();
                SpannableString spannableString = new SpannableString(url);
                holder.url.setText(spannableString);


                if (!TextUtils.isEmpty(url)) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    v.getContext().startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return inboxDataList .size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title,message,date,priority,url,likeCount;
        ImageView likeButton;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title=itemView.findViewById(R.id.title);
            message=itemView.findViewById(R.id.message);
            date=itemView.findViewById(R.id.date);
            priority=itemView.findViewById(R.id.priority);
            url=itemView.findViewById(R.id.url);
//            likeCount = itemView.findViewById(R.id.like_count);
//            likeButton = itemView.findViewById(R.id.like_icon);
        }
    }
}
