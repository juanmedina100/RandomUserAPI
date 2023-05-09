package com.jimd.randomuserapi.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jimd.randomuserapi.R
import com.jimd.randomuserapi.data.local.entities.ResultadoEntity
import com.jimd.randomuserapi.domain.model.ResultadoModel

class HomeAdapter(private val lista:List<ResultadoEntity>,private val onClick:(ResultadoEntity)->Unit,
                  private val onPerfil:(ResultadoEntity)->Unit
                  ):RecyclerView.Adapter<HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_main,parent,false)
        return HomeViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return lista.size
    }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        val item = lista[position]
        holder.render(item,onClick,onPerfil)
    }
}