package com.ean.prf


import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
        val boton_paisa= findViewById<Button>(R.id.bn_paisa_mp)
        val boton_pasta= findViewById<Button>(R.id.bn_pasta_mp)
        val boton_ajiaco= findViewById<Button>(R.id.bn_ajiaco_mp)
        val boton_hamburguesa= findViewById<Button>(R.id.bn_hamburgesa_mp)
        val email = findViewById<TextView>(R.id.editText_correo_am)
        val boton_siguiente = findViewById<Button>(R.id.bn_siguiente_mp)

        val id = findViewById<TextView>(R.id.editText_id_mp)
        val comidas= arrayListOf<Pair<String,Int>>()
        val precios= arrayListOf<Int>()
        var valor_pedido = 0
        var i = 0




        boton_siguiente.setOnClickListener{
            val intent = Intent(this,factura::class.java)
            startActivity(intent)
        }



        boton_arroz.setOnClickListener {
            val identi = id.text.toString()
            var verifi = findViewById<TextView>(R.id.textView_verifi_mp)
            try {
                //verifi.setText("Pato Registrado")
                if (identi.isEmpty()) {
                    verifi.setText("No se ha ingresado un id")
                } else {
                    val pedidos = hashMapOf(
                        "principal" to comidas,
                        "precios" to precios
                    )
                    comidas.add(i,Pair("Arroz con Pollo",8900))
                    precios.add(i,8900)
                    i++
                    valor_pedido+=8900
                    db.collection("pedidos").document(id.text.toString())
                        .set(pedidos)
                        .addOnSuccessListener { Log.d(ContentValues.TAG, "DocumentSnapshot successfully written!") }
                        .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error writing document", e) }
                    verifi.setText("Plato registrado")

                }
            }
            catch (e:Exception){

            }
        }
        boton_paisa.setOnClickListener {
            val identi = id.text.toString()
            var verifi = findViewById<TextView>(R.id.textView_verifi_mp)
            try {
                //verifi.setText("Pato Registrado")
                if (identi.isEmpty()) {
                    verifi.setText("No se ha ingresado un id")
                } else {
                    val pedidos = hashMapOf(
                        "principal" to comidas,
                        "precios" to precios,
                    )
                    comidas.add(i,Pair("Bandeja Paisa",10000))
                    precios.add(i,10000)
                    i++
                    valor_pedido+=10000
                    db.collection("pedidos").document(id.text.toString())
                        .set(pedidos)
                        .addOnSuccessListener { Log.d(ContentValues.TAG, "DocumentSnapshot successfully written!") }
                        .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error writing document", e) }
                    verifi.setText("Plato registrado")

                }
            }
            catch (e:Exception){

            }
        }
        boton_pasta.setOnClickListener {
            val identi = id.text.toString()
            var verifi = findViewById<TextView>(R.id.textView_verifi_mp)
            try {
                //verifi.setText("Pato Registrado")
                if (identi.isEmpty()) {
                    verifi.setText("No se ha ingresado un id")
                } else {
                    val pedidos = hashMapOf(
                        "principal" to comidas,
                        "precios" to precios,
                    )
                    comidas.add(i,Pair("Pasta",9500))
                    precios.add(i,9500)
                    i++
                    valor_pedido+=9500
                    db.collection("pedidos").document(id.text.toString())
                        .set(pedidos)
                        .addOnSuccessListener { Log.d(ContentValues.TAG, "DocumentSnapshot successfully written!") }
                        .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error writing document", e) }
                    verifi.setText("Plato registrado")

                }
            }
            catch (e:Exception){

            }
        }
        boton_ajiaco.setOnClickListener {
            val identi = id.text.toString()
            var verifi = findViewById<TextView>(R.id.textView_verifi_mp)
            try {
                //verifi.setText("Pato Registrado")
                if (identi.isEmpty()) {
                    verifi.setText("No se ha ingresado un id")
                } else {
                    val pedidos = hashMapOf(
                        "principal" to comidas,
                        "precios" to precios,
                    )
                    comidas.add(i,Pair("Ajiaco",7500))
                    precios.add(i,7500)
                    i++
                    valor_pedido+=7500
                    db.collection("pedidos").document(id.text.toString())
                        .set(pedidos)
                        .addOnSuccessListener { Log.d(ContentValues.TAG, "DocumentSnapshot successfully written!") }
                        .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error writing document", e) }
                    verifi.setText("Plato registrado")

                }
            }
            catch (e:Exception){

            }
        }
        boton_hamburguesa.setOnClickListener {
            val identi = id.text.toString()
            var verifi = findViewById<TextView>(R.id.textView_verifi_mp)
            try {
                //verifi.setText("Pato Registrado")
                if (identi.isEmpty()) {
                    verifi.setText("No se ha ingresado un id")
                } else {
                    val pedidos = hashMapOf(
                        "principal" to comidas,
                        "precios" to precios,
                    )
                    comidas.add(i,Pair("Hamburgueza",7500))
                    precios.add(i,7500)
                    i++
                    valor_pedido+=7500
                    db.collection("pedidos").document(id.text.toString())
                        .set(pedidos)
                        .addOnSuccessListener { Log.d(ContentValues.TAG, "DocumentSnapshot successfully written!") }
                        .addOnFailureListener { e -> Log.w(ContentValues.TAG, "Error writing document", e) }
                    verifi.setText("Plato registrado")

                }
            }
            catch (e:Exception){

            }
        }




    }
}