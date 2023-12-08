package com.example.myappruben.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.myappruben.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.internal.ViewUtils.getBackgroundColor
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat
import kotlin.math.pow

class IMCActivity : AppCompatActivity() {

    private var isMaleSelected:Boolean= true
    private var isFemaleSelected:Boolean= false
    private var currentHeight:Int = 120
    private var currentAge:Int = 50
    private var currentWeight:Int = 65

    private lateinit var viewFemale : CardView
    private lateinit var viewMale : CardView
    private lateinit var tvHeight : TextView
    private lateinit var tvWeight : TextView
    private lateinit var tvAge : TextView
    private lateinit var btnCalculate : Button
    private lateinit var btnSubtractWeight: FloatingActionButton
    private lateinit var btnPlusWeight: FloatingActionButton
    private lateinit var btnSubtractAge: FloatingActionButton
    private lateinit var btnPlusAge: FloatingActionButton
    private lateinit var rsHeight: RangeSlider

    companion object{
        const val IMC_KEY= "IMCResultado"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcactivity)
        initComponent()
        initListener()
        initUI()
    }

    private fun initComponent(){
        tvHeight = findViewById(R.id.tvHeight)
        tvWeight = findViewById(R.id.tvWeight)
        tvAge = findViewById(R.id.tvAge)
        btnCalculate = findViewById(R.id.btnCalculate)
        btnSubtractWeight = findViewById(R.id.btnSubtractWeight)
        btnPlusWeight = findViewById(R.id.btnPlusWeight)
        btnSubtractAge = findViewById(R.id.btnSubtractAge)
        btnPlusAge = findViewById(R.id.btnPlusAge)
        rsHeight = findViewById(R.id.rsHeight)
        viewFemale = findViewById(R.id.ViewFemale)
        viewMale = findViewById(R.id.ViewMale)
    }
    private fun initListener(){
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            val df =DecimalFormat("#.##")
            currentHeight = df.format(value).toInt()
            tvHeight.text = "$currentHeight cm"
        }
        btnPlusWeight.setOnClickListener {
            currentWeight+=1
            setWeight()
        }
        btnSubtractWeight.setOnClickListener {
            currentWeight-=1
            setWeight()
        }
        btnPlusAge.setOnClickListener {
            currentAge += 1
            setAge()
        }
        btnSubtractAge.setOnClickListener {
            currentAge -= 1
            setAge()
        }
        btnCalculate.setOnClickListener {
            val imc = calculateIMC()
            navigateToResultadoIMC(imc)
        }
    }
    private fun initUI() {
        setGenderColor()
        setWeight()
        setAge()
    }

    private fun navigateToResultadoIMC(imc:Double) {
        val intent = Intent(this,ResultadoIMCActivity::class.java)
        startActivity(intent.putExtra(IMC_KEY,imc))
    }

    private fun calculateIMC(): Double {
        val imc = currentWeight/(currentHeight.toDouble().pow(2.0)/10000)
        val df = DecimalFormat("#.##")
        df.maximumFractionDigits = 2
        return df.format(imc).toDouble()
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }
    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(selected : Boolean) : Int{
        val colorReference = if( selected){
            R.color.background_component_selected
        }else{
            R.color.background_component
        }
        return ContextCompat.getColor(this,colorReference)
    }
}