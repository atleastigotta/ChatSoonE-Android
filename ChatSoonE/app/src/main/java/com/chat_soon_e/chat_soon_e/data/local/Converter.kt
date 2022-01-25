package com.chat_soon_e.chat_soon_e.data.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import java.util.*
import kotlin.collections.LinkedHashMap

class Converter {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return if (date == null) null else date.getTime()
    }
}