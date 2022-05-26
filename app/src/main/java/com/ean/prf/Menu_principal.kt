package com.ean.prf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Menu_principal : AppCompatActivity() {

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_principal)

        val boton_arroz = findViewById<Button>(R.id.bn_arroz_mp)
        val id = findViewById<TextView>(R.id.editText_id_mp)




        boton_arroz.setOnClickListener {
            val identi = id.text.toString()
            var verifi = findViewById<TextView>(R.id.textView_verifi_mp)
            try {
                //verifi.setText("Pato Registrado")
                if (identi.isEmpty()) {
                    verifi.setText("No se ha ingresado un id")
                } else {
                    db.collection("comidas").document(id.text.toString()).set(
                        hashMapOf(
                            "palto principal" to "arroz con pollo",
                        )
                    )
                    verifi.setText("Plato registrado")
                }
            }
            catch (e:Exception){

            }
        }




    }
}