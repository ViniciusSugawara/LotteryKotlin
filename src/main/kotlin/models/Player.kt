package models

class Player {
    val name: String
    var ticket: Array<Ticket>

    constructor(name: String, ticket: Array<Ticket>){
        this.name = name
        this.ticket = ticket
    }
}