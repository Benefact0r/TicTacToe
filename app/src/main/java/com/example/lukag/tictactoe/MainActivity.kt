package com.example.lukag.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun buClick(viev: View) {
        val buSelected = view as Button
        var cellID = 0
        when (buSelected.id) {
            R.id.but1 -> cellID = 1
            R.id.but2 -> cellID = 2
            R.id.but3 -> cellID = 3
            R.id.but4 -> cellID = 4
            R.id.but5 -> cellID = 5
            R.id.but6 -> cellID = 6
            R.id.but7 -> cellID = 7
            R.id.but8 -> cellID = 8
            R.id.but9 -> cellID = 9

        }

//        Toast.makeText(this,text:"Cell ID: "+cellID, Toast.LENGTH_LONG).show()
        playGame(cellID, buSelected)

    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var activePlayer = 1

    private fun playGame(cellID: Int, buSelected: Button) {

        if (activePlayer == 1) {
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.parseColor(colorString: "#009193"))
            player1.add(cellID)
            activePlayer = 2
            AutoPlay()
        } else {
            buSelected.text = "0"
            buSelected.setBackgroundColor(Color.parseColor(colorString: "#FF9300"))
            player2.add(cellID)
            activePlayer = 1
        }

        buSelected.isEnabled = false

        checkWinner();

    }

    private fun checkWinner() {
        var winner = -1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2
        }
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2
        }
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2
        }

        if (winner != -1){
            if (winner == 1){
                Toast.makeText(this,"Player 1 Won! ",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Player 2 Won! ",Toast.LENGTH_LONG).show()

            }
        }

    }

    private fun AutoPlay(){
        var emptyCells = ArrayList<Int>()
        for (cellID in 1..9){
            if (player1.contains(cellID) || player2.contains(cellID)){
                emptyCells.add(cellID)
            }
        }
        val r = Random()
        val randIndex = r.nextInt(emptyCells.size-0)+0
        val cellID = emptyCells(randIndex)

        val buSelected:Button
        when(cellID){
            1->buSelected = but1
            2->buSelected = but2
            3->buSelected = but3
            4->buSelected = but4
            5->buSelected = but5
            6->buSelected = but6
            7->buSelected = but7
            8->buSelected = but8
            9->buSelected = but9

            else -> buSelected = but1
        }
        playGame(cellID, buSelected)
    }

}


