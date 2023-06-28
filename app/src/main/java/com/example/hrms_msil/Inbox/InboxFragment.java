package com.example.hrms_msil.Inbox;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hrms_msil.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InboxFragment extends Fragment {

    private int currentLikes = 0;
    private boolean isLiked = false;
    private ImageView noInternetImageView;
    private RecyclerView recyclerView;


    private ProgressBar progressBar;
    private InboxApi api;

    private InboxAdapter inboxAdapter;


    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inbox, container, false);
        noInternetImageView = view.findViewById(R.id.no_internet_imageview);
        progressBar = view.findViewById(R.id.progress_bar);
        recyclerView = view.findViewById(R.id.recyclerview);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        super.onViewCreated(view, savedInstanceState);


        handle();
    }

    private void handle() {

        InboxApi api = InboxClientInstance.getRetrofitInstance().create(InboxApi.class);

        progressBar.setVisibility(View.VISIBLE);
        api = InboxClientInstance.getRetrofitInstance().create(InboxApi.class);


        InboxPojo inboxData = new InboxPojo();

        Call<InboxPojo> call = api.createPost(inboxData);
        call.enqueue(new Callback<InboxPojo>() {
            @Override

            public void onResponse(@NonNull Call<InboxPojo> call, @NonNull Response<InboxPojo> response) {


                progressBar.setVisibility(View.GONE);

                if (response.isSuccessful()) {
                    assert response.body() != null;
                    ArrayList<InboxPojo.data> inboxData1 = response.body().getData();


                    inboxAdapter = new InboxAdapter(inboxData1);
                    recyclerView.setAdapter(inboxAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

                    inboxAdapter = new InboxAdapter(inboxData1);
                    recyclerView.setAdapter(inboxAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
                } else {

                    noInternetImageView.setVisibility(View.VISIBLE);
                }
            }

            @Override

            public void onFailure(@NonNull Call<InboxPojo> call, @NonNull Throwable t) {

                progressBar.setVisibility(View.GONE);
                Toast.makeText(requireContext(), "Request failed" + t.getMessage(), Toast.LENGTH_SHORT).show();
                noInternetImageView.setVisibility(View.VISIBLE);

            }
        });
    }
}
