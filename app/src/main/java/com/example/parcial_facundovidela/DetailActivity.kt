package com.example.parcial_facundovidela

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var textViewMarca2: TextView
    private lateinit var textViewModelo2: TextView
    private lateinit var textViewPotencia2: TextView
    private lateinit var textViewVelocidadMax2: TextView
    private lateinit var imageViewTipo2: ImageView
    private lateinit var imageViewURL2: ImageView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        textViewMarca2 = findViewById(R.id.textViewMarca2)
        textViewModelo2 = findViewById(R.id.textViewModelo2)
        textViewPotencia2 = findViewById(R.id.textViewPotencia2)
        textViewVelocidadMax2 = findViewById(R.id.textViewVelocidadMax2)
        imageViewTipo2 = findViewById(R.id.imageViewTipo2)
        imageViewURL2 = findViewById(R.id.imageViewURL2)


        val bundle = intent.extras
        val marca = bundle?.getString("marca", "")
        val modelo = bundle?.getString("modelo") ?: ""
        val potencia = bundle?.getInt("potencia", 0)
        val velocidadMax = bundle?.getInt("velocidadMax", 0)
        val tipo = bundle?.getString("tipo") ?: ""
        val url = bundle?.getString("url") ?: ""

        textViewMarca2.text = "Marca: " + marca
        textViewModelo2.text = "Modelo: " + modelo
        textViewPotencia2.text = "Potencia: " + potencia.toString() + "HP"
        textViewVelocidadMax2.text = "Velocidad Maxima: " + velocidadMax.toString()


        val image = when (tipo) {
            "SUV" -> R.drawable.suv
            "DEPORTIVO" -> R.drawable.deportivo
            "SEDAN" -> R.drawable.sedan
            "COMPACTOS" -> R.drawable.compactos
            "PICKUP" -> R.drawable.pickup
            else -> R.drawable.ic_launcher_foreground
        }

        imageViewTipo2.setImageResource(image)


        Glide.with(applicationContext)
            .load(url)
            .into(imageViewURL2)
    }
}