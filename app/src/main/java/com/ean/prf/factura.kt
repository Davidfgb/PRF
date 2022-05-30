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
import java.lang.Exception

class factura : AppCompatActivity() {
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factura)

        val boton_finalizar = findViewById<Button>(R.id.bn_recuperar_fc)
        var datos = findViewById<TextView>(R.id.textView_simm_fc)
        val id = findViewById<TextView>(R.id.editText_nombre_fc)
        val boton_confirmar = findViewById<TextView>(R.id.bn_confirmar_fc)
        val boton_volver = findViewById<Button>(R.id.bn_regresar_fc)
        val boton_pagar = findViewById<Button>(R.id.bn_recuperar_fc)
        var mensaje= findViewById<TextView>(R.id.textView3_fc)
        val identifi = id.text.toString()


        boton_pagar.setOnClickListener {
            mensaje.setText("su pedido ha sido registarado correctamente, ya estamos preparando su orden." +
                    "porfavor vuelva al menu principal y espere su llamado")
        }
        boton_volver.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }

        boton_confirmar.setOnClickListener {
            try {
                    val docRef = db.collection("pedidos").document(id.text.toString())
                    docRef.get()
                        .addOnSuccessListener { document ->
                            if (document != null) {
                                Log.d(ContentValues.TAG, "DocumentSnapshot data: ${document.data}")
                                datos.setText("${document.data}")
                            } else {
                                Log.d(ContentValues.TAG, "No such document")
                            }
                        }
                        .addOnFailureListener { exception ->
                            Log.d(ContentValues.TAG, "get failed with ", exception)
                        }

            }catch (e:Exception){
                datos.setText("el usuario ingresado no exite, por favor verifique")
            }
        }








    }
}