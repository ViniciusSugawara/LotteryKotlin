package models

data class Player(val name: String) {
    lateinit var ticket: MutableSet<Ticket>

    constructor(name: String, ticket: MutableSet<Ticket>) : this(name){
        this.ticket = ticket
    }
}