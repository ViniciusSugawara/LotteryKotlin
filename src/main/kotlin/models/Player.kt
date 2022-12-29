package models

//This class represents the player. All players have a name.
data class Player(val name: String) {
    //ticket is defined as lateinit because initially, a player does not have a ticket. Could be called bets
    lateinit var tickets: MutableSet<Ticket>

    //player receives a set of tickets, which they use to play a game.
    constructor(name: String, ticket: MutableSet<Ticket>) : this(name){
        this.tickets = ticket
    }
}