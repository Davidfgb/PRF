package com.ean.prf

import Mundo.paswords_iguales
import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Registrase : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrase)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val bn_regresar=findViewById<Button>(R.id.bn_regresar_rg)
        bn_regresar.setOnClickListener{
            val intent=Intent(this,MainActivity::class.java)
            startActivity(intent)
        }


        val txt_correo= findViewById<EditText>(R.id.editText_correo_rg)
        val txt_pasword= findViewById<EditText>(R.id.editText_pasword_rg)
        val txt_confirmar= findViewById<EditText>(R.id.editText_confrimar_pasword_rg)
        val boton_registrar= findViewById<Button>(R.id.bn_regitrar_rg)

        boton_registrar.setOnClickListener{
            try {
                val correo_r = txt_correo.text.toString().lowercase()
                val pasword_r = txt_pasword.text.toString()
                val confirmar_r = txt_confirmar.text.toString()
                if (correo_r.isEmpty() || pasword_r.isEmpty() || confirmar_r.isEmpty()) {
                    throw Exception("los campos estan vacios")
                } else {
                    if (paswords_iguales(pasword_r, confirmar_r)) {
                        auth.createUserWithEmailAndPassword(correo_r,pasword_r)
                            .addOnCompleteListener(this) { task ->
                                if (task.isSuccessful) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Toast.makeText(baseContext, "Usuario Creado.",
                                        Toast.LENGTH_SHORT).show()
                                    Log.d(ContentValues.TAG, "signInWithCustomToken:success")
                                    val user = auth.currentUser
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(ContentValues.TAG, "signInWithCustomToken:failure", task.exception)
                                    Toast.makeText(baseContext, "No se pudo registrar usuario",
                                        Toast.LENGTH_SHORT).show()
                                }
                            }
                    } else {
                        throw  Exception("Las contraseñas no coinciden")
                    }

                }
            }
            catch (e:Exception){

                Toast.makeText(this,e.message,Toast.LENGTH_SHORT).show()

            }
        }

    }

}