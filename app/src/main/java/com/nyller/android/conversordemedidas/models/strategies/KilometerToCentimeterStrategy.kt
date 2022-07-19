package com.nyller.android.conversordemedidas.models.strategies

class KilometerToCentimeterStrategy : CalculationStrategy {

    override fun calculate(value: Double): Double = value * 100_000

    override fun getResultLabel(isPlural: Boolean): String =
        if (isPlural) "centímetros" else "centímetro"

}