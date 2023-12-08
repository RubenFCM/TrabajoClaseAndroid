package com.example.myappruben.ConversorActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.example.myappruben.R
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
}