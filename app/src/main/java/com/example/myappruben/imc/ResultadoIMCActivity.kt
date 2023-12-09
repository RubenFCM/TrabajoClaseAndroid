package com.example.myappruben.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.myappruben.R
import com.example.myappruben.imc.IMCActivity.Companion.IMC_KEY

class ResultadoIMCActivity : AppCompatActivity() {

    private lateinit var tvResult : TextView
    private lateinit var tvIMC : TextView
    private lateinit var tvDescription : TextView
    private lateinit var btnRecalculate : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado_imcactivity)
        val imc :Double =(intent.extras?.getDouble(IMC_KEY) ?: -1.0)
        initComponent()
        iniListener()
        initUI(imc)
    }

    private fun initComponent(){
        tvResult = findViewById(R.id.tvRsult)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescription = findViewById(R.id.tvDescription)
        btnRecalculate = findViewById(R.id.btnRecalculate)
    }
    private fun iniListener(){
        btnRecalculate.setOnClickListener {
            onBackPressedDispatcher.onBackPressed()
        }
    }
    private fun initUI(resultado:Double){
        tvIMC.text = resultado.toString()
        when(resultado){
            in 0.00..18.50 ->{
                tvResult.text = getString(R.string.bajoPeso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.bajoPeso))
                tvDescription.text = getString((R.string.descriptionBajoPeso))
            }
            in 18.51..24.99 ->{
                tvResult.text = getString(R.string.nomalPeso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.pesoNormal))
                tvDescription.text = getString(R.string.descriptionNormalPeso)
            }
            in 25.00..29.99 ->{
                tvResult.text = getString(R.string.sobrepeso)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.sobrepeso))
                tvDescription.text = getString(R.string.descriptionSobrepeso)
            }
            in 30.00..99.99 ->{
                tvResult.text = getString(R.string.obesidad)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.obesidad))
                tvDescription.text = getString(R.string.descriptionObesidad)
            }else -> {
                tvResult.text = getString(R.string.error)
                tvDescription.text = getString(R.string.error)
                tvIMC.text = getString(R.string.error)
            }
        }
    }
}