package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    lateinit var diceImage :ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rollbutton :Button  = findViewById(R.id.rollButton)
        rollbutton.text ="Lets Roll"
        rollbutton.setOnClickListener {
            Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show()
            rollDice()
        }
        diceImage =findViewById(R.id.dice_Image)
    }

    private fun rollDice() {

       // val randomInt = Random().nextInt(6)+1 -> by clicking on inline variable we can set whole variable inside when only


        val drawableResourse = when(Random().nextInt(6)+1)
        {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            6 -> R.drawable.dice_6
            else-> R.drawable.empty_dice
        }


        diceImage.setImageResource(drawableResourse)


    }


}