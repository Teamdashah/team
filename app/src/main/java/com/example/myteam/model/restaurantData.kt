package com.example.myteam.model

class restaurantData  {
    var name : String? = null
    var address : String? = null
    var phone : String? = null
    var avgPrice : Long? = null
    var coverUrl : String? = null
    constructor(){}

    constructor(
        name:String?,
        address:String?,
        phone:String?,
        avgPrice:Long?,
        coverUrl:String?
    ){
        this.name = name
        this.address = address
        this.phone = phone
        this.avgPrice = avgPrice
        this.coverUrl = coverUrl
    }
}