package com.example.hrms_msil;

import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;


public class ProfileFragment extends Fragment {

    private TextView nameTextView;
    private TextView ageTextView;
    private TextView qualificationTextView;
    private TextView workExperienceTextView;
    private TextView softSkillsTextView;
    private ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButton5;
    private Button logoutButton;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_profile, container, false);

        nameTextView = view.findViewById(R.id.nameTextView);
        ageTextView = view.findViewById(R.id.ageTextView);
        qualificationTextView = view.findViewById(R.id.qualificationTextView);
        workExperienceTextView =view. findViewById(R.id.workExperienceTextView);
        softSkillsTextView = view.findViewById(R.id.softSkillsTextView);;
        logoutButton =view. findViewById(R.id.logout_button);

        imageButton1=view.findViewById(R.id.imageButton1);
        imageButton2=view.findViewById(R.id.imageButton2);
        imageButton3=view.findViewById(R.id.imageButton3);
        imageButton4=view.findViewById(R.id.imageButton4);
        imageButton5=view.findViewById(R.id.imageButton5);


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_name, null);

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
                bottomSheetDialog.setContentView(bottomSheetView);

                bottomSheetDialog.show();
            }
        });
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_name, null);

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
                bottomSheetDialog.setContentView(bottomSheetView);

                bottomSheetDialog.show();
            }
        });
        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_qualification, null);

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
                bottomSheetDialog.setContentView(bottomSheetView);

                bottomSheetDialog.show();
            }
        });
        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_work, null);

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
                bottomSheetDialog.setContentView(bottomSheetView);

                bottomSheetDialog.show();
            }
        });
        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_soft, null);

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
                bottomSheetDialog.setContentView(bottomSheetView);

                bottomSheetDialog.show();
            }
        });


        return view;
    }
}