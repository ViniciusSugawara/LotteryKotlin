import models.Game
import models.Player
import models.Ticket
import services.Randomizer
import services.Verifier

//TODO - remove logic from main class and work with other classes, to separate responsibilities
fun main() {
    println("Sistema de loteria, adaptado para Kotlin.")

    //Here, i create a game with the rules, a randomizer that is applied to tickets, and two tickets.
    val mainGame = Game(10, 2, 6.0)
    val ticketRandomizer = Randomizer(mainGame.maxNumber, mainGame.limitOfNumbersDrawn)
    val playerTicket = Ticket(ticketRandomizer.randomizedNumbers)
    val playerTicket2 = Ticket(ticketRandomizer.randomizedNumbers)

    println("First ticket: Numbers are:")
    playerTicket.numbers.forEach{
        print("$it, ")
    }

    println()

    println("Second ticket: Numbers are:")
    playerTicket2.numbers.forEach{
        print("$it, ")
    }

    println()
    //Here i create a set of Ticket that is given to a Player
    val playerTickets: MutableSet<Ticket> = mutableSetOf(playerTicket, playerTicket2)
    val playerOne = Player("Josh", playerTickets)

    println("The following player has been added: ${playerOne.name}")

    // Here i create a randomizer used ony for a determined raffle.
    val raffle = Randomizer(mainGame.maxNumber, mainGame.limitOfNumbersDrawn)

    //The premium ticket represents the numbers that will make someone win the prize, if the numbers coincide.
    val premiumTicket = Ticket(raffle.randomizedNumbers)

    print("Numbers drawn were: ")
    premiumTicket.numbers.forEach{
        print("$it, ")
    }

    println()

    //Refactored so that i use my verifier class to check if someone has won.
    val verifier = Verifier(playerOne, premiumTicket)
        if(verifier.verifyRaffle()){
            println("${verifier.player.name} has won!")
        } else {
            println("Nobody has won")
        }
    print("The prize pool was ${mainGame.price * playerOne.tickets.size}")

}