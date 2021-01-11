package io.github.muth0mi.bibilia.data.room

import androidx.room.TypeConverter
import io.github.muth0mi.bibilia.data.emuns.Testament

class EmumConverters {

    @TypeConverter
    fun toTestament(value: String) = enumValueOf<Testament>(value)

    @TypeConverter
    fun fromTestament(value: Testament) = value.name
}