package com.example.parcial_facundovidela

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: VolkswagenAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = VolkswagenAdapter(applicationContext)
        recyclerView.adapter = adapter

        adapter.submitList(getListadoVehiculos())
        adapter.onItemClickListener = { vehiculo ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra("modelo", vehiculo.modelo)
            intent.putExtra("marca", vehiculo.marca)
            intent.putExtra("potencia", vehiculo.potencia)
            intent.putExtra("velocidadMax", vehiculo.velocidadMax)
            intent.putExtra("tipo", vehiculo.tipo.name)
            intent.putExtra("url", vehiculo.url)
            startActivity(intent)
        }

    }

    private fun getListadoVehiculos(): MutableList<Vehiculos>? {
        return mutableListOf(
            Vehiculos(1, "Volkswagen", "Amarok V6", 258, 190, TipoVehiculo.PICKUP, "https://cdn.motor1.com/images/mgl/kolVen/374:0:2249:1688/critica-volkswagen-amarok-v6-highline-restyling-2024.webp"),
            Vehiculos(2, "Volkswagen", "Taos", 150, 190, TipoVehiculo.SUV, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSRPT-wbT1jeunULOg0zUJmKVBynGs6LTVXUQ&s"),
            Vehiculos(3, "Volkswagen", "T-Cross", 110, 180, TipoVehiculo.SUV, "https://resizer.glanacion.com/resizer/v2/que-cambios-trajo-la-nueva-version-del-t-DCCM34YNHNFN5K7IQZK7GI6CQA.jpg?auth=b83d117e891decfa2fbcae2d50e1feac2b1835c99de5841aad9163703df45e18&width=1280&height=854&quality=70&smart=true"),
            Vehiculos(4, "Volkswagen", "Nivus", 116, 189, TipoVehiculo.SUV, "https://www.opencars.com.ar/wp-content/uploads/2020/11/7.jpg"),
            Vehiculos(5, "Volkswagen", "Polo", 110, 185, TipoVehiculo.COMPACTOS, "https://storage.googleapis.com/carmuv-development.appspot.com/1/2023/08/Volkswagen-Polo-2023-03.jpg"),
            Vehiculos(6, "Volkswagen", "Virtus", 150, 190, TipoVehiculo.SEDAN, "https://media.cdn.puntobiz.com.ar/102023/1697820689938.webp?cw=984&ch=553&extw=jpg"),
            Vehiculos(7, "Volkswagen", "Vento GLI", 230, 250, TipoVehiculo.DEPORTIVO, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQOg2qhnn6GqyUBCdBJYy9YRIyVO1gewQR9vQ&s"),
            Vehiculos(8, "Volkswagen", "Golf GTI", 245, 250, TipoVehiculo.DEPORTIVO, "https://cdn.motor1.com/images/mgl/Qem2ZO/s3/volkswagen-golf-gti-2024.webp"),
            Vehiculos(9, "Volkswagen", "Tiguan Allspace", 180, 200, TipoVehiculo.SUV, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRx2nV9Cr_8k0AbyAmOM1_jooBDh4NSr1vP1w&s"),
            Vehiculos(10, "Volkswagen", "Saveiro Cross", 110, 175, TipoVehiculo.PICKUP, "https://maquinac.com/wp-content/uploads/2018/05/Pick-Up-Volkswagen-Saveiro-Cross.jpg")
        )
    }
}