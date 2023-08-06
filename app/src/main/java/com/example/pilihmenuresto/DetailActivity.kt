package com.example.pilihmenuresto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class DetailActivity : AppCompatActivity() {
    private var quantity = 0
    private lateinit var selectedMenu: Menu
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        // Retrieve the data from the Intent
        selectedMenu = intent.getParcelableExtra<Menu>("selected_menu")!!

        // Set the retrieved data to the corresponding views in the layout
        val imageMenuDetail: ImageView = findViewById(R.id.imageMenuDetail)
        val listMenuDetail: TextView = findViewById(R.id.listMenuDetail)
        val descriptionDetail: TextView = findViewById(R.id.descriptionDetail)
        val priceMenu: TextView = findViewById(R.id.priceMenu)

        // Check if the selectedMenu is not null before displaying its data
        if (selectedMenu != null) {
            // Set data to the views
            selectedMenu.listFoto?.let { imageMenuDetail.setImageResource(it) } // Set the image resource using the listFoto value
            listMenuDetail.text = selectedMenu.listMenu
            descriptionDetail.text = selectedMenu.listDescription
            priceMenu.text = "Rp. ${selectedMenu.listHarga}"
        }

        // Handle the "Tambah" button click
        val addQuantityButton: ImageButton = findViewById(R.id.addquantity)
        addQuantityButton.setOnClickListener {
            increaseQuantity()
        }

        // Handle the "Kurang" button click
        val subQuantityButton: ImageButton = findViewById(R.id.subquantity)
        subQuantityButton.setOnClickListener {
            decreaseQuantity()
        }

        // Handle the "Pesan" button click
        val buttonPesan: Button = findViewById(R.id.button2)
        buttonPesan.setOnClickListener {
            val intent = Intent(this@DetailActivity, PesananActivity::class.java)
            intent.putExtra("selected_menu", selectedMenu)
            intent.putExtra("quantity", quantity)
            startActivity(intent)
        }
    }
    private fun increaseQuantity() {
        quantity++
        updateQuantityTextView()
        updateTotalPrice()
    }

    private fun decreaseQuantity() {
        if (quantity > 0) {
            quantity--
            updateQuantityTextView()
            updateTotalPrice()
        }
    }

    private fun updateQuantityTextView() {
        val quantityTextView: TextView = findViewById(R.id.quantity)
        quantityTextView.text = quantity.toString()
    }

    private fun updateTotalPrice() {
        val priceMenu: TextView = findViewById(R.id.priceMenu)
        val totalPrice = selectedMenu.listHarga * quantity
        priceMenu.text = "Rp. $totalPrice"
    }
}

