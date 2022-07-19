package com.nyller.android.conversordemedidas

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.nyller.android.conversordemedidas.databinding.ActivityMainBinding
import com.nyller.android.conversordemedidas.models.CalculationStrategyHolder
import com.nyller.android.conversordemedidas.models.Calculator
import com.nyller.android.conversordemedidas.models.strategies.KilometerToCentimeterStrategy
import com.nyller.android.conversordemedidas.models.strategies.KilometerToMeterStrategy
import com.nyller.android.conversordemedidas.models.strategies.MeterToCentimeterStrategy
import com.nyller.android.conversordemedidas.models.strategies.MeterToKilometerStrategy
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val supportedCalculationStrategies = arrayOf(
        CalculationStrategyHolder("Quilômetros para centímetros", KilometerToCentimeterStrategy()),
        CalculationStrategyHolder("Quilômetros para metros", KilometerToMeterStrategy()),
        CalculationStrategyHolder("Metros para centímetros", MeterToCentimeterStrategy()),
        CalculationStrategyHolder("Metros para quilômetros", MeterToKilometerStrategy()),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUi()

        setActions()

    }

    private fun setActions() {

        binding.btnConvert.setOnClickListener { convert() }

        binding.btnClean.setOnClickListener { clean() }

    }

    private fun convert() {
        try {
            val value = binding.editValue.text.toString().toDouble()

            // Recuperar a estratégia de cálculo do Spinner e settar no Calculator
            val calculationStrategy = supportedCalculationStrategies[
                    binding.spConversions.selectedItemPosition
            ].calculationStrategy

            Calculator.setCalculationStrategy(calculationStrategy)

            val result = Calculator.calculate(value)
            val label = calculationStrategy.getResultLabel(result != 1.toDouble())

            showResult(result, label)

        }catch (e: NumberFormatException){
            binding.editValue.error = "Valor inválido!"
            binding.editValue.requestFocus()
        }
    }

    private fun clean() {
        binding.editValue.setText ("")
        binding.editValue.error = null

        binding.spConversions.setSelection(0)
    }

    private fun showResult(result: Double, label: String) {

        val intent = Intent(this, ResultActivity::class.java)
        intent.putExtra("RESULT", result)
        intent.putExtra("LABEL", label)

        startActivity(intent)

    }

    private fun setUi() {

        // Adapter do Spinner
        val spAdapter = ArrayAdapter(this, R.layout.spinner_item, getSpinnerData())
        spAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spConversions.adapter = spAdapter

    }

    private fun getSpinnerData(): MutableList<String> {
        val spinnerData = mutableListOf<String>()

        supportedCalculationStrategies.forEach {
            spinnerData.add(it.name)
        }
        return spinnerData
    }

}