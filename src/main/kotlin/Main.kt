import models.Player
import models.Ticket

fun main() {
    println("Sistema de loteria, adaptado para Kotlin.")
    val testTicket = Ticket()
    for(i in testTicket.numbers){
        println(i)
    }
    val allTickets = Array<Ticket>(5) { testTicket}
    val playerOne = Player("Josh", allTickets)
    println("The following player has been added: ${playerOne.name}")
}