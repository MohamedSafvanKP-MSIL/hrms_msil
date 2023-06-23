package com.example.hrms_msil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hrms_msil.pojo.AnnouncementsItem;

import java.util.List;

public class AnnounceAdapter extends RecyclerView.Adapter<AnnounceAdapter.ViewHolder> {

    private final List<AnnouncementsItem> announcements;

    public AnnounceAdapter(List<AnnouncementsItem> announcements) {
        this.announcements = announcements;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.announcements, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        AnnouncementsItem announcementsItem = announcements.get(position);
        holder.date1.setText(announcementsItem.getDate());
        holder.title.setText(announcementsItem.getTitle());
        holder.message.setText(announcementsItem.getMessage());
        holder.priority.setText(announcementsItem.getPriority());

    }

    @Override
    public int getItemCount() {
        return announcements.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView date1,title,message,priority;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date1 = itemView.findViewById(R.id.date1);
            title=itemView.findViewById(R.id.title);
            message=itemView.findViewById(R.id.message);
            priority=itemView.findViewById(R.id.priority);
        }
    }
}
