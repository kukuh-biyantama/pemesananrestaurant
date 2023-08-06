package com.example.pilihmenuresto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class PesananActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pesanan)
        // Retrieve the data from the Intent
        val selectedMenu = intent.getParcelableExtra<Menu>("selected_menu")
        val quantity = intent.getIntExtra("quantity", 0)

        // Set the retrieved data to the corresponding TextViews in the layout
        val menuPesanan: TextView = findViewById(R.id.menuPesanan)
        val totalPesanan: TextView = findViewById(R.id.totalPesanan)

        // Check if the selectedMenu is not null before displaying its data
        if (selectedMenu != null) {
            menuPesanan.text = selectedMenu.listMenu
            // Calculate the total price based on the selected menu and quantity
            val totalPrice = selectedMenu.listHarga * quantity
            totalPesanan.text = "Rp. $totalPrice"
        }

        // Handle the "kembali kehalaman" button click (if needed)
        val backButton: Button = findViewById(R.id.back)
        backButton.setOnClickListener {
            val moveForResultIntent = Intent(this@PesananActivity, MainActivity::class.java)
            startActivity(moveForResultIntent)
        }
    }
}