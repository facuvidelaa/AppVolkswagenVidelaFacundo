package com.example.parcial_facundovidela

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class VolkswagenAdapter (val context: Context) : ListAdapter<Vehiculos, VolkswagenAdapter.ViewHolder>(DiffCallBack) {

    lateinit var onItemClickListener: (Vehiculos) -> Unit

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        private val marca : TextView = view.findViewById(R.id.textViewMarca)
        private val modelo: TextView = view.findViewById(R.id.textViewModelo)
        private val velocidadMax: TextView = view.findViewById(R.id.textViewVelocidad)
        private val potencia: TextView = view.findViewById(R.id.textViewPotencia)
        private val imagenTipo: ImageView = view.findViewById(R.id.imageViewTipo)
        private val imagenVehiculo: ImageView = view.findViewById(R.id.imageViewVehiculo)

        fun bind (vehiculos: Vehiculos) {
            marca.text = "Marca: " + vehiculos.marca
            modelo.text = "Modelo: " + vehiculos.modelo
            velocidadMax.text = "Velocidad Maxima: " + vehiculos.velocidadMax.toString()
            potencia.text = "Potencia: " + vehiculos.potencia.toString() + "HP"

            val image = when(vehiculos.tipo) {
                TipoVehiculo.SUV -> R.drawable.suv
                TipoVehiculo.DEPORTIVO -> R.drawable.deportivo
                TipoVehiculo.SEDAN -> R.drawable.sedan
                TipoVehiculo.COMPACTOS -> R.drawable.compactos
                TipoVehiculo.PICKUP -> R.drawable.pickup
            }

            imagenTipo.setImageResource(image)

            Glide.with(context)
                .load(vehiculos.url)
                .into(imagenVehiculo)

            view.setOnClickListener {
                onItemClickListener(vehiculos)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VolkswagenAdapter.ViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: VolkswagenAdapter.ViewHolder, position: Int) {
        val vehiculo = getItem(position)
        holder.bind(vehiculo)
    }

    companion object DiffCallBack : DiffUtil.ItemCallback<Vehiculos>() {
        override fun areItemsTheSame(oldItem: Vehiculos, newItem: Vehiculos): Boolean {
            return  oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Vehiculos, newItem: Vehiculos): Boolean {
            return oldItem == newItem
        }
    }
}