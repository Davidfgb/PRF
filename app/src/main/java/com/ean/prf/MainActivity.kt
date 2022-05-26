package com.ean.prf

import android.content.ContentValues.TAG
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


class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        auth = Firebase.auth

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

        val correo_r = findViewById<EditText>(R.id.editText_correo_am)
        val pasword_r = findViewById<EditText>(R.id.editText_pasword_am)
        val boton_ingresar = findViewById<Button>(R.id.bn_entrar_am)
        boton_ingresar.setOnClickListener {
            try {
                val correo = correo_r.text.toString().lowercase()
                val pasword = pasword_r.text.toString()
                if (correo.isEmpty() || pasword.isEmpty()) {
                    throw Exception("Los campos no pueden estar Vacios!!")
                } else {
                    auth.signInWithEmailAndPassword(correo,pasword)
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                Toast.makeText(baseContext, "Bienvenido", Toast.LENGTH_SHORT).show()
                                // Sign in success, update UI with the signed-in user's information
                                Log.d(TAG, "signInWithCustomToken:success")

                                //updateUI(user)
                                val intent = Intent(this, Menu_principal::class.java)
                                startActivity(intent)
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w(TAG, "signInWithCustomToken:failure", task.exception)
                                Toast.makeText(baseContext, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show()
                                //updateUI(null)
                            }
                        }
                }


            }
            catch (e: Exception) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }
        }


        }



}