package com.example.hrms_msil;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Profile.class}, version = 1, exportSchema = false)
public abstract class ProfileDatabase extends RoomDatabase {

    public abstract ProfileDao profileDao();

    private static volatile ProfileDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static ProfileDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (ProfileDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    ProfileDatabase.class, "profile_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}