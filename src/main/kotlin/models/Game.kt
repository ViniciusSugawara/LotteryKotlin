package models

//This class represents rules that a game will apply. maxNumber is the ceiling, limitOfNumbersDrawn is the quantity. price is the value that must be paid
data class Game (val maxNumber: Int, val limitOfNumbersDrawn: Int, val price: Double)