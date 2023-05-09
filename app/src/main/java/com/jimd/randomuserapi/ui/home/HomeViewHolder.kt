package com.jimd.randomuserapi.ui.home

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.jimd.randomuserapi.data.local.entities.ResultadoEntity
import com.jimd.randomuserapi.databinding.ItemMainBinding
import com.jimd.randomuserapi.domain.model.ResultadoModel
import com.squareup.picasso.Picasso

class HomeViewHolder(itemView: View):ViewHolder(itemView) {

    val binding = ItemMainBinding.bind(itemView)

    fun render(resultadoEntity: ResultadoEntity,onClick:(ResultadoEntity)->Unit,onPerfil:(ResultadoEntity)->Unit){
        binding.txtNombreMain.text = resultadoEntity.name
        binding.txtEmailMain.text = resultadoEntity.email
        Picasso.get().load(resultadoEntity.picture).into(binding.imgRV)
        binding.btnDeleteUserImg.setOnClickListener { onClick(resultadoEntity) }
        itemView.setOnClickListener { onPerfil(resultadoEntity) }
    }

}