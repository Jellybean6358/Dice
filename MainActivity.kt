package com.example.dice

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // button Sense
        val rollButton:Button=findViewById(R.id.button)
        rollButton.setOnClickListener {
            // button invokes
            rollDice() }
    }
    private fun rollDice(){
        val dice=Dice(6)//sending 6 to Dice class
        val diceRoll=dice.roll()//calling roll fun to run random

        val diceImage:ImageView=findViewById(R.id.imageView)//image sense
        val drawableResource=when(diceRoll)//conditions
        {
            1->R.drawable.dice_1
            2->R.drawable.dice_2
            3->R.drawable.dice_3
            4->R.drawable.dice_4
            5->R.drawable.dice_5
            else->R.drawable.dice_6//else is compulsory if when has val opn
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription=diceRoll.toString()


    }

}

class Dice(private val numSides: Int)//class gets 6
{
    fun roll():Int//process randoms
    {
        return(1..numSides).random()
    }


}
