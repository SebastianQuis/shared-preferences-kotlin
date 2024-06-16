package com.example.preferences

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // INSTANCIAR LA PREFERENCIA
        var editTextNombre = findViewById<TextView>(R.id.editTextNombre)
        var switchMayorEdad = findViewById<Switch>(R.id.switchMayorEdad)
        var switchComprarInternet = findViewById<Switch>(R.id.switchComprarInternet)
        var buttonConfirmar = findViewById<Button>(R.id.buttonConfirmar)

        var prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE)
        editTextNombre.text = prefs.getString("nombre", "sin nombre")
        switchMayorEdad.isChecked = prefs.getBoolean("mayorEdad", false)
        switchComprarInternet.isChecked = prefs.getBoolean("compraInt", false)

        buttonConfirmar.setOnClickListener {
            // CREANDO CLASE Y MANIPULANDO EL EDITOR
            var prefs = getSharedPreferences("preferences", Context.MODE_PRIVATE)
            var editor = prefs.edit()

            // REGISTRANDO SU CLAVE Y VALOR
            editor.putString("nombre", editTextNombre.text.toString())
            editor.putBoolean("mayorEdad", switchMayorEdad.isChecked)
            editor.putBoolean("compraInt", switchComprarInternet.isChecked)

            // GUARDANDO LOS DATOS.
            editor.commit()

            Toast.makeText(this, "Datos guardados :)", Toast.LENGTH_SHORT).show()
        }


    }
}