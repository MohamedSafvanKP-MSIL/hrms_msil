package com.example.hrms_msil;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ProfileViewModel extends AndroidViewModel {

        private ProfileRepository profileRepository;
        private LiveData<Profile> profileLiveData;

        public ProfileViewModel(@NonNull Application application) {
            super(application);
            profileRepository = new ProfileRepository(application);
            profileLiveData = profileRepository.getProfile();
        }

        public LiveData<Profile> getProfile() {
            return profileLiveData;
        }

        public void saveProfile(Profile profile) {
            profileRepository.saveProfile(profile);
        }
    }

