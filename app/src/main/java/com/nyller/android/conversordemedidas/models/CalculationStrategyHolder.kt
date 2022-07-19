package com.nyller.android.conversordemedidas.models

import com.nyller.android.conversordemedidas.models.strategies.CalculationStrategy

data class CalculationStrategyHolder (

    val name : String,
    val calculationStrategy: CalculationStrategy

)