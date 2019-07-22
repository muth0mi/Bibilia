package com.ryanada.bibiliatakatifu.objects

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "verses")
class Verse {
    /* // JSON Sample
    {
        "id": "MAT.1.1",
        "orgId": "MAT.1.1",
        "bookId": "MAT",
        "chapterId": "MAT.1",
        "bibleId": "179568874c45066f-01",
        "reference": "Matthew 1:1"
    }
    */
    
    @PrimaryKey
    var id: String = ""
    var orgId: String = ""
    var bookId: String = ""
    var chapterId: String = ""
    var bibleId: String = ""
    var reference: String = ""
}

