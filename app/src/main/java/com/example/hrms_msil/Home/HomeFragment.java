package com.example.hrms_msil.Home;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.hrms_msil.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView1,recyclerView2,recyclerView3;
    private ProgressBar progressBar;
    private ImageView noInternetImageView;
    HomeAdapter homeAdapter;
    HolidayAdapter holidayAdapter;
    AnnounceAdapter announceAdapter;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        noInternetImageView = view.findViewById(R.id.no_internet_imageview);
        progressBar = view.findViewById(R.id.progress_bar);
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

        progressBar.setVisibility(View.VISIBLE);
        HomeApi api = HomeClientInstance.getRetrofitInstances().create(HomeApi.class);

        Call<HomeResponse> call = api.getAllData();
        call.enqueue(new Callback<HomeResponse>() {
            @Override
            public void onResponse(@NonNull Call<HomeResponse> call, @NonNull Response<HomeResponse> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful()) {
                    HomeResponse workAnniversary = response.body();
                    assert workAnniversary != null;
                    List<HolidaysItem> holidays = workAnniversary.getData().getHolidays();
                    List<AnnouncementsItem> announcements = workAnniversary.getData().getAnnouncements();
                    List<WorkAnniversaryItem> workAnn = workAnniversary.getData().getWorkAnniversary();

                    homeAdapter = new HomeAdapter(workAnn);
                    recyclerView1.setAdapter(homeAdapter);

                    recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));

                    holidayAdapter = new HolidayAdapter(holidays);
                    recyclerView2.setAdapter(holidayAdapter);
                    recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));

                    announceAdapter = new AnnounceAdapter(announcements);
                    recyclerView3.setAdapter(announceAdapter);
                    recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));



                } else {
                    noInternetImageView.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(@NonNull Call<HomeResponse> call, Throwable t) {
                Toast.makeText(requireContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                noInternetImageView.setVisibility(View.VISIBLE);
            }
        });
    }
}