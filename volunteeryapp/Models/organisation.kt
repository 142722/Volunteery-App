package com.example.volunteeryapp.Models

class organisation {
    var organizationId: String =""
    var name: String =""
    var description: String =""
    var contactInfo: String =""
    constructor(organizationId: String, name: String, description: String, contactInfo: String )
    {
        this.organizationId =organizationId
        this.name =name
        this.description =  description
        this.contactInfo =contactInfo
    }
    constructor()
}