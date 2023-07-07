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

 @Query(value = "SELECT * from user where email In (:email)")
 List<User>getByEmail(String email);

 @Query(value="SELECT * FROM  user where uid In (:employeeId)")
 List<User>getByName(String employeeId);



 @Query("SELECT * FROM user WHERE username LIKE:searchQuery")
 List<User> searchUser(String searchQuery);



//@Query(value="select * from user where uid=User.uid")
// List<User>getMPin(int uid);
}
