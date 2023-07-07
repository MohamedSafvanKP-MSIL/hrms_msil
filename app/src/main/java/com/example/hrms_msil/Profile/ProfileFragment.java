package com.example.hrms_msil.Profile;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.hrms_msil.Fragments.ContactActivity;
import com.example.hrms_msil.Login_signup.LoginActivity;
import com.example.hrms_msil.R;
import com.example.hrms_msil.User;
import com.example.hrms_msil.UserDatabase;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.List;


public class ProfileFragment extends Fragment {

    private TextView nameTextView;
    private TextView ageTextView;
    private TextView qualificationTextView;
    private TextView workExperienceTextView;
    private TextView softSkillsTextView;
    private TextView contactTextView;
    private Button logoutButton;
    private ImageView profile,edit1,edit2,edit3,edit4,edit5,edit6,contact;

    private SharedPreferences sharedPreference;



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        nameTextView = view.findViewById(R.id.nameTextView);
        contactTextView=view.findViewById(R.id.contactTextView);
        ageTextView = view.findViewById(R.id.ageTextView);
        qualificationTextView = view.findViewById(R.id.qualificationTextView);
        workExperienceTextView = view.findViewById(R.id.workExperienceTextView);
        softSkillsTextView = view.findViewById(R.id.softSkillsTextView);
        logoutButton = view.findViewById(R.id.logout_button);
        profile=view.findViewById(R.id.imageview);
        contact=view.findViewById(R.id.contact);

        edit1=view.findViewById(R.id.imageView1);
        edit2=view.findViewById(R.id.imageView2);
        edit3=view.findViewById(R.id.imageView3);
        edit4=view.findViewById(R.id.imageView4);
        edit5=view.findViewById(R.id.imageView5);
        edit6=view.findViewById(R.id.imageView6);
        UserDatabase userDatabase = UserDatabase.getDB(getContext());
        Bundle bundle = getArguments();
        String uid = bundle.getString("uid");
        List<User>idList=userDatabase.userDao().getByName(uid);
        nameTextView.setText(idList.get(0).getUsername());
        contactTextView.setText(idList.get(0).getContact());

//        if(LoginActivity.employeeId.equals(userDatabase.userDao().getByName())) {
//
//            String name = userDatabase.userDao().getAllUser().get(0).getUsername();
//            nameTextView.setText("" + name);
//        }
        sharedPreference=requireContext().getSharedPreferences("share", Context.MODE_PRIVATE);
//
//        String name=sharedPreference.getString("Name","");
//        nameTextView.setText(""+name);
//
        String age=sharedPreference.getString("Age","");
        ageTextView.setText(""+age);

        String qualification=sharedPreference.getString("Qualification","");
        qualificationTextView.setText(""+qualification);

        String work=sharedPreference.getString("Work Experience","");
        workExperienceTextView.setText(""+work);

        String soft=sharedPreference.getString("Soft Skills","");
        softSkillsTextView.setText(""+soft);

        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(requireContext(), ContactActivity.class);
                startActivity(intent);
            }
        });


        edit1.setOnClickListener(new View.OnClickListener() {
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
                            nameTextView.setText("" + editedName);
                            SharedPreferences.Editor editor=sharedPreference.edit();
                            editor.putString("Name",editedName);
                            editor.apply();
                            bottomSheetDialog.dismiss();
                        } else {
                            Toast.makeText(requireContext(), "Please enter a valid name", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                bottomSheetDialog.show();
            }
        });

        edit2.setOnClickListener(new View.OnClickListener() {
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
                            ageTextView.setText("" + editedAge);
                            SharedPreferences.Editor editor=sharedPreference.edit();
                            editor.putString("Age",editedAge);
                            editor.apply();
                            bottomSheetDialog.dismiss();
                        } else {
                            Toast.makeText(requireContext(), "Please enter a valid age", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                bottomSheetDialog.show();
            }
        });

      edit3.setOnClickListener(new View.OnClickListener() {
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
                            qualificationTextView.setText("" + editedQualification);
                            SharedPreferences.Editor editor=sharedPreference.edit();
                            editor.putString("Qualification",editedQualification);
                            editor.apply();
                            bottomSheetDialog.dismiss();
                        } else {
                            Toast.makeText(requireContext(), "Please select a qualification", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                bottomSheetDialog.show();
            }
        });

    edit4.setOnClickListener(new View.OnClickListener() {

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
                           workExperienceTextView.setText("" + editedWork);
                            SharedPreferences.Editor editor=sharedPreference.edit();
                            editor.putString("Work Experience",editedWork);
                            editor.apply();
                            bottomSheetDialog.dismiss();
                        } else {
                            Toast.makeText(requireContext(), "Please select a qualification", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                bottomSheetDialog.show();
            }
        });

        edit5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_soft, null);
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
                bottomSheetDialog.setContentView(bottomSheetView);

                CheckBox checkBox1 = bottomSheetView.findViewById(R.id.checkBox1);
                boolean checkbox1=sharedPreference.getBoolean("checkbox1",false);
                checkBox1.setChecked(checkbox1);
                CheckBox checkBox2 = bottomSheetView.findViewById(R.id.checkBox2);
                boolean checkbox2=sharedPreference.getBoolean("checkbox2",false);
                checkBox1.setChecked(checkbox2);
                CheckBox checkBox3 = bottomSheetView.findViewById(R.id.checkBox3);
                boolean checkbox3=sharedPreference.getBoolean("checkbox3",false);
                checkBox1.setChecked(checkbox3);
                CheckBox checkBox4 = bottomSheetView.findViewById(R.id.checkBox4);
                boolean checkbox4=sharedPreference.getBoolean("checkbox4",false);
                checkBox1.setChecked(checkbox4);
                CheckBox checkBox5 = bottomSheetView.findViewById(R.id.checkBox5);
                boolean checkbox5=sharedPreference.getBoolean("checkbox5",false);
                checkBox1.setChecked(checkbox5);

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
                            softSkillsTextView.setText("" + softSkills);
                            SharedPreferences.Editor editor=sharedPreference.edit();
                            editor.putBoolean("checkbox1",checkBox1.isChecked());
                            editor.putBoolean("checkbox2",checkBox1.isChecked());
                            editor.putBoolean("checkbox3",checkBox1.isChecked());
                            editor.putBoolean("checkbox4",checkBox1.isChecked());
                            editor.putBoolean("checkbox5",checkBox1.isChecked());
                            editor.putString("Soft Skills",softSkills);
                            editor.apply();
                            bottomSheetDialog.dismiss();
                        } else {
                            Toast.makeText(requireContext(), "Please select at least one skill", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                bottomSheetDialog.show();
            }
        });

        edit6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_contact, null);
                EditText editedContactEditText = bottomSheetView.findViewById(R.id.editText);
                Button editButton = bottomSheetView.findViewById(R.id.addbutton);

                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
                bottomSheetDialog.setContentView(bottomSheetView);

                editButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String editedContact = editedContactEditText.getText().toString().trim();
                        if (!editedContact.isEmpty()) {
                            if (editedContact.length() == 10) {
                                contactTextView.setText("" + editedContact);
                                SharedPreferences.Editor editor = sharedPreference.edit();
                                editor.putString("Contact No", editedContact);
                                editor.apply();
                                bottomSheetDialog.dismiss();
                            } else if(editedContactEditText.length()!=10)  {
                                editedContactEditText.setError("Please enter a 10-digit Contact Number");
                            }
                        } else {
                            Toast.makeText(requireContext(), "Please enter a valid Contact Number", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                bottomSheetDialog.show();
            }
        });


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(requireContext());
                builder.setTitle("Log Out?");
                builder.setMessage("Are you sure want to Log Out?");
                builder.setPositiveButton("LogOut", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(getContext(), LoginActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });


        return view;
    }


}
