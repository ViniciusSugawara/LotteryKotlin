package models
//This class represents the ticket that will be used in the raffle, as a way to verify if someone has won.
data class Ticket(val numbers: MutableSet<Int>)