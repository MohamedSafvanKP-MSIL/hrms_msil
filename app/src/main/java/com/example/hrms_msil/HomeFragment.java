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

import com.example.hrms_msil.pojo.AnnouncementsItem;
import com.example.hrms_msil.pojo.HolidaysItem;
import com.example.hrms_msil.pojo.HomeResponse;
import com.example.hrms_msil.pojo.WorkAnniversaryItem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class HomeFragment extends Fragment {

    RecyclerView recyclerView1,recyclerView2,recyclerView3;
    HomeAdapter homeAdapter;
    HolidayAdapter holidayAdapter;
    AnnounceAdapter announceAdapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView1 = view.findViewById(R.id.recyclerview1);
        recyclerView2 = view.findViewById(R.id.recyclerview2);
        recyclerView3 = view.findViewById(R.id.recyclerview3);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        handle();
    }

    private void handle() {
        HomeApi  api = HomeClientInstance.getRetrofitInstances().create(HomeApi.class);


        Call<HomeResponse> call = api.getAllData();
        call.enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(Call<HomeResponse> call, Response<HomeResponse> response) {
                if (response.isSuccessful()) {
                    HomeResponse workAnniversary = response.body();
                    List<HolidaysItem> holidays = workAnniversary.getData().getHolidays();
                    List<AnnouncementsItem> announcements = workAnniversary.getData().getAnnouncements();
                    List<WorkAnniversaryItem> workAnn = workAnniversary.getData().getWorkAnniversary();

                    homeAdapter = new HomeAdapter(workAnn);
                    recyclerView1.setAdapter(homeAdapter);
                    recyclerView1.setLayoutManager(new LinearLayoutManager(getContext()));

                    holidayAdapter = new HolidayAdapter(holidays);
                    recyclerView2.setAdapter(holidayAdapter);
                    recyclerView2.setLayoutManager(new LinearLayoutManager(getContext()));

                    announceAdapter = new AnnounceAdapter(announcements);
                    recyclerView3.setAdapter(announceAdapter);
                    recyclerView3.setLayoutManager(new LinearLayoutManager(getContext()));


                } else {
                    Toast.makeText(requireContext(), response.message(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<HomeResponse> call, Throwable t) {
                Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}