package com.nyller.android.conversordemedidas.models

import com.nyller.android.conversordemedidas.models.strategies.CalculationStrategy

object Calculator {

    // Variável calculationStrategy pode ser nula e será iniciada nula
    private var calculationStrategy: CalculationStrategy? = null

    // Função para definir a estratégia de cálculo
    fun setCalculationStrategy(calculationStrategy: CalculationStrategy){
        this.calculationStrategy = calculationStrategy
    }

    // Função para fazer o cálculo
    fun calculate(value: Double) : Double {

        if (calculationStrategy == null)
            throw IllegalArgumentException("Estratégia de cálculo não definida")

        return calculationStrategy!!.calculate(value)

    }

}