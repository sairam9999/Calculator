package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var resultEditText: EditText
    private lateinit var inputEditText: EditText
    private val displayOperation by lazy(LazyThreadSafetyMode.NONE) {findViewById<TextView>(R.id.operationTextView)}

//    Variables
    private var operand1: Double? = null
    private var operand2: Double = 0.0
    private var pendingOperation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultEditText = findViewById(R.id.resultEditText)
        inputEditText = findViewById(R.id.inputEditText)

        val button_0: Button = findViewById(R.id.button_0)
        val button_1: Button = findViewById(R.id.button_1)
        val button_2: Button = findViewById(R.id.button_2)
        val button_3: Button = findViewById(R.id.button_3)
        val button_4: Button = findViewById(R.id.button_4)
        val button_5: Button = findViewById(R.id.button_5)
        val button_6: Button = findViewById(R.id.button_6)
        val button_7: Button = findViewById(R.id.button_7)
        val button_8: Button = findViewById(R.id.button_8)
        val button_9: Button = findViewById(R.id.button_9)

        val buttonPlus: Button = findViewById(R.id.buttonPlus)
        val buttonMinus: Button = findViewById(R.id.buttonMinus)
        val buttonMul: Button = findViewById(R.id.buttonMul)
        val buttonDiv: Button = findViewById(R.id.buttonDiv)
        val buttonEquals: Button = findViewById(R.id.buttonEquals)
        val buttonDot: Button = findViewById(R.id.buttonDot)


        val listener = View.OnClickListener {v ->
            val b = v as Button
            inputEditText.append(b.text)
        }
        button_0.setOnClickListener(listener)
        button_1.setOnClickListener(listener)
        button_2.setOnClickListener(listener)
        button_3.setOnClickListener(listener)
        button_4.setOnClickListener(listener)
        button_5.setOnClickListener(listener)
        button_6.setOnClickListener(listener)
        button_7.setOnClickListener(listener)
        button_8.setOnClickListener(listener)
        button_9.setOnClickListener(listener)

        buttonDot.setOnClickListener(listener)

        val operationListener = View.OnClickListener { v ->
            val op = (v as Button).text.toString()
            val value = inputEditText.text.toString()
            if(value.isNotEmpty()) {
                performOperation(value, op)
            }
            pendingOperation = op
            displayOperation.text = pendingOperation
        }

        buttonPlus.setOnClickListener(operationListener)
        buttonMinus.setOnClickListener(operationListener)
        buttonMul.setOnClickListener(operationListener)
        buttonDiv.setOnClickListener(operationListener)
        buttonEquals.setOnClickListener(operationListener)
    }

    fun performOperation(value: String, operation: String) {
        displayOperation.text = operation
    }
}