package com.ryanada.bibiliatakatifu.objects

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books")
class Book {
    /* // JSON Sample
    "id": "GEN",
    "bibleId": "179568874c45066f-01",
    "abbreviation": "Gen",
    "name": "Genesis",
    "nameLong": "The First Book of Moses, Commonly Called Genesis"
    */
    
    @PrimaryKey
    var id: String = ""
    var bibleId: String = ""
    var abbreviation: String = ""
    var name: String = ""
    var nameLong: String = ""
}

