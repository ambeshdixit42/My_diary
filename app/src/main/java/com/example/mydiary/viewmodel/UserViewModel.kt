package com.example.mydiary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.mydiary.data.UserDatabase
import com.example.mydiary.repository.userRepository
import com.example.mydiary.model.user
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {

   val readAllData : LiveData<List<user>>
private val repository : userRepository
 init {
     val userDao = UserDatabase.getDatabase(application).userDao()
     repository = userRepository(userDao)
  readAllData = repository.readAllData
   }

    fun addUser(user : user){
        viewModelScope.launch(Dispatchers.IO){
            repository.addUser(user)
        }
    }
    fun updateUser(user:user){
        viewModelScope.launch(Dispatchers.IO){
            repository.updateUser(user)
        }
    }
    fun deleteUser(user: user){
        viewModelScope.launch ( Dispatchers.IO ){
            repository.deleteUser(user)
        }
    }
    fun deleteAllUsers(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllUsers()
        }
    }

}