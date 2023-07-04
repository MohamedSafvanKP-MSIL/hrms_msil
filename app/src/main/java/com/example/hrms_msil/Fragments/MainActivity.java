package com.example.hrms_msil.Fragments;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.hrms_msil.Home.HomeFragment;
import com.example.hrms_msil.Inbox.InboxFragment;
import com.example.hrms_msil.Leaves.LeavesFragment;
import com.example.hrms_msil.Profile.ProfileFragment;
import com.example.hrms_msil.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;

    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private LeavesFragment leavesFragment;
    private InboxFragment inboxFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frameLayout);

        homeFragment = new HomeFragment();
        profileFragment = new ProfileFragment();
        leavesFragment = new LeavesFragment();
        inboxFragment = new InboxFragment();

        setFragment(homeFragment);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.menu_home) {
                    setFragment(homeFragment);
                    return true;
                } else if (item.getItemId() == R.id.menu_profile) {
                    setFragment(profileFragment);
                    return true;
                } else if (item.getItemId() == R.id.menu_leaves) {
                    setFragment(leavesFragment);
                    return true;
                } else if (item.getItemId() == R.id.menu_inbox) {
                    setFragment(inboxFragment);
                    return true;
                }
                return false;
            }
        });

    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
}
