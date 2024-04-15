package com.example.cardview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class GameAdapter(val gameList:ArrayList<GameModel>):RecyclerView.Adapter<GameAdapter.ViewHolder>() {
    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        var gameTitle:TextView
        var icon:ImageView
        init {
            gameTitle=itemView.findViewById(R.id.cardTxt)
            icon=itemView.findViewById(R.id.cardViewImg)
            itemView.setOnClickListener{
                Toast.makeText(itemView.context,gameTitle.text,Toast.LENGTH_SHORT).show()
            }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val i = LayoutInflater.from(parent.context).inflate(R.layout.card_item_layout,parent,false)
        return ViewHolder(i)
    }

    override fun getItemCount(): Int {
        return gameList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.gameTitle.text=gameList[position].title
        holder.icon.setImageResource(gameList[position].icon)

    }

}