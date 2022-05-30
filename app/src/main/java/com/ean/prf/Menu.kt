package com.ean.prf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val storage = Firebase.storage

        val menu= ArrayList<String>()
        val listRef = storage.reference.child("Menu")
        listRef.listAll()
            .addOnSuccessListener {
                for(i in it.items) {
                    menu.add(i.name+"")
                }
                Log.d("Firebase", "Files $menu")
            }

            .addOnFailureListener {
                Log.d("Firebase", "Error $it")
            }
        //----------------------------------------------------
        val boton_refrescar=findViewById<Button>(R.id.bt_refrescar_ap)
        boton_refrescar.setOnClickListener {
            val lista_de_productos = findViewById<ListView>(R.id.listview_ap_productos)
            val adaptCuentas = ArrayAdapter(this, android.R.layout.simple_list_item_1, menu)
            lista_de_productos.adapter = adaptCuentas
            /*lista_de_productos.setOnItemClickListener(){parent,view,position,id->
                var nombre_libro=parent.getItemAtPosition(position).toString()
                Toast.makeText(this,parent.getItemAtPosition(position).toString(),Toast.LENGTH_LONG).show()
                val intent= Intent(this,leer_pdf::class.java)
                //enviamos informacion extra a leer_pdf la cual es el nombre del libro
                intent.putExtra("TITULO LIBRO",nombre_libro)
                startActivity(intent)
            }*/
        }

    }
}