package com.ryanada.bibiliatakatifu.objects

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chapters")
class Chapter {
    /* // JSON Sample
     {
        "id": "LUK.intro",
        "bibleId": "179568874c45066f-01",
        "bookId": "LUK",
        "number": "intro",
        "reference": "Luke"
     }
    */

    @PrimaryKey
    var id: String = ""
    var bibleId: String = ""
    var bookId: String = ""
    var number: String = ""
    var reference: String = ""
}

