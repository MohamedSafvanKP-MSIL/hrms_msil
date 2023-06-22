package com.example.hrms_msil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hrms_msil.pojo.WorkAnniversaryItem;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private final List<WorkAnniversaryItem> work;
//    private ArrayList<HomePojo.Holidays> holiday;
//    private ArrayList<HomePojo.Announcements> announcement;

    public HomeAdapter(List<WorkAnniversaryItem> work) {
        this.work = work;
//        this.holiday = holiday;
//        this.announcement = announcement;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.get_data, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        WorkAnniversaryItem workAnniversary = work.get(position);
//        HomePojo.Holidays holidays = holiday.get(position);
//        HomePojo.Announcements announcements = announcement.get(position);

        holder.name.setText(workAnniversary.getName());
        holder.empId.setText(workAnniversary.getEmpId());
        String  yrs = String.valueOf(workAnniversary.getYrs());
        holder.year.setText(yrs);
//        holder.date.setText(holidays.getDate());
//        holder.occasion.setText(holidays.getOccasion());
//        holder.date1.setText(announcements.getDate());
//        holder.title.setText(announcements.getTitle());
//        holder.message.setText(announcements.getMessage());
//        holder.priority.setText(announcements.getPriority());

    }

    @Override
    public int getItemCount() {
        return work.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,empId,year,date,occasion,date1,title,message,priority;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            empId = itemView.findViewById(R.id.empid);
            year = itemView.findViewById(R.id.years);
//            date=itemView.findViewById(R.id.date);
//            occasion = itemView.findViewById(R.id.occasion);
//            date1 = itemView.findViewById(R.id.date1);
//            title=itemView.findViewById(R.id.title);
//            message=itemView.findViewById(R.id.message);
//            priority=itemView.findViewById(R.id.priority);

        }
    }
}
