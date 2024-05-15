package com.example.volunteeryapp.Models

class User {
    var fullname :String=""
    var email: String = ""
    var password: String = ""
    var id:String =""





    constructor(fullname:String,email:String,password:String,id:String){
        this.fullname =fullname
        this.email = email
        this.password= password
        this.id =id

    }
    constructor()
}