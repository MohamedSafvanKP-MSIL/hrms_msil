package com.example.hrms_msil;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import android.widget.ImageButton;
import android.widget.TextView;


import androidx.fragment.app.Fragment;

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

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        nameTextView = view.findViewById(R.id.nameTextView);
        ageTextView = view.findViewById(R.id.ageTextView);
        qualificationTextView = view.findViewById(R.id.qualificationTextView);
        workExperienceTextView = view.findViewById(R.id.workExperienceTextView);
        softSkillsTextView = view.findViewById(R.id.softSkillsTextView);
        logoutButton = view.findViewById(R.id.logout_button);

        imageButton1 = view.findViewById(R.id.imageButton1);
        imageButton2 = view.findViewById(R.id.imageButton2);
        imageButton3 = view.findViewById(R.id.imageButton3);
        imageButton4 = view.findViewById(R.id.imageButton4);
        imageButton5 = view.findViewById(R.id.imageButton5);

        String name = "Keerthana Devi";
        int age = 21;
        String qualification = "Bachelor's Degree";
        int workExperience = 1;
        String softSkills = "C++, Java, C";

        nameTextView.setText("Name: " + name);
        ageTextView.setText("Age: " + age);
        qualificationTextView.setText("Qualification: " + qualification);
        workExperienceTextView.setText("Work Experience: " + workExperience);
        softSkillsTextView.setText("Soft Skills: " + softSkills);


        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_name, null);
                EditText editedNameEditText = bottomSheetView.findViewById(R.id.editText);
                Button editButton = bottomSheetView.findViewById(R.id.addbutton);

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
                bottomSheetDialog.setContentView(bottomSheetView);

                editButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String editedName = editedNameEditText.getText().toString().trim();
                        if (!editedName.isEmpty()) {
                            nameTextView.setText("Name: " + editedName);
                            bottomSheetDialog.dismiss();
                        } else {
                            Toast.makeText(requireContext(), "Please enter a valid name", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                bottomSheetDialog.show();
            }
        });

        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_age, null);
                EditText editedAgeEditText = bottomSheetView.findViewById(R.id.editText);
                Button editButton = bottomSheetView.findViewById(R.id.addbutton);

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
                bottomSheetDialog.setContentView(bottomSheetView);

                editButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String editedAge = editedAgeEditText.getText().toString().trim();
                        if (!editedAge.isEmpty()) {
                            ageTextView.setText("Age: " + editedAge);
                            bottomSheetDialog.dismiss();
                        } else {
                            Toast.makeText(requireContext(), "Please enter a valid age", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                bottomSheetDialog.show();
            }
        });

        imageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_qualification, null);
                CheckBox checkBox1 = bottomSheetView.findViewById(R.id.checkBox);
                CheckBox checkBox2 = bottomSheetView.findViewById(R.id.checkBox2);
                CheckBox checkBox3 = bottomSheetView.findViewById(R.id.checkBox3);
                Button editButton = bottomSheetView.findViewById(R.id.button2);

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
                bottomSheetDialog.setContentView(bottomSheetView);

                editButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String editedQualification = "";

                        if (checkBox1.isChecked()) {
                            editedQualification = checkBox1.getText().toString();
                        } else if (checkBox2.isChecked()) {
                            editedQualification = checkBox2.getText().toString();
                        } else if (checkBox3.isChecked()) {
                            editedQualification = checkBox3.getText().toString();
                        }

                        if (!editedQualification.isEmpty()) {
                            qualificationTextView.setText("Qualification: " + editedQualification);
                            bottomSheetDialog.dismiss();
                        } else {
                            Toast.makeText(requireContext(), "Please select a qualification", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                bottomSheetDialog.show();
            }
        });

        imageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_work, null);
                CheckBox checkBox1 = bottomSheetView.findViewById(R.id.checkBox1);
                CheckBox checkBox2 = bottomSheetView.findViewById(R.id.checkBox2);
                CheckBox checkBox3 = bottomSheetView.findViewById(R.id.checkBox3);
                CheckBox checkBox4 = bottomSheetView.findViewById(R.id.checkBox4);
                Button editButton = bottomSheetView.findViewById(R.id.button);

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
                bottomSheetDialog.setContentView(bottomSheetView);

                editButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String editedWork = "";

                        if (checkBox1.isChecked()) {
                            editedWork = checkBox1.getText().toString();
                        } else if (checkBox2.isChecked()) {
                            editedWork = checkBox2.getText().toString();
                        } else if (checkBox3.isChecked()) {
                            editedWork = checkBox3.getText().toString();
                        } else if (checkBox4.isChecked()) {
                            editedWork=checkBox4.getText().toString();
                        }

                        if (!editedWork.isEmpty()) {
                           workExperienceTextView.setText("Work Experience: " + editedWork);
                            bottomSheetDialog.dismiss();
                        } else {
                            Toast.makeText(requireContext(), "Please select a qualification", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                bottomSheetDialog.show();
            }
        });

        imageButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_soft, null);
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
                bottomSheetDialog.setContentView(bottomSheetView);

                CheckBox checkBox1 = bottomSheetView.findViewById(R.id.checkBox1);
                CheckBox checkBox2 = bottomSheetView.findViewById(R.id.checkBox2);
                CheckBox checkBox3 = bottomSheetView.findViewById(R.id.checkBox3);
                CheckBox checkBox4 = bottomSheetView.findViewById(R.id.checkBox4);
                CheckBox checkBox5 = bottomSheetView.findViewById(R.id.checkBox5);

                Button editButton = bottomSheetView.findViewById(R.id.button);

                editButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        StringBuilder selectedSkills = new StringBuilder();
                        if (checkBox1.isChecked()) {
                            selectedSkills.append(checkBox1.getText()).append(", ");
                        }
                        if (checkBox2.isChecked()) {
                            selectedSkills.append(checkBox2.getText()).append(", ");
                        }
                        if (checkBox3.isChecked()) {
                            selectedSkills.append(checkBox3.getText()).append(", ");
                        }
                        if (checkBox4.isChecked()) {
                            selectedSkills.append(checkBox4.getText()).append(", ");
                        }
                        if (checkBox5.isChecked()) {
                            selectedSkills.append(checkBox5.getText()).append(", ");
                        }

                        String softSkills = selectedSkills.toString();
                        if (!softSkills.isEmpty()) {
                            softSkills = softSkills.substring(0, softSkills.length() - 2);
                            softSkillsTextView.setText("Soft Skills: " + softSkills);
                            bottomSheetDialog.dismiss();
                        } else {
                            Toast.makeText(requireContext(), "Please select at least one skill", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                bottomSheetDialog.show();
            }
        });
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4=new Intent(getContext(),LoginActivity.class);
                startActivity(intent4);
            }
        });


        return view;
    }
}
