package com.example.mydiary.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.mydiary.R
import com.example.mydiary.viewmodel.UserViewModel
import com.example.mydiary.model.user
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*


class AddFragment : Fragment() {
        private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        val view =  inflater.inflate(R.layout.fragment_add, container, false)
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        view.save.setOnClickListener {
            insertDataToDatabase()
        }

        return view
    }
          private fun insertDataToDatabase() {
              val date = date.text.toString()
              val content = content.text.toString()

              if(inputCheck(date,content)){
                  val user = user(0,date,content)
                  mUserViewModel.addUser(user)
                  Toast.makeText(requireContext(),"Successfully added!",Toast.LENGTH_LONG).show()

                  findNavController().navigate(R.id.action_addFragment_to_listFragment)
              }
              else {
                  Toast.makeText(
                      requireContext(),
                      "Please fill out all the fields.",
                      Toast.LENGTH_LONG
                  ).show()
              }
          }
    private fun inputCheck(date : String , content : String) : Boolean{
        return !(TextUtils.isEmpty(date) && TextUtils.isEmpty(content))
    }

}