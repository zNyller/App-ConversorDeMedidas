package com.nyller.android.conversordemedidas.models.strategies

interface CalculationStrategy {

    fun calculate (value : Double) : Double

    fun getResultLabel(isPlural : Boolean) : String

}