package com.example.cc5_rizqy.data.controller

class Controller(private val callback: Callback) {
    fun rules(player1: String, computer: String) {
        val status = when {
            computer == "Gunting" && player1 == "Kertas" ||
                    computer == "Batu" && player1== "Gunting" ||
                    computer == "Kertas" && player1 == "Batu" -> "Player 2 Winner"
            player1 == "Gunting" && computer == "Kertas" ||
                    player1 == "Batu" && computer == "Gunting" ||
                    player1 == "Kertas" && computer == "Batu" -> "Player 1 Winner"
            else -> "Draw"
        }
        callback.sendStatus(status)
    }
}
