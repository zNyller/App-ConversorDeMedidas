package com.nyller.android.conversordemedidas.models.strategies

class MeterToCentimeterStrategy : CalculationStrategy {

    override fun calculate(value: Double): Double = value * 100

    override fun getResultLabel(isPlural: Boolean): String =
        if (isPlural) "centímetros" else "centímetro"

}