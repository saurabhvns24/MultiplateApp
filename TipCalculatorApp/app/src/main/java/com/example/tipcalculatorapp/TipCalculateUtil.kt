package com.example.tipcalculatorapp

fun tipAmount(userAmount: String, tipPercentage: Float): String {
    return when {
        userAmount.isEmpty() -> {
            "0"
        }
        else -> {
            val amount = userAmount.toFloat()
            (amount * tipPercentage.div(100)).toString()
        }
    }
}

fun getTotalHeaderAmount(amount: String, personCounter: Int, tipPercentage: Float): String {
    return when {
        amount.isEmpty() -> {
            "0"
        }
        else -> {
            val amount = amount.toFloat()
            (amount + ((amount * tipPercentage).div(100))).div(personCounter)
                .toString()
        }
    }
}