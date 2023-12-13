package com.example.myappruben

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toolbar
import com.example.myappruben.CalculatorActivity.CalculatorActivity
import com.example.myappruben.ConversorActivity.ConversorActivity
import com.example.myappruben.imc.IMCActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnCalculosApp = findViewById<Button>(R.id.btnCalculosApp)
        btnCalculosApp.setOnClickListener { navigateToCalculatorApp() }
        var btnConversorApp = findViewById<Button>(R.id.btnConversorApp)
        btnConversorApp.setOnClickListener { navigateToConversorApp() }
        var btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        btnIMCApp.setOnClickListener { navigateToIMCApp() }

    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToCalculatorApp() {
        val intent = Intent(this,CalculatorActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToConversorApp() {
        val intent = Intent(this,ConversorActivity::class.java)
        startActivity(intent)
    }
}