package com.asadullo.authorsapp.Models

import java.io.Serializable

class Author :Serializable{
    var imgLink:String? = null
    var authorName:String? = null
    var tugilgan:String? = null
    var vafot:String? = null
    var type:String? = null
    var about:String? = null



    constructor(imgLink: String?, authorName: String?, tugilgan: String?, vafot: String?) {
        this.imgLink = imgLink
        this.authorName = authorName
        this.tugilgan = tugilgan
        this.vafot = vafot
    }

    constructor()
    constructor(
        imgLink: String?,
        authorName: String?,
        tugilgan: String?,
        vafot: String?,
        type: String?,
        about: String?
    ) {
        this.imgLink = imgLink
        this.authorName = authorName
        this.tugilgan = tugilgan
        this.vafot = vafot
        this.type = type
        this.about = about
    }
}