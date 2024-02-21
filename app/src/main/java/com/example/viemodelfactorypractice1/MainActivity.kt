package com.example.viemodelfactorypractice1

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.viemodelfactorypractice1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter : UserAdapter
    private lateinit var viewModel : UserViewModel
    private var list = ArrayList<User>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        getRecyclerView()
        binding.btnSave.setOnClickListener {
            getData()
            binding.etText.text.clear()
        }

        setData()
        setupViewModel()


    }

    private fun setupViewModel() {
        val userRepository = UserRepository()
        val factory = UserFactory(userRepository)
        viewModel = ViewModelProvider(this, factory)[UserViewModel::class.java]
        viewModel.getData()
        viewModel.userMutableLiveData.observe(this, Observer {
            adapter.setUserdata(it as ArrayList<User>)
        })
    }

    private fun getData() {
        val insert_data = binding.etText.text.toString()
        binding.tvShowName.text = insert_data

        val mySharedPreferences : SharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE)
        val editor = mySharedPreferences.edit()
        editor.apply{
            putString("data", insert_data)
                .apply()
        }
    }

    private fun setData(){
        val mySharedPreferences = getSharedPreferences("name", Context.MODE_PRIVATE)
        val showData = mySharedPreferences.getString("data", null)
        binding.tvShowName.text = showData
    }

    private fun getRecyclerView() {
        adapter = UserAdapter(list)
        binding.rcvName.adapter = adapter
        binding.rcvName.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
    }
}