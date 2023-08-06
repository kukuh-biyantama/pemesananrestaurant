package com.example.pilihmenuresto


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataMenu = resources.getStringArray(R.array.daftarMenu)
        val dataDescription = resources.getStringArray(R.array.Description)
        val dataHarga = resources.getStringArray(R.array.Harga)
        val hargaIntList = dataHarga.map { it.toInt() }
        val dataPhoto = resources.obtainTypedArray(R.array.fotoMakanan)

        val listMakanan = ArrayList<Menu>()
        for (i in dataMenu.indices) {
            val menu = Menu(dataMenu[i], dataDescription[i], hargaIntList[i],dataPhoto.getResourceId(i, -1))
            listMakanan.add(menu)
        }
        dataPhoto.recycle()

        // Mengakses RecyclerView dari layout dengan ID rv_heroes
        val rvHeroes = findViewById<RecyclerView>(R.id.rv_menu)

        // Mengatur LinearLayoutManager sebagai layout manager untuk RecyclerView
        rvHeroes.layoutManager = LinearLayoutManager(this)

        // Mengatur ListHeroAdapter sebagai adapter untuk RecyclerView
        // Adapter digunakan untuk menghubungkan data (listHero) dengan tampilan di RecyclerView
        rvHeroes.adapter = AdapterMenuMakanan(listMakanan) { selectedMenu ->
            val intent = Intent(this@MainActivity, DetailActivity::class.java)
            intent.putExtra("selected_menu", selectedMenu)
            startActivity(intent)
        }



    }
}