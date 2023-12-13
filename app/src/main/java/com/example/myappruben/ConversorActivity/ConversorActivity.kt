package com.example.myappruben.ConversorActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import com.example.myappruben.CalculatorActivity.CalculatorActivity
import com.example.myappruben.MainActivity
import com.example.myappruben.R
import com.example.myappruben.imc.IMCActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.DecimalFormat

class ConversorActivity : AppCompatActivity() {

    private  lateinit var etCantidadEuro: EditText
    private  lateinit var btnLibra: FloatingActionButton
    private  lateinit var btnRublo: FloatingActionButton
    private  lateinit var btnYen: FloatingActionButton
    private  lateinit var btnDollar: FloatingActionButton
    private  lateinit var tvResultadoConversion: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor)
        initComponent()
        initListener()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_Home -> {
                navigateToHome()
                true
            }
            R.id.action_Calculator -> {
                navigateToCalculatorApp()
                true
            }
            R.id.action_Conversor -> {
                navigateToConversorApp()
                true
            }R.id.action_IMC -> {
                navigateToIMCApp()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initComponent(){
        etCantidadEuro = findViewById(R.id.etCantidadEuro)
        btnLibra = findViewById(R.id.btnLibra)
        btnRublo = findViewById(R.id.btnRublo)
        btnYen = findViewById(R.id.btnYen)
        btnDollar = findViewById(R.id.btnDollar)
        tvResultadoConversion = findViewById(R.id.tvResultadoConversion)
    }

    private fun initListener(){
        btnLibra.setOnClickListener {
            val num1:Double = etCantidadEuro.text.toString().toDoubleOrNull() ?: 0.0
            val df = DecimalFormat("#.##")
            "${df.format(((num1 * 1.06) * 100.0) / 100.0)} £".also { tvResultadoConversion.text = it }
        }
        btnRublo.setOnClickListener {
            val num1:Double = etCantidadEuro.text.toString().toDoubleOrNull() ?: 0.0
            val df = DecimalFormat("#.##")
            "${df.format(num1 * 98.8)} ₽".also { tvResultadoConversion.text = it }
        }
        btnYen.setOnClickListener {
            val num1:Double = etCantidadEuro.text.toString().toDoubleOrNull() ?: 0.0
            val df = DecimalFormat("#.##")
            "${df.format(num1 * 158.54)} ¥".also { tvResultadoConversion.text = it }
        }
        btnDollar.setOnClickListener {
            val num1:Double = etCantidadEuro.text.toString().toDoubleOrNull() ?: 0.0
            val df = DecimalFormat("#.##")
            "${df.format((num1 * 0.87) * 100.0 / 100.0)} $".also { tvResultadoConversion.text = it }
        }
    }
    private fun navigateToIMCApp() {
        val intent = Intent(this, IMCActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToCalculatorApp() {
        val intent = Intent(this, CalculatorActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToConversorApp() {
        val intent = Intent(this, ConversorActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}