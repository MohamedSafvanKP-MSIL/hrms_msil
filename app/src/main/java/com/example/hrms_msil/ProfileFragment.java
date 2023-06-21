package com.example.hrms_msil;

import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;




public class ProfileFragment extends Fragment {

    private EditText etName, etAge, etQualification, etWorkExperience, etSoftSkills;
    private Button logout_button;
    private ImageButton imageButton1,imageButton2,imageButton3,imageButton4,imageButton5;

    private ProfileViewModel profileViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        etName = view.findViewById(R.id.name);
        etAge = view.findViewById(R.id.age);
        etQualification = view.findViewById(R.id.qualification);
        etWorkExperience = view.findViewById(R.id.work);
        etSoftSkills = view.findViewById(R.id.soft);
        logout_button = view.findViewById(R.id.logout_button);
        imageButton1=view.findViewById(R.id.imageButton1);
        imageButton2=view.findViewById(R.id.imageButton2);
        imageButton3=view.findViewById(R.id.imageButton3);
        imageButton4=view.findViewById(R.id.imageButton4);
        imageButton5=view.findViewById(R.id.imageButton5);




        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfile();
            }
        });

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
        });imageButton1.setOnClickListener(new View.OnClickListener() {
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        retrieveProfile();
    }

    private void retrieveProfile() {
        profileViewModel.getProfile().observe(getViewLifecycleOwner(), new Observer<Profile>() {
            @Override
            public void onChanged(Profile profile) {
                if (profile != null) {
                    etName.setText(profile.getName());
                    etAge.setText(String.valueOf(profile.getAge()));
                    etQualification.setText(profile.getQualification());
                    etWorkExperience.setText(profile.getWorkExperience());
                    etSoftSkills.setText(profile.getSoftSkills());
                }
            }
        });
    }

    private void saveProfile() {
        String name = etName.getText().toString().trim();
        String ageStr = etAge.getText().toString().trim();
        String qualification = etQualification.getText().toString().trim();
        String workExperience = etWorkExperience.getText().toString().trim();
        String softSkills = etSoftSkills.getText().toString().trim();

        if (name.isEmpty() || ageStr.isEmpty() || qualification.isEmpty() || workExperience.isEmpty() || softSkills.isEmpty()) {
            Toast.makeText(requireContext(), "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        int age = Integer.parseInt(ageStr);

        Profile profile = new Profile(name, age, qualification, workExperience, softSkills);
        profileViewModel.saveProfile(profile);
        Log.d("Profile", "Name: " + name);
        Log.d("Profile", "Age: " + age);
        Log.d("Profile", "Qualification: " + qualification);
        Log.d("Profile", "Work Experience: " + workExperience);
        Log.d("Profile", "Soft Skills: " + softSkills);

        Toast.makeText(requireContext(), "Profile saved", Toast.LENGTH_SHORT).show();
    }
}
