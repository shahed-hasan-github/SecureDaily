package com.shoppingapp.securedaily.app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val userList : ArrayList<User>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {



        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.user_item,
        parent,false )
        return MyViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentitem = userList[position]

        holder.noteTitle.text = currentitem.noteTitle
        holder.noteDes.text = currentitem.noteDes


    }

    override fun getItemCount(): Int {

        return userList.size
    }


    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val noteTitle : TextView = itemView.findViewById(R.id.tvnoteTitle)
        val noteDes : TextView = itemView.findViewById(R.id.tvnoteDes)



    }

}