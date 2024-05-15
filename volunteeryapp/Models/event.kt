package com.example.volunteeryapp.Models
class event {
    var eventId: String =""
    var title: String = ""
    var description: String =""
    var location: String = ""
    var dateTime: String = ""
    var organizerId: String =""
    var participants: String=""


    constructor( eventId: String, title: String, description: String, location: String, dateTime: String, organizerId: String, imageUrl: String, participants:String
    ){
        this.eventId = eventId
        this.title = title
        this.description =description
        this.location =location
        this.dateTime =dateTime
        this.organizerId =organizerId
        this.participants =participants
    }
    constructor()
}