package com.example.mydiary.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mydiary.model.user

@Dao
interface UserDao {

@Insert(onConflict = OnConflictStrategy.IGNORE)
suspend fun addUser(user: user)

@Update
suspend fun updateUser(user: user)

@Delete
suspend fun deleteUser(user:user)

@Query("DELETE FROM user_table")
suspend fun deleteAllUsers()

@Query("SELECT * FROM user_table ORDER BY id ASC")
fun readAllData(): LiveData<List<user>>


}