package com.example.volunteeryapp.Models

class Opportunity {
    var id :String =""
    var title: String = ""
    var description: String = ""
    var location: String = ""
    var date:String =""
    var duration:String =""


    constructor(id:String ,title:String,description:String,location:String,date:String,duration:String){
        this.id  =id
        this.title =title
        this.description =description
        this.location =location
        this.date = date
        this.duration =duration
    }
    constructor()
}