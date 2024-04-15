package com.example.cardview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val recyclerView=findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager=LinearLayoutManager(this)

        val adapter=GameAdapter(gameList())
        recyclerView.adapter=adapter

    }
    private fun gameList(): ArrayList<GameModel> {
        return arrayListOf(
            GameModel("Gta 5",R.drawable.gtav),
            GameModel("Assassins Creed Identity",R.drawable.assassins),
            GameModel("Mortal Kombat 11",R.drawable.mortalkombat),
            GameModel("Spider-Man",R.drawable.spiderman),
            GameModel("FC24",R.drawable.fc24),
        )
    }
}