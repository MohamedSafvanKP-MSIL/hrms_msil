package com.example.hrms_msil;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
 @Insert
 void insertUser(User user);

 @Update
 void updateUser(User user);

 @Delete
 void deleteUser(User user);

 @Query(value = "SELECT * FROM user")
 List<User>getAllUser();

}
