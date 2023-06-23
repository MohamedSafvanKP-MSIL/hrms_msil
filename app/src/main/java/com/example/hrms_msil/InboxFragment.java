package com.example.hrms_msil;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InboxFragment extends Fragment {
    private RecyclerView recyclerView;
    private InboxApi api;
    private InboxAdapter inboxAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inbox, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);


        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handle();
    }

    private void handle() {
        api = InboxClientInstance.getRetrofitInstance().create(InboxApi.class);

        InboxPojo inboxData = new InboxPojo();

        Call<InboxPojo> call = api.createPost(inboxData);
        call.enqueue(new Callback<InboxPojo>() {
            @Override
            public void onResponse(Call<InboxPojo> call, Response<InboxPojo> response) {
                if (response.isSuccessful()) {
                    ArrayList<InboxPojo.data> inboxData1 = response.body().getData();



                    inboxAdapter = new InboxAdapter(inboxData1);
                    recyclerView.setAdapter(inboxAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                    inboxAdapter = new InboxAdapter(inboxData1);
                    recyclerView.setAdapter(inboxAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
                } else {
                    Toast.makeText(requireContext(), "fail", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<InboxPojo> call, Throwable t) {
                Toast.makeText(requireContext(), "Request failed"+t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}