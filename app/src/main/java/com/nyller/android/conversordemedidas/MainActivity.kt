package com.nyller.android.conversordemedidas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.nyller.android.conversordemedidas.models.Calculator
import com.nyller.android.conversordemedidas.models.strategies.CalculationStrategy
import com.nyller.android.conversordemedidas.models.strategies.KilometerToMeterStrategy

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculationStrategy = KilometerToMeterStrategy()

        Calculator.setCalculationStrategy(calculationStrategy)

        Log.i("Edu", "Resultado: ${Calculator.calculate(2.toDouble())}")


    }
}