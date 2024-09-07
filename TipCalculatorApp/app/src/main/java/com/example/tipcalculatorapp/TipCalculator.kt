package com.example.tipcalculatorapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)
@Composable
fun tipCalculator() {
    val amount = remember {
        mutableStateOf("")
    }
    val personCounter = remember {
        mutableStateOf(1)
    }
    val tipPercentage = remember {
        mutableStateOf(0f)
    }
    Column(modifier = Modifier.fillMaxSize()) {
        totalHeader(
            amount = getTotalHeaderAmount(
                amount.value, personCounter.value, tipPercentage = tipPercentage.value
            )
        )
        userInputArea(amount = amount.value,
            amountChange = { amount.value = it },
            personCounter = personCounter.value,
            onAddOrReducePerson = {
                if (it < 0) {
                    if (personCounter.value != 1) {
                        personCounter.value--
                    }
                } else {
                    personCounter.value++
                }
            },
            tipPercentage = tipPercentage.value,
            tipPercentageChange = {
                tipPercentage.value = it
            })
    }
}
@Composable
fun totalHeader(amount: String = "") {
    Surface(
        shape = RoundedCornerShape(size = 8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp),
        color = Color.Cyan
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Total per person",
                fontSize = 24.sp,
                fontStyle = FontStyle.Italic,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Text(
                modifier = Modifier.padding(top = 4.dp),
                text = "$ $amount",
                fontSize = 18.sp,
                fontStyle = FontStyle.Normal,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun userInputArea(
    amount: String = "",
    amountChange: (String) -> Unit,
    personCounter: Int,
    onAddOrReducePerson: (Int) -> Unit,
    tipPercentage: Float = 0f,
    tipPercentageChange: (Float) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = 12.dp,
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = amount,
                onValueChange = {
                    // Here, amountChange should handle the string input
                    amountChange(it)
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text(text = "Enter Your Amount") },
                keyboardOptions = KeyboardOptions(
                    autoCorrect = false, // Generally, you want to set autoCorrect to false for numerical input
                    keyboardType = KeyboardType.Number, imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {
                    keyboardController?.hide()
                })
            )
            if (amount.isNotBlank()) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Split", style = MaterialTheme.typography.body1)
                    Spacer(modifier = Modifier.fillMaxWidth(.50f))
                    CustomButton(imageVector = Icons.Default.KeyboardArrowUp) {
                        onAddOrReducePerson.invoke(1)
                    }
                    Text(
                        text = "$personCounter",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )
                    CustomButton(imageVector = Icons.Default.KeyboardArrowDown) {
                        onAddOrReducePerson.invoke(-1)
                    }
                }
                Spacer(modifier = Modifier.height(12.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Tip",
                        style = MaterialTheme.typography.body1,
                    )
                    Spacer(modifier = Modifier.fillMaxWidth(.70f))
                    Text(
                        text = "$ ${tipAmount(amount, tipPercentage)}",
                        style = MaterialTheme.typography.body1,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "$tipPercentage %",
                    style = MaterialTheme.typography.body1,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Slider(
                    value = tipPercentage,
                    onValueChange = {
                        tipPercentageChange.invoke(it)
                    },
                    valueRange = 0f..100f,
                    steps = 5,
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .fillMaxWidth()
                )
            }
        }
    }
}

@Composable
fun previewCustomButton() {
    CustomButton(imageVector = Icons.Default.KeyboardArrowDown) {

    }
}

@Composable
fun CustomButton(imageVector: ImageVector, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentSize()
            .padding(12.dp)
            .clickable { onClick.invoke() },
        shape = CircleShape
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = "",
            modifier = Modifier
                .size(30.dp)
                .padding(4.dp)
        )
    }
}