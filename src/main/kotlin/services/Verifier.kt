package services

import models.Player
import models.Ticket

//This class will be used as a verifier that says if someone has won, and which player took this spot.
class Verifier(val player: Player, val premiumTicket: Ticket) {
    //A simple method that verifies if the ticket is equal to a premiated ticket
    fun verifyRaffle(): Boolean {
        for(ticket in player.tickets){
            if(ticket == premiumTicket)
                return true
        }
        return false
    }
}