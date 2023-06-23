package com.example.hrms_msil;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class LeavesFragment extends Fragment {

    private static final String LEAVE_PREFS_NAME = "LeavePrefs";
    private static final String SICK_LEAVE = "Sick Leave";
    private static final String CASUAL_LEAVE = "Casual Leave";
    private static final String MEDICAL_LEAVE = "Medical Leave";

    private LeaveType sickLeave;
    private LeaveType casualLeave;
    private LeaveType medicalLeave;

    private EditText etSickLeaveTotal, etSickLeaveUsed, etSickLeaveLeft;
    private EditText etCasualLeaveTotal, etCasualLeaveUsed, etCasualLeaveLeft;
    private EditText etMedicalLeaveTotal, etMedicalLeaveUsed, etMedicalLeaveLeft;

    private Button btnApplyLeave;
    private BottomSheetDialog bottomSheetDialog;

    private SharedPreferences leavePrefs;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leaves, container, false);

        leavePrefs = requireContext().getSharedPreferences(LEAVE_PREFS_NAME, requireContext().MODE_PRIVATE);

        sickLeave = new LeaveType(SICK_LEAVE, 12);
        casualLeave = new LeaveType(CASUAL_LEAVE, 13);
        medicalLeave = new LeaveType(MEDICAL_LEAVE, 15);

        etSickLeaveTotal = rootView.findViewById(R.id.etSickLeaveTotal);
        etSickLeaveUsed = rootView.findViewById(R.id.etSickLeaveUsed);
        etSickLeaveLeft = rootView.findViewById(R.id.etSickLeaveLeft);

        etCasualLeaveTotal = rootView.findViewById(R.id.etCasualLeaveTotal);
        etCasualLeaveUsed = rootView.findViewById(R.id.etCasualLeaveUsed);
        etCasualLeaveLeft = rootView.findViewById(R.id.etCasualLeaveLeft);

        etMedicalLeaveTotal = rootView.findViewById(R.id.etMedicalLeaveTotal);
        etMedicalLeaveUsed = rootView.findViewById(R.id.etMedicalLeaveUsed);
        etMedicalLeaveLeft = rootView.findViewById(R.id.etMedicalLeaveLeft);

        updateLeaveDetails(etSickLeaveTotal, etSickLeaveUsed, etSickLeaveLeft, sickLeave);
        updateLeaveDetails(etCasualLeaveTotal, etCasualLeaveUsed, etCasualLeaveLeft, casualLeave);
        updateLeaveDetails(etMedicalLeaveTotal, etMedicalLeaveUsed, etMedicalLeaveLeft, medicalLeave);

        btnApplyLeave = rootView.findViewById(R.id.btnApplyLeave);

        btnApplyLeave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet();
            }
        });

        return rootView;
    }

    private void showBottomSheet() {
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_leaves, null);

        bottomSheetDialog = new BottomSheetDialog(requireContext());
        bottomSheetDialog.setContentView(bottomSheetView);

        RadioGroup rgLeaveOptions = bottomSheetView.findViewById(R.id.rgLeaveOptions);
        Button btnApply = bottomSheetView.findViewById(R.id.btnApply);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = rgLeaveOptions.getCheckedRadioButtonId();
                if (selectedId != -1) {
                    RadioButton radioButton = bottomSheetDialog.findViewById(selectedId);
                    String selectedLeaveType = radioButton.getText().toString();
                    applyLeave(selectedLeaveType);

                    bottomSheetDialog.dismiss();
                } else {
                    Toast.makeText(requireContext(), "Select a type of leave", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bottomSheetDialog.show();
    }

    private void applyLeave(String leaveType) {
        LeaveType selectedLeaveType = null;

        switch (leaveType) {
            case SICK_LEAVE:
                selectedLeaveType = sickLeave;
                break;
            case CASUAL_LEAVE:
                selectedLeaveType = casualLeave;
                break;
            case MEDICAL_LEAVE:
                selectedLeaveType = medicalLeave;
                break;
        }

        if (selectedLeaveType != null && selectedLeaveType.getAvailableLeaves() > 0) {
            selectedLeaveType.reduceLeaveCount();
            String message = leaveType + " leave applied\n" +
                    "Leaves left: " + selectedLeaveType.getAvailableLeaves();
            Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();

            updateLeaveDetails(etSickLeaveTotal, etSickLeaveUsed, etSickLeaveLeft, sickLeave);
            updateLeaveDetails(etCasualLeaveTotal, etCasualLeaveUsed, etCasualLeaveLeft, casualLeave);
            updateLeaveDetails(etMedicalLeaveTotal, etMedicalLeaveUsed, etMedicalLeaveLeft, medicalLeave);

            saveLeaveDetails(selectedLeaveType);
        } else {
            Toast.makeText(requireContext(), "No more " + leaveType + " leaves available", Toast.LENGTH_SHORT).show();
        }
    }

    private void updateLeaveDetails(EditText etTotal, EditText etUsed, EditText etLeft, LeaveType leaveType) {
        etTotal.setText("Total Leaves: " + leaveType.getTotalLeaves());
        etUsed.setText("Used Leaves: " + leaveType.getUsedLeaves());
        etLeft.setText("Leaves Left: " + leaveType.getAvailableLeaves());
    }

    private void saveLeaveDetails(LeaveType leaveType) {
        SharedPreferences.Editor editor = leavePrefs.edit();
        editor.putInt(leaveType.getName() + "_Used", leaveType.getUsedLeaves());
        editor.apply();
    }

    private void loadLeaveDetails(LeaveType leaveType) {
        int usedLeaves = leavePrefs.getInt(leaveType.getName() + "_Used", 0);
        leaveType.setUsedLeaves(usedLeaves);
    }

    @Override
    public void onResume() {
        super.onResume();
        loadLeaveDetails(sickLeave);
        loadLeaveDetails(casualLeave);
        loadLeaveDetails(medicalLeave);
        updateLeaveDetails(etSickLeaveTotal, etSickLeaveUsed, etSickLeaveLeft, sickLeave);
        updateLeaveDetails(etCasualLeaveTotal, etCasualLeaveUsed, etCasualLeaveLeft, casualLeave);
        updateLeaveDetails(etMedicalLeaveTotal, etMedicalLeaveUsed, etMedicalLeaveLeft, medicalLeave);
    }
}
