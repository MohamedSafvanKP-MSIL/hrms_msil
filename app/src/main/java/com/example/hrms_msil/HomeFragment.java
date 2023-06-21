package com.example.hrms_msil;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    private RecyclerView recyclerView;
    private HomeApi api;
    private HomeAdapter homeAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handle();
    }

    private void handle() {
        api = HomeClientInstance.getRetrofitInstances().create(HomeApi.class);


        Call<HomePojo> call = api.getAllData();
        call.enqueue(new Callback<HomePojo>() {
            @Override
            public void onResponse(Call<HomePojo> call, Response<HomePojo> response) {
                Log.d("Bala", String.valueOf(response));
                if (response.isSuccessful()) {
                    ArrayList<HomePojo.WorkAnniversary> workAnniversary = response.body().getWorkAnniversary();
                    ArrayList<HomePojo.Holidays> holidays = response.body().getHolidays();
                    ArrayList<HomePojo.Announcements> announcements = response.body().getAnnouncements();

                    homeAdapter = new HomeAdapter(workAnniversary,holidays,announcements);
                    recyclerView.setAdapter(homeAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
                } else {
                    Toast.makeText(requireContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<HomePojo> call, Throwable t) {
                Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}