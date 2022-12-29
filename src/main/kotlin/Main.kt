import models.Game
import models.Player
import models.Ticket
import models.Randomizer

fun main() {
    println("Sistema de loteria, adaptado para Kotlin.")

    val mainGame = Game(10, 2, 6.0)
    val ticketRandomizer = Randomizer(mainGame.maxNumber, mainGame.limitOfNumbersDrawn)
    val playerTicket = Ticket(ticketRandomizer.randomizedNumbers)
    val playerTicket2 = Ticket(ticketRandomizer.randomizedNumbers)

    println("First ticket: Numbers are:")
    playerTicket.numbers.forEach{
        print("$it, ")
    }

    println("Second ticket: Numbers are:")
    for(i in playerTicket2.numbers){
        print("$i, ")
    }

    val playerTickets: MutableSet<Ticket> = mutableSetOf(playerTicket, playerTicket2)
    val playerOne = Player("Josh", playerTickets)

    println("The following player has been added: ${playerOne.name}")

    val raffle = Randomizer(mainGame.maxNumber, mainGame.limitOfNumbersDrawn)

    val premiumTicket = Ticket(raffle.randomizedNumbers)

    premiumTicket.numbers.forEach{
        println("Numbers drawn were " + it)
    }

    for(ticket in playerTickets){
        when(ticket.equals(premiumTicket)){
            true -> println("Has won")
            else -> println("Hasn't won")
        }
    }

}