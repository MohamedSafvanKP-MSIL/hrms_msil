package com.example.hrms_msil.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

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
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;
    private FrameLayout frameLayout;
    RelativeLayout snackLayout;

    private HomeFragment homeFragment;
    private ProfileFragment profileFragment;
    private LeavesFragment leavesFragment;
    private InboxFragment inboxFragment;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        frameLayout = findViewById(R.id.frameLayout);
        snackLayout=findViewById(R.id.snackBar_layout);

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
        if(checkConnection()){
            Snackbar snackbar=Snackbar.make(snackLayout,"network connected",Snackbar.LENGTH_LONG);
            snackbar.show();
        }
        else {
            Snackbar snackbar=Snackbar.make(snackLayout,"No Network",Snackbar.LENGTH_LONG);
            snackbar.show();        }

    }

    private void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit();
    }
    private boolean checkConnection(){
        ConnectivityManager connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
        if(networkInfo==null) {
            return false;
        }
            else{
            return  networkInfo.isConnected();
            }
        }

}
