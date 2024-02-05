package com.example.guicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var sign : String
    private var firstNum : Double = 0.0
    private var secondNum : Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sign = ""
        val oneButton: Button = findViewById(R.id.one)
        val twoButton: Button = findViewById(R.id.two)
        val threeButton: Button = findViewById(R.id.three)
        val fourButton: Button = findViewById(R.id.four)
        val fiveButton: Button = findViewById(R.id.five)
        val sixButton: Button = findViewById(R.id.six)
        val sevenButton: Button = findViewById(R.id.seven)
        val eightButton: Button = findViewById(R.id.eight)
        val nineButton: Button = findViewById(R.id.nine)
        val dotButton: Button = findViewById(R.id.dot)
        val minusButton: Button = findViewById(R.id.minus)
        val plusButton: Button = findViewById(R.id.plus)
        val divideButton: Button = findViewById(R.id.divide)
        val multiButton: Button = findViewById(R.id.times)
        val zeroButton: Button = findViewById(R.id.zero)
        val sqrtButton: Button = findViewById(R.id.sqrt)
        val textBox: EditText = findViewById(R.id.top)
        val equalButton : Button = findViewById(R.id.equals)
        val clearButton : Button = findViewById(R.id.clear)
        var hasDot: Boolean = false

        oneButton.setOnClickListener { view: View ->
            textBox.setText(textBox.text.toString() + "1")
        }
        twoButton.setOnClickListener { view: View ->
            textBox.setText(textBox.text.toString() + "2")
        }
        threeButton.setOnClickListener { view: View ->
            textBox.setText(textBox.text.toString() + "3")
        }
        fourButton.setOnClickListener { view: View ->
            textBox.setText(textBox.text.toString() + "4")
        }
        fiveButton.setOnClickListener { view: View ->
            textBox.setText(textBox.text.toString() + "5")
        }
        sixButton.setOnClickListener { view: View ->
            textBox.setText(textBox.text.toString() + "6")
        }
        sevenButton.setOnClickListener { view: View ->
            textBox.setText(textBox.text.toString() + "7")
        }
        eightButton.setOnClickListener { view: View ->
            textBox.setText(textBox.text.toString() + "8")
        }
        nineButton.setOnClickListener { view: View ->
            textBox.setText(textBox.text.toString() + "9")
        }
        zeroButton.setOnClickListener { view: View ->
            textBox.setText(textBox.text.toString() + "0")
        }
        dotButton.setOnClickListener { view: View ->
            if (!hasDot) {
                textBox.setText(textBox.text.toString() + ".")
                hasDot = true
            }
            else {
                Toast.makeText(
                    this,
                    "ALREADY HAS DECIMAL POINT",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
        plusButton.setOnClickListener { view: View ->
            if (textBox.text.toString() == "") {
                Toast.makeText(
                    this,
                    "NO NUMBER TO OPERATE ON",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                firstNum = textBox.text.toString().toDouble()
                sign = "+"
                textBox.setText("")
                hasDot = false
            }
        }
        minusButton.setOnClickListener { view: View ->
            if (textBox.text.toString() == "") {
                Toast.makeText(
                    this,
                    "NO NUMBER TO OPERATE ON",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                firstNum = textBox.text.toString().toDouble()
                sign = "-"
                textBox.setText("")
                hasDot = false
            }
        }
        multiButton.setOnClickListener { view: View ->
            if (textBox.text.toString() == "") {
                Toast.makeText(
                    this,
                    "NO NUMBER TO OPERATE ON",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                firstNum = textBox.text.toString().toDouble()
                sign = "*"
                textBox.setText("")
                hasDot = false
            }
        }
        divideButton.setOnClickListener { view: View ->
            if (textBox.text.toString() == "") {
                Toast.makeText(
                    this,
                    "NO NUMBER TO OPERATE ON",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                firstNum = textBox.text.toString().toDouble()
                sign = "/"
                textBox.setText("")
                hasDot = false
            }
        }
        sqrtButton.setOnClickListener { view:View ->
            if (textBox.text.toString() == "") {
                Toast.makeText(
                    this,
                    "NO NUMBER TO SQUARE ROOT",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                firstNum = textBox.text.toString().toDouble()
                var ans: Double = sqrt(firstNum)
                textBox.setText(ans.toString())
            }
        }
        equalButton.setOnClickListener { view:View ->
            if (textBox.text.toString() == "" || sign == "") {
                Toast.makeText(
                    this,
                    "YOU DID NOT ENTER A VALID EQUATION",
                    Toast.LENGTH_LONG
                ).show()
            } else {
                secondNum = textBox.text.toString().toDouble()
                if (sign == "/") {
                    if (secondNum == 0.0) {
                        Toast.makeText(
                            this,
                            "DIVISION BY ZERO NOT ALLOWED",
                            Toast.LENGTH_LONG
                        ).show()
                    } else
                        textBox.setText((firstNum / secondNum).toString())
                } else if (sign == "*")
                    textBox.setText((firstNum * secondNum).toString())
                else if (sign == "-")
                    textBox.setText((firstNum - secondNum).toString())
                else if (sign == "+")
                    textBox.setText((firstNum + secondNum).toString())
                else if (sign == "%")
                    textBox.setText((firstNum % secondNum).toString())
                hasDot = true
            }
        }
        clearButton.setOnClickListener { view:View ->
            firstNum = 0.0
            secondNum = 0.0
            sign = ""
            textBox.setText("")
            hasDot = false
        }
    }
}