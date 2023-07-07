package com.example.hrms_msil;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {
    private static List<User> contactList;
    private static OnItemClickListener itemClickListener;

    public ContactAdapter(List<User> contactList, OnItemClickListener itemClickListener) {
        this.contactList = contactList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_data, parent, false);
        return new ContactViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder holder, int position) {
       User contact = contactList.get(position);
        holder.nameTextView.setText(contact.getUsername());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(contact);
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public interface OnItemClickListener{
        void onItemClick(User user);
    }

    public static class ContactViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;


        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.nameTextView);;

            nameTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        itemClickListener.onItemClick(contactList.get(position));
                    }
                }
            });
        }
    }
}
