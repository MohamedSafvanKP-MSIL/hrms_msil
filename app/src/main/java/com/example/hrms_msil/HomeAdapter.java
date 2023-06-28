package com.example.hrms_msil;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.hrms_msil.pojo.WorkAnniversaryItem;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private final List<WorkAnniversaryItem> work;

    public HomeAdapter(List<WorkAnniversaryItem> work) {
        this.work = work;

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

        holder.name.setText(workAnniversary.getName());
        holder.empId.setText(workAnniversary.getEmpId());
        String  yrs = String.valueOf(workAnniversary.getYrs());
        holder.year.setText(yrs);


    }

    @Override
    public int getItemCount() {
        return work.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,empId,year;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.name);
            empId = itemView.findViewById(R.id.empid);
            year = itemView.findViewById(R.id.years);

        }
    }
}

