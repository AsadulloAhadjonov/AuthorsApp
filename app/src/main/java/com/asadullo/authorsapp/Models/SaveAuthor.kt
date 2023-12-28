package com.asadullo.authorsapp.Models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity
class SaveAuthor:Serializable {
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null
    var imgLink:String? = null
    var authorName:String? = null
    var tugilgan:String? = null
    var vafot:String? = null
    var type:String? = null
    var about:String? = null
    var idData:String? = null

    constructor(
        imgLink: String?,
        authorName: String?,
        tugilgan: String?,
        vafot: String?,
        type: String?,
        about: String?,
        id: String?
    ) {
        this.imgLink = imgLink
        this.authorName = authorName
        this.tugilgan = tugilgan
        this.vafot = vafot
        this.type = type
        this.about = about
        this.idData = id
    }

    constructor()
}