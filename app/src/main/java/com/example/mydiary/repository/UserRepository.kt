package com.example.mydiary.repository

import androidx.lifecycle.LiveData
import com.example.mydiary.data.UserDao
import com.example.mydiary.model.user

class userRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<user>> = userDao.readAllData()

    suspend fun addUser(user : user) {
        userDao.addUser(user)
    }
    suspend fun updateUser(user: user){
        userDao.updateUser(user)
    }
    suspend fun deleteUser(user: user){
        userDao.deleteUser(user)
    }
    suspend fun deleteAllUsers(){
        userDao.deleteAllUsers()
    }

}