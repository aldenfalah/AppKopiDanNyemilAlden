package com.example.appkopidannyemilalden

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AlamatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alamat)

        val etNamaPenerima = findViewById<EditText>(R.id.etNamaPenerima)
        val etAlamat = findViewById<EditText>(R.id.etAlamat)
        val etPatokan = findViewById<EditText>(R.id.etPatokan)

        etNamaPenerima.setText(UserData.namaLengkap)

        findViewById<Button>(R.id.btnOrder).setOnClickListener {
            val nama = etNamaPenerima.text.toString().trim()
            val alamat = etAlamat.text.toString().trim()
            val patokan = etPatokan.text.toString().trim()

            if (nama.isEmpty() || alamat.isEmpty() || patokan.isEmpty()) {
                Toast.makeText(this, "Semua kolom wajib diisi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, KonfirmasiActivity::class.java)
            intent.putExtra("nama_penerima", nama)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.navHome).setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
        findViewById<TextView>(R.id.navProfile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}