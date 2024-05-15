package com.example.volunteeryapp.Models

class volunteer {
    var volunteerId: String =""
    var userId: String =""
    var eventId: String =""
    var dateTime: String =""
    var feedback: String? =""
    constructor(volunteerId: String, userId: String, eventId: String, dateTime: String, feedback: String?) {
        this.volunteerId = volunteerId
        this.userId = userId
        this.eventId = eventId
        this.dateTime = dateTime
        this.feedback = feedback
    }
    constructor()
}
