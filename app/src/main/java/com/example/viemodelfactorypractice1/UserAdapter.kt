package com.example.viemodelfactorypractice1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter (var list: ArrayList<User>) : RecyclerView.Adapter<UserAdapter.MyViewHolder>() {
    inner class MyViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.tv_name)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.each_row, parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var user = list[position]
        holder.name.text = user.name
    }

    fun setUserdata(userList : ArrayList<User>){
        this.list = userList
    }
}