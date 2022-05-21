package com.ean.prf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.auth.FirebaseAuth

private lateinit var auth: FirebaseAuth;

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val boton_Registrase=findViewById<Button>(R.id.bn_entrar_am)
        boton_Registrase.setOnClickListener{
            val intent= Intent(this,Registrase::class.java)
            startActivity(intent)
        }*/
        val boton_Registrase = findViewById<Button>(R.id.bn_registrase_am)
        boton_Registrase.setOnClickListener {
            val intent = Intent(this,Registrase::class.java)
            startActivity(intent)
        }


    }
}