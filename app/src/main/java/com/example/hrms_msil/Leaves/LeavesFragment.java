package com.example.hrms_msil.Leaves;

import static com.github.mikephil.charting.utils.ColorTemplate.rgb;

import android.content.SharedPreferences;
import android.graphics.Color;
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

import com.example.hrms_msil.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

public class LeavesFragment extends Fragment {
    public static final int[] CUSTOM_COLORS = {
            rgb("#C5ACFC"),rgb("#648EFF")
    };
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

    private Button btnApplyLeave ;
    private SharedPreferences leavePrefss;

    private PieChart pieChartsl;
    private PieChart pieChartcl;
    private PieChart pieChartml;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_leaves, container, false);

        leavePrefss = requireContext().getSharedPreferences(LEAVE_PREFS_NAME, requireContext().MODE_PRIVATE);

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

        pieChartsl = rootView.findViewById(R.id.pieChartsl);
        setupPieChartsl();
        pieChartcl = rootView.findViewById(R.id.pieChartcl);
        setupPieChartcl();
        pieChartml = rootView.findViewById(R.id.pieChartml);
        setupPieChartml();
        return rootView;
    }

    private void showBottomSheet() {
        View bottomSheetView = getLayoutInflater().inflate(R.layout.bottom_sheet_leaves, null);

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(requireContext());
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

            // Refresh the pie charts after applying leave
            setupPieChartsl();
            setupPieChartcl();
            setupPieChartml();
        } else {
            Toast.makeText(requireContext(), "No more " + leaveType + " leaves available", Toast.LENGTH_SHORT).show();
        }
    }
    private void updateLeaveDetails(EditText etTotal, EditText etUsed, EditText etLeft, LeaveType leaveType) {
        etTotal.setText(String.valueOf(leaveType.getTotalLeaves()));
        etUsed.setText(String.valueOf(leaveType.getUsedLeaves()));
        etLeft.setText(String.valueOf(leaveType.getAvailableLeaves()));
    }

    private void saveLeaveDetails(LeaveType leaveType) {
        SharedPreferences.Editor editor = leavePrefss.edit();
        editor.putInt(leaveType.getName() + "_Used", leaveType.getUsedLeaves());
        editor.apply();

    }

    private void loadLeaveDetails(LeaveType leaveType) {
        int usedLeaves = leavePrefss.getInt(leaveType.getName() + "_Used", 0);
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
        setupPieChartsl();
        setupPieChartcl();
        setupPieChartml();
    }
    private void setupPieChartsl() {
        pieChartsl.setUsePercentValues(false); // Disable percentage values
        pieChartsl.getDescription().setEnabled(false);
        pieChartsl.setExtraOffsets(5, 10, 5, 5);
        pieChartsl.setDragDecelerationFrictionCoef(0.95f);
        pieChartsl.setDrawHoleEnabled(true);
        pieChartsl.setHoleColor(Color.TRANSPARENT);
        pieChartsl.setCenterTextColor(Color.BLACK);
        pieChartsl.setTransparentCircleRadius(61f);
        pieChartsl.setEntryLabelColor(Color.BLACK);

        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(sickLeave.getUsedLeaves(), "Used Leaves")); // Display used leaves count
        pieEntries.add(new PieEntry(sickLeave.getAvailableLeaves(), "Available Leaves")); // Display available leaves count

        PieDataSet dataSet = new PieDataSet(pieEntries, "In Sick Leaves Of 12");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setValueTextColor(Color.BLUE); // Set the label text color
        dataSet.setColors(CUSTOM_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLACK);


        pieChartsl.setData(data);
        pieChartsl.animateY(1500);

        Legend legend = pieChartsl.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);
    }

    private void setupPieChartcl() {
        pieChartcl.setUsePercentValues(false); // Disable percentage values
        pieChartcl.getDescription().setEnabled(false);
        pieChartcl.setExtraOffsets(5, 10, 5, 5);
        pieChartcl.setDragDecelerationFrictionCoef(0.95f);
        pieChartcl.setDrawHoleEnabled(true);
        pieChartcl.setHoleColor(Color.WHITE);
        pieChartcl.setCenterTextColor(Color.BLACK);
        pieChartcl.setTransparentCircleRadius(61f);
        pieChartcl.setEntryLabelColor(Color.BLACK);

        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(casualLeave.getUsedLeaves(), "Used Leaves")); // Display used leaves count
        pieEntries.add(new PieEntry(casualLeave.getAvailableLeaves(), "Available Leaves")); // Display available leaves count

        PieDataSet dataSet = new PieDataSet(pieEntries, "In Casual Leaves Of 13");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setValueTextColor(Color.BLUE);
        dataSet.setColors(CUSTOM_COLORS);
        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLACK);

        pieChartcl.setData(data);
        pieChartcl.animateY(1500);

        Legend legend = pieChartcl.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);
    }

    private void setupPieChartml() {
        pieChartml.setUsePercentValues(false);
        pieChartml.getDescription().setEnabled(false);
        pieChartml.setExtraOffsets(5, 10, 5, 5);
        pieChartml.setDragDecelerationFrictionCoef(0.95f);
        pieChartml.setDrawHoleEnabled(true);
        pieChartml.setHoleColor(Color.WHITE);
        pieChartml.setCenterTextColor(Color.BLACK);
        pieChartml.setTransparentCircleRadius(61f);
        pieChartml.setEntryLabelColor(Color.BLACK);

        List<PieEntry> pieEntries = new ArrayList<>();
        pieEntries.add(new PieEntry(medicalLeave.getUsedLeaves(), "Used Leaves"));
        pieEntries.add(new PieEntry(medicalLeave.getAvailableLeaves(), "Available Leaves"));
        PieDataSet dataSet = new PieDataSet(pieEntries, "In Medical Leaves Of 15");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(CUSTOM_COLORS);

        PieData data = new PieData(dataSet);
        data.setValueTextSize(10f);
        data.setValueTextColor(Color.BLACK);


        pieChartml.setData(data);
        pieChartml.animateY(1500);

        Legend legend = pieChartml.getLegend();
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        legend.setEnabled(true);
    }

}
