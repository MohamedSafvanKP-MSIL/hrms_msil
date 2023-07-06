package com.example.hrms_msil;


import android.content.Context;
import android.view.View;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
@Database(entities = {User.class},exportSchema = false,version = 2)
public abstract class UserDatabase extends RoomDatabase {
    private  static  final  String DB_NAME="userdata1";
    private static UserDatabase instance;
    public static synchronized UserDatabase getDB(Context context){
        if(instance==null){
           instance= Room.databaseBuilder(context,UserDatabase.class,DB_NAME)
                   .fallbackToDestructiveMigration()
                   .allowMainThreadQueries()
                   .build();
        }
        return instance;
    }
    public abstract  UserDao userDao();
}
