import models.Game
import models.Player
import models.Ticket
import services.RaffleService
import services.Randomizer
import services.Verifier

//TODO - remove logic from main class and work with other classes, to separate responsibilities
fun main() {
    println("Sistema de loteria, adaptado para Kotlin.")

    //Here, i create a game with the rules
    val mainGame = Game(10, 2, 6.0)

    //Here i create a randomizer that is applied to tickets, and two tickets.
    val ticketRandomizer = Randomizer(mainGame.maxNumber, mainGame.limitOfNumbersDrawn)
    val playerTicket = Ticket(ticketRandomizer.randomizedNumbers)
    val playerTicket2 = Ticket(ticketRandomizer.randomizedNumbers)

    //Here i create a set of Ticket that is given to a Player
    val playerTickets: MutableSet<Ticket> = mutableSetOf(playerTicket, playerTicket2)
    val playerOne = Player("Josh", playerTickets)

    //Here i create a raffleService, which will contain all the program logic.
    val raffleService = RaffleService(mainGame, playerOne)

    //Here i make the raffle happen, and at the same time, i know if someone has won.
    if(raffleService.executeRaffle()){
        println("${raffleService.player.name} has won!")
    } else {
        println("Nobody has won")
    }

    //Results shown here. Both the winner numbers and the numbers that were bet.
    println("Winner ticket was: ")
    raffleService.premiumTicket.numbers.forEach{
        print("$it, ")
    }
    println()
    println("Bet numbers were: ")
    for(ticket in raffleService.player.tickets){
        ticket.numbers.forEach{
            print("$it, ")
        }
        println()
    }
    println()
    print("The prize pool was ${mainGame.price * playerOne.tickets.size}")
}