package com.example.hrms_msil.Home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hrms_msil.R;

import java.util.List;

public class HolidayAdapter extends RecyclerView.Adapter<HolidayAdapter.ViewHolder> {

    private final List<HolidaysItem> holiday;

    public HolidayAdapter(List<HolidaysItem> holiday) {
        this.holiday = holiday;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.holidays, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        HolidaysItem holidaysItem = holiday.get(position);
        holder.date.setText(holidaysItem.getDate());
        holder.occasion.setText(holidaysItem.getOccasion());

    }

    @Override
    public int getItemCount() {
        return holiday.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView date,occasion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            date=itemView.findViewById(R.id.date);
            occasion = itemView.findViewById(R.id.occasion);

        }
    }
}
