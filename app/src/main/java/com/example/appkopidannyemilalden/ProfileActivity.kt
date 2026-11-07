package com.example.appkopidannyemilalden

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        val tvAvatar = findViewById<TextView>(R.id.tvAvatar)
        val etNama = findViewById<EditText>(R.id.etNama)

        findViewById<TextView>(R.id.tvUsername).text = "@" + UserData.username
        etNama.setText(UserData.namaLengkap)
        tampilkanNama(tvGreeting, tvAvatar)

        findViewById<Button>(R.id.btnSave).setOnClickListener {
            val namaBaru = etNama.text.toString().trim()
            if (namaBaru.isEmpty()) {
                Toast.makeText(this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            UserData.namaLengkap = namaBaru
            tampilkanNama(tvGreeting, tvAvatar)
            Toast.makeText(this, "Profile berhasil disimpan", Toast.LENGTH_SHORT).show()
        }

        findViewById<TextView>(R.id.navHome).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
        findViewById<TextView>(R.id.navOrder).setOnClickListener {
            startActivity(Intent(this, AlamatActivity::class.java))
        }
    }

    private fun tampilkanNama(tvGreeting: TextView, tvAvatar: TextView) {
        val nama = if (UserData.namaLengkap.isNotEmpty()) UserData.namaLengkap else "Teman"
        tvGreeting.text = "Halo $nama,"
        tvAvatar.text = nama.first().uppercase()
    }
}