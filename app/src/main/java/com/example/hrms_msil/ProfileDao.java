package com.example.hrms_msil;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ProfileDao {

    @Query("SELECT * FROM profile_table LIMIT 1")
    LiveData<Profile> getProfile();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveProfile(Profile profile);
}
