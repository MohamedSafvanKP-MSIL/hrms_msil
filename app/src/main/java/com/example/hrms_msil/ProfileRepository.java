package com.example.hrms_msil;

import android.app.Application;

import androidx.lifecycle.LiveData;

public class ProfileRepository {

    private ProfileDao profileDao;

    public ProfileRepository(Application application) {
        ProfileDatabase database = ProfileDatabase.getInstance(application);
        profileDao = database.profileDao();
    }

    public LiveData<Profile> getProfile() {
        return profileDao.getProfile();
    }

    public void saveProfile(Profile profile) {
        ProfileDatabase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                profileDao.saveProfile(profile);
            }
        });
    }
}
