package com.jimd.randomuserapi.ui.home

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jimd.randomuserapi.data.local.entities.ResultadoEntity
import com.jimd.randomuserapi.databinding.ActivityMainBinding
import com.jimd.randomuserapi.ui.PerfilActivity
import com.jimd.randomuserapi.ui.UserRandomViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val viewModel: UserRandomViewModel by viewModels()
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnAddUsers.setOnClickListener {
            viewModel.getUser()
        }

        viewModel.loading.observe(this, Observer {
            binding.progressBarMain.isVisible = it
        })


        viewModel.getAllUser().observe(this, Observer {
            binding.RVUsers.layoutManager = LinearLayoutManager(this)
            binding.RVUsers.adapter = HomeAdapter(it,{borrar(it)},{onPerfil(it)})
        })

        binding.RVUsers.addOnScrollListener(object : RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy>0){
                    binding.btnAddUsers.hide()
                }else{
                    binding.btnAddUsers.show()
                }
                super.onScrolled(recyclerView, dx, dy)
            }
        })

    }
    fun borrar(resultadoEntity: ResultadoEntity){
        val alert = AlertDialog.Builder(this)
        alert.setTitle("BORRAR ELEMENTO")
        alert.setMessage("Seguro de borrar el usuario : ${resultadoEntity.name}?")
        alert.setCancelable(false)
        alert.setPositiveButton("BORRAR",DialogInterface.OnClickListener { dialog, which ->
            viewModel.deleteUser(resultadoEntity)
            Toast.makeText(this,"Usuario ${resultadoEntity.name} eliminado",Toast.LENGTH_LONG).show()
        })
       alert.setNegativeButton("CERRAR",null)
        alert.show()
    }
    fun onPerfil(resultadoEntity: ResultadoEntity){
        val intent = Intent(this,PerfilActivity::class.java)
        intent.putExtra("id",resultadoEntity.id)
        intent.putExtra("name",resultadoEntity.name)
        intent.putExtra("email",resultadoEntity.email)
        intent.putExtra("picture",resultadoEntity.picture)
        startActivity(intent)
    }
}