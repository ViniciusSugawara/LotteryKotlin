import models.Game
import models.Player
import models.Ticket
import models.Randomizer

fun main() {
    println("Sistema de loteria, adaptado para Kotlin.")

    val game = Game(10, 2, 6.0)
    val ticketRandomizer = Randomizer(game.maxNumber, game.limitOfNumbersDrawn)
    val testTicket = Ticket(ticketRandomizer.randomizedNumbers)
    val anotherTicket = Ticket(ticketRandomizer.randomizedNumbers)

    println("First ticket: Numbers are")
    testTicket.numbers.forEach{
        println(it)
    }

    println("Second ticket: Numbers are")
    for(i in anotherTicket.numbers){
        println(i)
    }

    val allTickets: MutableSet<Ticket> = mutableSetOf(testTicket, anotherTicket)
    val playerOne = Player("Josh", allTickets)

    println("The following player has been added: ${playerOne.name}")

    val mainRandomizer = Randomizer(game.maxNumber, game.limitOfNumbersDrawn)

    val premiumTicket = Ticket(mainRandomizer.randomizedNumbers)
    premiumTicket.numbers.forEach{

        println("Numbers drawn were " + it)
    }

    for(ticket in allTickets){
        when(ticket.equals(premiumTicket)){
            true -> println("Has won")
            else -> println("Hasn't won")
        }
    }

}