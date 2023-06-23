package com.example.hrms_msil;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    public int uid;
    @ColumnInfo(name = "email")
    public  String email;
    @ColumnInfo(name = "mPin")
    public String mPin;

    public User() {
    }

    public User(String email, String mPin) {
        this.email = email;
        this.mPin = mPin;
    }

    public int getUid() {
        return uid;
    }



    public  String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getmPin() {
        return mPin;
    }

    public void setmPin(String mPin) {
        this.mPin = mPin;
    }
}
