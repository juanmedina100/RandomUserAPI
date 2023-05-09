package com.jimd.randomuserapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.jimd.randomuserapi.R
import com.jimd.randomuserapi.databinding.ActivityPerfilBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PerfilActivity : AppCompatActivity() {
    lateinit var binding:ActivityPerfilBinding
    val viewModel:UserRandomViewModel by viewModels()
    var id:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPerfilBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val extras = intent.extras
        id = extras?.getInt("id")!!.toInt()


        init()
    }
    fun init(){
        viewModel.getUserForID(id)
        viewModel.usuarioID.observe(this, Observer {
            binding.txtNamePerfil.text = it.name
            binding.txtEmailPerfil.text = it.email
            Picasso.get().load(it.picture).into(binding.imageView)
        })
    }
}