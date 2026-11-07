package com.example.appkopidannyemilalden

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val nama = if (UserData.namaLengkap.isNotEmpty()) {
            UserData.namaLengkap.split(" ").joinToString(" ") { it.replaceFirstChar { c -> c.uppercase() } }
        } else "Teman"
        findViewById<TextView>(R.id.tvGreeting).text = "Halo $nama,"

        findViewById<TextView>(R.id.navOrder).setOnClickListener {
            startActivity(Intent(this, AlamatActivity::class.java))
        }

        findViewById<TextView>(R.id.navProfile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}