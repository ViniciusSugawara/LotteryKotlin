package services

import models.Game
import models.Player
import models.Ticket
//This class is responsible for the logic involved in a raffle. It receives a game so that it knows which restrictions to follow,
//And a player which already has the tickets.
class RaffleService(val game: Game, val player: Player) {
    //The premium ticket represents the numbers that will make someone win the prize, if the numbers coincide.
    lateinit var premiumTicket: Ticket

    //This method has the logic that makes the game work. It uses a randomizer to get the winner number, and returns if someone has won
    //Based on the return of the Verifier class introduced previously.
    fun executeRaffle(): Boolean{
        // Here i create a randomizer used only for a determined raffle.
        val raffle = Randomizer(game.maxNumber, game.limitOfNumbersDrawn)

        //Generated the premium ticket
        this.premiumTicket = Ticket(raffle.randomizedNumbers)

        //Using verifier class to see if someone has won
        val verifier = Verifier(player, premiumTicket)
        return verifier.verifyRaffle()
    }
}