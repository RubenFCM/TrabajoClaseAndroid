package com.example.myappruben.CalculatorActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.example.myappruben.ConversorActivity.ConversorActivity
import com.example.myappruben.MainActivity
import com.example.myappruben.R
import com.example.myappruben.imc.IMCActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.DecimalFormat

class CalculatorActivity : AppCompatActivity() {
    private lateinit var tvNumUno : EditText
    private lateinit var tvNumDos : EditText
    private lateinit var tvResult : TextView
    private lateinit var btnSum : FloatingActionButton
    private lateinit var btnRest : FloatingActionButton
    private lateinit var btnMult : FloatingActionButton
    private lateinit var btnDiv : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
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
        tvNumUno = findViewById(R.id.numUno)
        tvNumDos = findViewById(R.id.numDos)
        tvResult = findViewById(R.id.tvResult)
        btnSum = findViewById(R.id.btnSum)
        btnRest = findViewById(R.id.btnRest)
        btnDiv = findViewById(R.id.btnDiv)
        btnMult = findViewById(R.id.btnMult)

    }

    private fun initListener(){
        btnSum.setOnClickListener {
            val num1:Double = tvNumUno.text.toString().toDoubleOrNull() ?: 0.0
            val num2:Double = tvNumDos.text.toString().toDoubleOrNull() ?: 0.0
            val df = DecimalFormat("#.##")
            tvResult.text= df.format(num1+num2)
        }
        btnRest.setOnClickListener {
            val num1:Double = tvNumUno.text.toString().toDoubleOrNull() ?: 0.0
            val num2:Double = tvNumDos.text.toString().toDoubleOrNull() ?: 0.0
            val df = DecimalFormat("#.##")
            tvResult.text= df.format(num1-num2)
        }
        btnMult.setOnClickListener {
            val num1:Double = tvNumUno.text.toString().toDoubleOrNull() ?: 0.0
            val num2:Double = tvNumDos.text.toString().toDoubleOrNull() ?: 0.0
            val df = DecimalFormat("#.##")
            tvResult.text= df.format(num1*num2)
        }
        btnDiv.setOnClickListener {
            val num1:Double = tvNumUno.text.toString().toDoubleOrNull() ?: 0.0
            val num2:Double = tvNumDos.text.toString().toDoubleOrNull() ?: 0.0
            val df = DecimalFormat("#.##")
            tvResult.text= df.format(num1/num2)
        }
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
        val intent = Intent(this, ConversorActivity::class.java)
        startActivity(intent)
    }
    private fun navigateToHome() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}