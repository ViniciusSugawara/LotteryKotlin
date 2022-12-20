package models

class Game {
    val maxNumber: Int
    val numbersDrawed: Int
    val gamePrice: Double

    constructor(maxNumber: Int, numbersDrawed: Int, gamePrice: Double) {
        this.maxNumber = maxNumber
        this.numbersDrawed = numbersDrawed
        this.gamePrice = gamePrice
    }
}